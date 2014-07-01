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
	protected WebResource connexion;
	// Reusable Jackson Mapper
    protected static final ObjectMapper mapper = new ObjectMapper();

	
	public KiuwanRestApiClient(String user, String password) {
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		connexion = ClientHelper.createClient().resource(REST_API_BASE_URL);
		//connexion.addFilter(new LoggingFilter());
		connexion.addFilter(new HTTPBasicAuthFilter(user, password));
	}
	
	public void activateLog() {
		connexion.addFilter(new LoggingFilter());
	}
	
	public List<Application> getApplications() throws KiuwanClientException {
		return getApplications(null);
	}
	
	public List<Application> getApplications(String publicAccount) throws KiuwanClientException {

		String path = "/apps/list";
		if (publicAccount != null && !publicAccount.isEmpty()) {
			path = "/" + publicAccount + path;
		}
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
		return getApplicationResults(null, appName);
	}
	
	
	public ApplicationResults getApplicationResults(String publicAccount, String appName) throws KiuwanClientException {

		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		String path = "/apps/" + appName;
		if (publicAccount != null && !publicAccount.isEmpty()) {
			path = "/" + publicAccount + path;
		}
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
	
	public List<File> getAllFiles(String appName) throws KiuwanClientException { 
		return getAllFiles(null, appName);
	}
	
	
	public List<File> getAllFiles(String publicAccount, String appName) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		List<File> files = new ArrayList<File>();
		
		int page = 1;
		int count = 0;
		do {
			
			ApplicationFiles appFiles = getApplicationFilesPage(publicAccount, appName, page++, 500);
			if (appFiles == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = appFiles.getFiles().size();
			files.addAll(appFiles.getFiles());
			
		} while (count == 500);
		
		return files;
	}
	
	public ApplicationFiles getApplicationFilesPage(String appName, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		return getApplicationFilesPage(null, appName, pageNumber, defectsPerPage);
	}

	
	private ApplicationFiles getApplicationFilesPage(String publicAccount, String appName, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		String path = "/apps/" + appName + "/files";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		if (publicAccount != null && !publicAccount.isEmpty()) {
			path = "/" + publicAccount + path;
		}
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
		return getAllDefects(null, appName);
	}
	
	
	public List<Defect> getAllDefects(String publicAccount, String appName) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		List<Defect> defects = new ArrayList<Defect>();
		
		int page = 1;
		int count = 0;
		do {
			
			ApplicationDefects appDefects = getApplicationDefectsPage(publicAccount, appName, page++, 500);
			if (appDefects == null) {
				throw new KiuwanClientException("Unkonwn error");
			}
			
			count = appDefects.getDefects().size();
			defects.addAll(appDefects.getDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	public ApplicationDefects getApplicationDefectsPage(String appName, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		return getApplicationDefectsPage(null, appName, pageNumber, defectsPerPage);
	}

	
	private ApplicationDefects getApplicationDefectsPage(String publicAccount, String appName, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (appName == null || appName.isEmpty()) {
			throw new KiuwanClientException("Invalid application name");
		}
		
		String path = "/apps/" + appName + "/defects";
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("page", pageNumber.toString());
		queryParams.add("count", defectsPerPage.toString());

		if (publicAccount != null && !publicAccount.isEmpty()) {
			path = "/" + publicAccount + path;
		}
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
        return connexion.path(resource).get(ClientResponse.class);
    }
	
	protected ClientResponse get(String resource, MultivaluedMap<String, String> queryParams) {
        return connexion.path(resource).queryParams(queryParams).get(ClientResponse.class);
    }
	
	
	protected List<Application> readApplications(InputStreamReader isr) throws IOException, JsonParseException, JsonMappingException {
        return mapper.readValue(isr, new TypeReference<List<Application>>() {
        });
    }
	
	private ApplicationResults readApplication(InputStreamReader isr) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(isr, new TypeReference<ApplicationResults>() {
        });
	}

	
	protected void checkStatus(ClientResponse response, int checkStatus) throws KiuwanClientException {
        int status = response.getStatus();
        if (status != checkStatus)
            throw KiuwanClientException.createResponseStatusException(status);
    }
	
	
}
