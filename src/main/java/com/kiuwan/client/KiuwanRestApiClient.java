package com.kiuwan.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.DeserializationConfig;

import com.kiuwan.client.model.AnalysisComparation;
import com.kiuwan.client.model.Application;
import com.kiuwan.client.model.ApplicationDefects;
import com.kiuwan.client.model.ApplicationFiles;
import com.kiuwan.client.model.ApplicationResults;
import com.kiuwan.client.model.Defect;
import com.kiuwan.client.model.File;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class KiuwanRestApiClient {
	
	protected static final String REST_API_BASE_URL = "https://api.kiuwan.com";
	protected WebResource connection;
	// Reusable Jackson Mapper
    protected static final ObjectMapper mapper = new ObjectMapper();

    
    public KiuwanRestApiClient(String user, String password) {
		initializeConnection(user, password, REST_API_BASE_URL);
	}
	
	public KiuwanRestApiClient(String user, String password, String restApiBaseUrl) {
		initializeConnection(user, password, restApiBaseUrl);
	}

    public KiuwanRestApiClient(String user, String password, String proxyHost, String proxyPort) {
    	System.setProperty("https.proxyHost", proxyHost);
    	System.setProperty("https.proxyPort", proxyPort);

    	initializeConnection(user, password, REST_API_BASE_URL);
	}

    public KiuwanRestApiClient(String user, String password, String proxyHost, String proxyPort, String proxyUser, String proxyPassword) {
    	System.setProperty("https.proxyHost", proxyHost);
    	System.setProperty("https.proxyPort", proxyPort);
    	System.setProperty("https.proxyUser", proxyUser);
		System.setProperty("https.proxyPassword", proxyPassword);
		
    	initializeConnection(user, password, REST_API_BASE_URL);
	}

	public void activateLog() {
		connection.addFilter(new LoggingFilter());
	}
	
	
	public List<Application> getApplications() throws KiuwanClientException {

		String path = "/apps/list";

		ClientResponse response = get(path);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readApplications(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	
	public ApplicationResults getApplicationResults(String appName) throws KiuwanClientException {

		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		String path = "/apps/" + appName;

		return requestAndBuildApplicationResults(path);
	}
	
	public ApplicationResults getApplicationResultsByAnalysisCode(String analysisCode) throws KiuwanClientException {

		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}
		
		String path = "/apps/analysis/" + analysisCode;
		return requestAndBuildApplicationResults(path);
	}
	
	public ApplicationResults requestAndBuildApplicationResults(String path) throws KiuwanClientException {
		ClientResponse response = get(path);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readApplication(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	public AnalysisComparation requestAndBuildAnalysisComparation(String path) throws KiuwanClientException {
		ClientResponse response = get(path);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readAnalysisComparation(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	
	public List<File> getAllFiles(String appName) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		List<File> files = new ArrayList<File>();
		
		int page = 1;
		int count = 0;
		do {
			
			ApplicationFiles appFiles = getApplicationFilesPage(appName, page++, 500);
			if (appFiles == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = appFiles.getFiles().size();
			files.addAll(appFiles.getFiles());
			
		} while (count == 500);
		
		return files;
	}
	
	
	public List<File> getAllAnalysisFiles(String analysisCode) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}
		
		List<File> files = new ArrayList<File>();
		
		int page = 1;
		int count = 0;
		do {
			
			ApplicationFiles appFiles = getAnalysisFilesPage(analysisCode, page++, 500);
			if (appFiles == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = appFiles.getFiles().size();
			files.addAll(appFiles.getFiles());
			
		} while (count == 500);
		
		return files;
	}

	
	private ApplicationFiles getApplicationFilesPage(String appName, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		String path = "/apps/" + appName + "/files";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		ClientResponse response = get(path, queryParams);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readApplicationFiles(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	private ApplicationFiles getAnalysisFilesPage(String analysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}

		String path = "/apps/analysis/" + analysisCode + "/files";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		ClientResponse response = get(path, queryParams);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readApplicationFiles(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}

	private ApplicationFiles readApplicationFiles(InputStreamReader isr) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(isr, new TypeReference<ApplicationFiles>() {
        });
	}
	

	
	public List<Defect> getAllDefects(String appName) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		List<Defect> defects = new ArrayList<Defect>();
		
		int page = 1;
		int count = 0;
		do {
			
			ApplicationDefects appDefects = getApplicationDefectsPage(appName, page++, 500);
			if (appDefects == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = appDefects.getDefects().size();
			defects.addAll(appDefects.getDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	public List<Defect> getAllAnalysisDefects(String analysisCode) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}
		
		List<Defect> defects = new ArrayList<Defect>();
		
		int page = 1;
		int count = 0;
		do {
			
			ApplicationDefects appDefects = getAnalysisDefectsPage(analysisCode, page++, 500);
			if (appDefects == null || appDefects.getDefects() == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = appDefects.getDefects().size();
			defects.addAll(appDefects.getDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	private ApplicationDefects getApplicationDefectsPage(String appName, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		String path = "/apps/" + appName + "/defects";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		ClientResponse response = get(path, queryParams);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readApplicationDefects(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	private ApplicationDefects getAnalysisDefectsPage(String analysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}
		
		String path = "/apps/analysis/" + analysisCode + "/defects";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		ClientResponse response = get(path, queryParams);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readApplicationDefects(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}

	private ApplicationDefects readApplicationDefects(InputStreamReader isr) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(isr, new TypeReference<ApplicationDefects>() {
        });
	}

	protected ClientResponse get(String resource) {
        return connection.path(resource).get(ClientResponse.class);
    }
	
	protected ClientResponse get(String resource, MultivaluedMap<String, String> queryParams) {
        return connection.path(resource).queryParams(queryParams).get(ClientResponse.class);
    }
	
	
	protected List<Application> readApplications(InputStreamReader isr) throws IOException, JsonParseException, JsonMappingException {
        return mapper.readValue(isr, new TypeReference<List<Application>>() {
        });
    }
	
	private ApplicationResults readApplication(InputStreamReader isr) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(isr, new TypeReference<ApplicationResults>() {
        });
	}
	
	private AnalysisComparation readAnalysisComparation(InputStreamReader isr) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(isr, new TypeReference<AnalysisComparation>() {
        });
	}

	
	protected void checkStatus(ClientResponse response, int checkStatus) throws KiuwanClientException {
        int status = response.getStatus();
        if (status != checkStatus)
            throw KiuwanClientException.createResponseStatusException(status);
    }

	public AnalysisComparation getAnalysisComparation(String mainAnalysisCode, String previousAnalysisCode) throws KiuwanClientException {
		
		if (mainAnalysisCode == null || mainAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid mainAnalysisCode");
		}
		
		if (previousAnalysisCode == null || previousAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid previousAnalysisCode");
		}
		
		String path = "/apps/analysis/" + mainAnalysisCode + "/defects/compare/" + previousAnalysisCode;
		
		
		return requestAndBuildAnalysisComparation(path);
	}
	
	
	public List<Defect> getAllNewDefects(String mainAnalysisCode, String previousAnalysisCode) throws KiuwanClientException {
		
		List<Defect> defects = new ArrayList<Defect>();
		
		int page = 1;
		int count = 0;
		do {
			
			AnalysisComparation analysisComparation = getNewDefectsPage(mainAnalysisCode, previousAnalysisCode, page++, 500);
			if (analysisComparation == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = analysisComparation.getNewDefects().size();
			defects.addAll(analysisComparation.getNewDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	
	private AnalysisComparation getNewDefectsPage(String mainAnalysisCode, String previousAnalysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (mainAnalysisCode == null || mainAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid mainAnalysisCode");
		}
		
		if (previousAnalysisCode == null || previousAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid previousAnalysisCode");
		}
		
		String path = "/apps/analysis/" + mainAnalysisCode + "/defects/compare/" + previousAnalysisCode + "/new";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		ClientResponse response = get(path, queryParams);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readAnalysisComparation(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	public List<Defect> getAllRemovedDefects(String mainAnalysisCode, String previousAnalysisCode) throws KiuwanClientException {
		
		List<Defect> defects = new ArrayList<Defect>();
		
		int page = 1;
		int count = 0;
		do {
			
			AnalysisComparation analysisComparation = getRemovedDefectsPage(mainAnalysisCode, previousAnalysisCode, page++, 500);
			if (analysisComparation == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = analysisComparation.getRemovedDefects().size();
			defects.addAll(analysisComparation.getRemovedDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	/**
	 * Initializes the connection.
	 * @param user The user name in Kiuwan.
	 * @param password The password in Kiuwan.
	 * @param restApiBaseUrl Base URL for REST-API.
	 */
	private void initializeConnection(String user, String password, String restApiBaseUrl) {
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		connection = ClientHelper.createClient().resource(restApiBaseUrl);
		//connection.addFilter(new LoggingFilter());
		connection.addFilter(new HTTPBasicAuthFilter(user, password));
	}
	
	private AnalysisComparation getRemovedDefectsPage(String mainAnalysisCode, String previousAnalysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (mainAnalysisCode == null || mainAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid mainAnalysisCode");
		}
		
		if (previousAnalysisCode == null || previousAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid previousAnalysisCode");
		}
		
		String path = "/apps/analysis/" + mainAnalysisCode + "/defects/compare/" + previousAnalysisCode + "/removed";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		ClientResponse response = get(path, queryParams);
		
		checkStatus(response, 200);
        InputStream is = response.getEntityInputStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
        try {
            return readAnalysisComparation(isr);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
}
