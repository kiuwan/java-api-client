package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisBean {
	
	/**
	 * Analysis status that indicates that the analysis is queued waiting for some analysis slot.
	 */
	public static final String INQUEUE_STATUS = "INQUEUE";
	
	/**
	 * Analysis status that indicates that the analysis has failed.
	 */
	public static final String FAIL_STATUS = "FAIL";
	
	/**
	 * Analysis status that indicates that the analysis has been completed successfully.
	 */
	public static final String SUCCESS_STATUS = "SUCCESS";
	
	/**
	 * Analysis status that indicates that the analysis is running.
	 */
	public static final String RUNNING_STATUS = "RUNNING";

	private String code;
	private String label;
	private String creationDate;
	private String qualityModel;
	private String encoding;
	private String invoker;
	private String status;
	private String errorCode;
	private List<UnparsedFileBean> unparsedFiles = new ArrayList<UnparsedFileBean>();
	private String analysisBusinessValue;
	private String analysisProvider;
	private Map<String, String> analysisPortfolios = new HashMap<String, String>();
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the qualityModel
	 */
	public String getQualityModel() {
		return qualityModel;
	}

	/**
	 * @param qualityModel the qualityModel to set
	 */
	public void setQualityModel(String qualityModel) {
		this.qualityModel = qualityModel;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * @return the invoker
	 */
	public String getInvoker() {
		return invoker;
	}

	/**
	 * @param invoker the invoker to set
	 */
	public void setInvoker(String invoker) {
		this.invoker = invoker;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the unparsedFiles
	 */
	public List<UnparsedFileBean> getUnparsedFiles() {
		return unparsedFiles;
	}

	/**
	 * @param unparsedFiles the unparsedFiles to set
	 */
	public void setUnparsedFiles(List<UnparsedFileBean> unparsedFiles) {
		this.unparsedFiles = unparsedFiles;
	}

	/**
	 * @return the analysisBusinessValue
	 */
	public String getAnalysisBusinessValue() {
		return analysisBusinessValue;
	}

	/**
	 * @param analysisBusinessValue the analysisBusinessValue to set
	 */
	public void setAnalysisBusinessValue(String analysisBusinessValue) {
		this.analysisBusinessValue = analysisBusinessValue;
	}

	/**
	 * @return the analysisProvider
	 */
	public String getAnalysisProvider() {
		return analysisProvider;
	}

	/**
	 * @param analysisProvider the analysisProvider to set
	 */
	public void setAnalysisProvider(String analysisProvider) {
		this.analysisProvider = analysisProvider;
	}

	/**
	 * @return the analysisPortfolios
	 */
	public Map<String, String> getAnalysisPortfolios() {
		return analysisPortfolios;
	}

	/**
	 * @param analysisPortfolios the analysisPortfolios to set
	 */
	public void setAnalysisPortfolios(Map<String, String> analysisPortfolios) {
		this.analysisPortfolios = analysisPortfolios;
	}

	@Override
	public String toString() {
		String unparsedFilesString = "";
		for (UnparsedFileBean unparsedFileBean : unparsedFiles) {
			String file = unparsedFileBean.getFile();
			String cause = unparsedFileBean.getCause();
			unparsedFilesString = unparsedFilesString + "{file:"+file+", cause:"+cause+"}";
		}
		
		return "Analysis [code=" + code + ", label=" + label + ", " + "creationDate=" + creationDate
				+ ", qualityModel=" + qualityModel + ", encoding=" + encoding + ", invoker=" + invoker + ", status=" + status + ", errorCode=" + errorCode + ", unparsedFiles="
				+ "["+unparsedFilesString+"]]";
	}
	
}
