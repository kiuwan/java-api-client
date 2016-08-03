package com.kiuwan.client;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;

import com.kiuwan.client.model.AnalysisBean;
import com.kiuwan.client.model.AnalysisComparation;
import com.kiuwan.client.model.Application;
import com.kiuwan.client.model.ApplicationDefects;
import com.kiuwan.client.model.ApplicationFiles;
import com.kiuwan.client.model.ApplicationResults;
import com.kiuwan.client.model.AuditResultBean;
import com.kiuwan.client.model.Defect;
import com.kiuwan.client.model.File;
import com.kiuwan.client.model.management.applications.ApplicationBean;
import com.kiuwan.client.model.management.users.UserBean;
import com.kiuwan.client.model.management.users.groups.UserGroupBean;

public class KiuwanRestApiClient {

	protected static final String REST_API_BASE_URL = "https://api.kiuwan.com";
    
	private static final String CSRF_TOKEN_HEADER = "X-CSRF-TOKEN";

	private WebTarget connection;
	
	private String csrfToken;
	
	private Map<String, Cookie> cookies = new HashMap<String, Cookie>();
	
    public KiuwanRestApiClient(String user, String password) {
		initializeConnection(user, password, REST_API_BASE_URL);
	}
	
	public KiuwanRestApiClient(String user, String password, String restApiBaseUrl) {
		initializeConnection(user, password, restApiBaseUrl);
	}

    public KiuwanRestApiClient(String user, String password, String proxyHost, Integer proxyPort, Proxy.Type proxyType) {
    	initializeConnection(user, password, REST_API_BASE_URL, proxyHost, proxyPort, proxyType, null, null);
	}

    public KiuwanRestApiClient(String user, String password, String restApiBaseUrl, String proxyHost, Integer proxyPort, Proxy.Type proxyType) {
    	initializeConnection(user, password, restApiBaseUrl, proxyHost, proxyPort, proxyType, null, null);
	}
    
    public KiuwanRestApiClient(String user, String password, String proxyHost, Integer proxyPort, Proxy.Type proxyType, String proxyUser, String proxyPassword) {
    	initializeConnection(user, password, REST_API_BASE_URL, proxyHost, proxyPort, proxyType, proxyUser, proxyPassword);
	}

    public KiuwanRestApiClient(String user, String password, String restApiBaseUrl, String proxyHost, Integer proxyPort, Proxy.Type proxyType, String proxyUser, String proxyPassword) {
    	initializeConnection(user, password, restApiBaseUrl, proxyHost, proxyPort, proxyType, proxyUser, proxyPassword);
	}
    
	public void activateLog() {
		connection.register(new LoggingFilter());
	}
	
	public List<Application> getApplications() throws KiuwanClientException {
		String path = "/apps/list";

		Response response = get(path);
		checkStatus(response, 200);
        try {
        	return response.readEntity(new GenericType<List<Application>>(){});
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
		Response response = get(path);
		checkStatus(response, 200);
        try {
            return response.readEntity(ApplicationResults.class);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	public AnalysisComparation requestAndBuildAnalysisComparation(String path) throws KiuwanClientException {
		Response response = get(path);
		checkStatus(response, 200);
        try {
        	return response.readEntity(AnalysisComparation.class);
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
				throw new KiuwanClientException("Unknown error");
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
				throw new KiuwanClientException("Unknown error");
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
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("page", new String[]{pageNumber.toString()});
		queryParams.put("count", new String[]{defectsPerPage.toString()});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(ApplicationFiles.class);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	private ApplicationFiles getAnalysisFilesPage(String analysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}

		String path = "/apps/analysis/" + analysisCode + "/files";
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("page", new String[]{pageNumber.toString()});
		queryParams.put("count", new String[]{defectsPerPage.toString()});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(ApplicationFiles.class);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
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
				throw new KiuwanClientException("Unknown error");
			}
			
			count = appDefects.getDefects().size();
			defects.addAll(appDefects.getDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	public Map<String, Double> getMetrics(String analysisCode) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}
		
		String path = "/metrics";
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("code", new String[]{analysisCode});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(new GenericType<Map<String, Double>>() {});
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
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
				throw new KiuwanClientException("Unknown error");
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
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("page", new String[]{pageNumber.toString()});
		queryParams.put("count", new String[]{defectsPerPage.toString()});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(ApplicationDefects.class);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}
	
	private ApplicationDefects getAnalysisDefectsPage(String analysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (analysisCode == null || analysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid analysis code");
		}
		
		String path = "/apps/analysis/" + analysisCode + "/defects";
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("page", new String[]{pageNumber.toString()});
		queryParams.put("count", new String[]{defectsPerPage.toString()});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(ApplicationDefects.class);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
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
				throw new KiuwanClientException("Unknown error");
			}
			
			count = analysisComparation.getNewDefects().size();
			defects.addAll(analysisComparation.getNewDefects());
			
		} while (count == 500);
		
		return defects;
	}
	
	public List<AnalysisBean> getAnalyses(String application) throws KiuwanClientException{
		String path = "/apps/" + application + "/analyses";
		Map<String, String[]> queryParams = new HashMap<String, String[]>();

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(new GenericType<List<AnalysisBean>>(){});
        } catch (Exception e) {
        	throw new KiuwanClientException(e);
        }
	}
	
	private AnalysisComparation getNewDefectsPage(String mainAnalysisCode, String previousAnalysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (mainAnalysisCode == null || mainAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid mainAnalysisCode");
		}
		
		if (previousAnalysisCode == null || previousAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid previousAnalysisCode");
		}
		
		String path = "/apps/analysis/" + mainAnalysisCode + "/defects/compare/" + previousAnalysisCode + "/new";
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("page", new String[]{pageNumber.toString()});
		queryParams.put("count", new String[]{defectsPerPage.toString()});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(AnalysisComparation.class);
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
				throw new KiuwanClientException("Unknown error");
			}
			
			count = analysisComparation.getRemovedDefects().size();
			defects.addAll(analysisComparation.getRemovedDefects());
			
		} while (count == 500);
		
		return defects;
	}

	public String createApplications(List<ApplicationBean> applications) throws KiuwanClientException {
		StringBuilder results = new StringBuilder();
		String path = "/applications";
		
		for (ApplicationBean applicationBean : applications) {
			Response response = post(path, applicationBean);
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(applicationBean.getName()+" -> "+resultMessage+"\n");
		}
		
		return results.toString();
	}
	
	public String modifyApplications(List<ApplicationBean> applications) throws KiuwanClientException {
		StringBuilder results = new StringBuilder();
		String parentPath = "/applications";
		
		for (ApplicationBean applicationBean : applications) {
			Response response = put(parentPath+"/"+applicationBean.getName(), applicationBean);
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(applicationBean.getName()+" -> "+resultMessage+"\n");
		}
		
		return results.toString();
	}
	
	public String deleteApplications(List<ApplicationBean> applications) throws KiuwanClientException {
		StringBuilder results = new StringBuilder();
		String parentPath = "/applications";
		
		for (ApplicationBean applicationBean : applications) {
			Response response = delete(parentPath+"/"+applicationBean.getName());
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(applicationBean.getName()+" -> "+resultMessage+"\n");
		}
		
		return results.toString();
	}
	
	public String createUsers(List<UserBean> userBeans) throws KiuwanClientException{
		StringBuilder results = new StringBuilder();
		String path = "/users";

		for (UserBean userBean : userBeans) {
			Response response = post(path, userBean);
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(userBean.getUsername()+" -> "+resultMessage+"\n");

		}
		return results.toString();
	}
	
	public String createUserGroups(List<UserGroupBean> userGroupBeans) throws KiuwanClientException{
		StringBuilder results = new StringBuilder();
		String path = "/userGroups";

		for (UserGroupBean userGroupBean : userGroupBeans) {
			Response response = post(path, userGroupBean);
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(userGroupBean.getName()+" -> "+resultMessage+"\n");

		}
		return results.toString();
	}
	
	public String modifyUsers(List<UserBean> userBeans) throws KiuwanClientException{
		StringBuilder results = new StringBuilder();
		String parentPath = "/users";
		
		for (UserBean userBean : userBeans) {
			Response response = put(parentPath+"/"+userBean.getUsername(), userBean);
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(userBean.getUsername()+" -> "+resultMessage+"\n");
		}
		return results.toString();
	}
	
	public String modifyUserGroups(List<UserGroupBean> userGroupBeans) throws KiuwanClientException{
		StringBuilder results = new StringBuilder();
		String parentPath = "/userGroups";
		
		for (UserGroupBean userGroupBean : userGroupBeans) {
			Response response = put(parentPath+"/"+userGroupBean.getName(), userGroupBean);
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(userGroupBean.getName()+" -> "+resultMessage+"\n");
		}
		return results.toString();
	}
	
	public String deleteUsers(List<UserBean> userBeans) throws KiuwanClientException{
		StringBuilder results = new StringBuilder();
		String parentPath = "/users";
		
		for (UserBean userBean : userBeans) {
			Response response = delete(parentPath+"/"+userBean.getUsername());
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(userBean.getUsername()+" -> "+resultMessage+"\n");
		}
		
		return results.toString();
	}
	
	public String deleteUserGroups(List<UserGroupBean> userGroupBeans) throws KiuwanClientException{
		StringBuilder results = new StringBuilder();
		String parentPath = "/userGroups";
		
		for (UserGroupBean userGroupBean : userGroupBeans) {
			Response response = delete(parentPath+"/"+userGroupBean.getName());
			
			String resultMessage = "";
			try {
				resultMessage = response.readEntity(String.class);
			} catch (Exception e) {
				resultMessage = "ERROR: "+e.getMessage();
			}
			results.append(userGroupBean.getName()+" -> "+resultMessage+"\n");
		}
		
		return results.toString();
	}
	
	public List<UserBean> listUsers() throws KiuwanClientException{
		String path = "/users";
		
		Response response = get(path);
		checkStatus(response, 200);
		List<UserBean> users = new ArrayList<UserBean>();
		try {
			users = response.readEntity(new GenericType<List<UserBean>>(){});
		} catch (Exception e) {
			throw new KiuwanClientException("Unknown error");
		}
		
		return users;
	}
	
	public List<UserGroupBean> listUserGroups() throws KiuwanClientException{
		String path = "/userGroups";
		
		Response response = get(path);
		checkStatus(response, 200);
		List<UserGroupBean> userGroups = new ArrayList<UserGroupBean>();
		try {
			userGroups = response.readEntity(new GenericType<List<UserGroupBean>>(){});
		} catch (Exception e) {
			throw new KiuwanClientException("Unknown error");
		}
		
		return userGroups;
	}
	
	public String sendAuditResult(String analysisCode, Boolean passAudit) throws KiuwanClientException{
		String path = "/auditresults";
		
		AuditResultBean auditResultBean = new AuditResultBean();
		auditResultBean.setAnalysisCode(analysisCode);
		auditResultBean.setPassAudit(passAudit);
		
		Response response = post(path, auditResultBean);
		checkStatus(response, 200);
		String resultMessage = null;
		try {
			resultMessage = response.readEntity(String.class);
		} catch (Exception e) {
			throw new KiuwanClientException("Unknown error");
		}
		
		return resultMessage;
	}
	
	/**
	 * Initializes the connection.
	 * @param user The user name in Kiuwan.
	 * @param password The password in Kiuwan.
	 * @param restApiBaseUrl Base URL for REST-API.
	 */
	private void initializeConnection(String user, String password, String restApiBaseUrl) {
		csrfToken = null;
		cookies = new HashMap<String, Cookie>();
		
		connection = ClientHelper.createClient().register(HttpAuthenticationFeature.basic(user, password)).target(restApiBaseUrl);
	}
	
	/**
	 * Initializes the connection.
	 * @param user The user name in Kiuwan.
	 * @param password The password in Kiuwan.
	 * @param restApiBaseUrl Base URL for REST-API.
	 * @param proxyHost Proxy hostname or address.
	 * @param proxyPort Port of the proxy.
	 * @param proxyType Type of the proxy: HTTP/SOCKS/DIRECT.
	 * @param proxyUser User name to authenticate with the proxy.
	 * @param proxyPassword Password to authenticate with the proxy.
	 */
	private void initializeConnection(String user, String password, String restApiBaseUrl, String proxyHost, Integer proxyPort, Proxy.Type proxyType, String proxyUser, String proxyPassword) {
		connection = ClientHelper.createClient(proxyHost, proxyPort, proxyType, proxyUser, proxyPassword).register(HttpAuthenticationFeature.basic(user, password)).target(restApiBaseUrl);
	}
	
	private AnalysisComparation getRemovedDefectsPage(String mainAnalysisCode, String previousAnalysisCode, Integer pageNumber, Integer defectsPerPage) throws KiuwanClientException {
		
		if (mainAnalysisCode == null || mainAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid mainAnalysisCode");
		}
		
		if (previousAnalysisCode == null || previousAnalysisCode.isEmpty()) {
			throw new KiuwanClientException("Invalid previousAnalysisCode");
		}
		
		String path = "/apps/analysis/" + mainAnalysisCode + "/defects/compare/" + previousAnalysisCode + "/removed";
		Map<String, String[]> queryParams = new HashMap<String, String[]>();
		queryParams.put("page", new String[]{pageNumber.toString()});
		queryParams.put("count", new String[]{defectsPerPage.toString()});

		Response response = get(path, queryParams);
		checkStatus(response, 200);
        try {
            return response.readEntity(AnalysisComparation.class);
        } catch (Exception e) {
            throw new KiuwanClientException(e);
        }
	}

	private Response get(String resource) {
        Builder request = connection.path(resource).request();
        setCookies(request);
        setCsrfToken(request);
        Response response = request.get(Response.class);
        saveCookies(response);
        saveCsrfToken(response);
        return response;
    }

	private Response delete(String resource) {
        Builder request = connection.path(resource).request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        setCookies(request);
        setCsrfToken(request);
		Response response = request.delete(Response.class);
        saveCookies(response);
        saveCsrfToken(response);
        return response;
    }

	private Response put(String resource, Object content) {
        Builder request = connection.path(resource).request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        setCookies(request);
        setCsrfToken(request);
        Response response = request.put(Entity.entity(content, MediaType.APPLICATION_JSON_TYPE), Response.class);
        saveCookies(response);
        saveCsrfToken(response);
        return response;
    }
	
	private Response post(String resource, Object content) {
        Builder request = connection.path(resource).request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        setCookies(request);
        setCsrfToken(request);
        Response response = request.post(Entity.entity(content, MediaType.APPLICATION_JSON_TYPE), Response.class);
        saveCookies(response);
        saveCsrfToken(response);
        return response;
    }
	
	private Response get(String resource, Map<String, String[]> queryParams) {
		WebTarget path = connection.path(resource);
		for(String parameter : queryParams.keySet()) {
			path = path.queryParam(parameter, (Object[])queryParams.get(parameter));
		}
		
        Builder request = path.request(MediaType.APPLICATION_JSON_TYPE);
        setCookies(request);
        setCsrfToken(request);
		Response response = request.get(Response.class);
        saveCookies(response);
        saveCsrfToken(response);
        return response;
	}
	
	private void setCookies(Builder request) {
		for (Cookie cookie : this.cookies.values()) {
			request.cookie(cookie);
		}
	}
	
	private void setCsrfToken(Builder request) {
		String csrfToken = this.csrfToken;
		if(csrfToken != null){
			request.header(CSRF_TOKEN_HEADER, csrfToken);
		}
	}

	private void saveCsrfToken(Response response) {
		String token = response.getHeaderString(CSRF_TOKEN_HEADER);
		if(token != null){
			this.csrfToken = token;
		}
	}
	
	private void saveCookies(Response response) {
		Map<String, NewCookie> cookies = response.getCookies();
        if(cookies != null){
        	this.cookies.putAll(cookies);
        }
	}
	
	private void checkStatus(Response response, int checkStatus) throws KiuwanClientException {
        int status = response.getStatus();
        if (status != checkStatus)
            throw KiuwanClientException.createResponseStatusException(status);
    }

}
