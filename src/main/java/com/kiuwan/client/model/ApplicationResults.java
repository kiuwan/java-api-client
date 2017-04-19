package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationResults {

	protected String name;
	protected String description;
	protected String label;
	protected Date date;
	protected String encoding;
	protected String analysisCode;
	protected String analysisURL;
	protected String auditResultURL;
	protected String analysisStatus;
	List<Language> languages = new ArrayList<Language>();
	String qualityModel;
	String orderedBy;
	MetricValue riskIndex;
	MetricValue qualityIndicator;
	MetricValue effortToTarget;
	List<MetricValue> mainMetrics = new ArrayList<MetricValue>();
	
	String applicationBusinessValue;
	String applicationProvider;
	Map<String, String> applicationPortfolios = new HashMap<String, String>();

	String analysisBusinessValue;
	String analysisProvider;
	Map<String, String> analysisPortfolios = new HashMap<String, String>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getAnalysisCode() {
		return analysisCode;
	}
	
	public void setAnalysisCode(String analysisCode) {
		this.analysisCode = analysisCode;
	}
	
	public String getAnalysisURL() {
		return analysisURL;
	}
	
	public void setAnalysisURL(String analysisURL) {
		this.analysisURL = analysisURL;
	}
	
	public String getAuditResultURL() {
		return auditResultURL;
	}
	
	public void setAuditResultURL(String auditResultURL) {
		this.auditResultURL = auditResultURL;
	}
	
	public String getAnalysisStatus() {
		return analysisStatus;
	}
	
	public void setAnalysisStatus(String analysisStatus) {
		this.analysisStatus = analysisStatus;
	}
	
	public List<Language> getLanguages() {
		return languages;
	}
	
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	@JsonProperty("quality_model")
	public String getQualityModel() {
		return qualityModel;
	}
	
	public void setQualityModel(String qualityModel) {
		this.qualityModel = qualityModel;
	}
	
	@JsonProperty("ordered_by")
	public String getOrderedBy() {
		return orderedBy;
	}
	
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}
	
	@JsonProperty("Risk index")
	public MetricValue getRiskIndex() {
		return riskIndex;
	}
	
	public void setRiskIndex(MetricValue riskIndex) {
		this.riskIndex = riskIndex;
	}
	
	@JsonProperty("Quality indicator")
	public MetricValue getQualityIndicator() {
		return qualityIndicator;
	}
	
	public void setQualityIndicator(MetricValue qualityIndicator) {
		this.qualityIndicator = qualityIndicator;
	}
	
	@JsonProperty("Effort to target")
	public MetricValue getEffortToTarget() {
		return effortToTarget;
	}
	
	public void setEffortToTarget(MetricValue effortToTarget) {
		this.effortToTarget = effortToTarget;
	}
	
	@JsonProperty("Main metrics")
	public List<MetricValue> getMainMetrics() {
		return mainMetrics;
	}
	
	public void setMainMetrics(List<MetricValue> mainMetrics) {
		this.mainMetrics = mainMetrics;
	}
	
	public String getApplicationBusinessValue() {
		return applicationBusinessValue;
	}
	
	public void setApplicationBusinessValue(String applicationBusinessValue) {
		this.applicationBusinessValue = applicationBusinessValue;
	}
	
	public String getApplicationProvider() {
		return applicationProvider;
	}
	
	public void setApplicationProvider(String applicationProvider) {
		this.applicationProvider = applicationProvider;
	}
	
	public Map<String, String> getApplicationPortfolios() {
		return applicationPortfolios;
	}
	
	public void setApplicationPortfolios(Map<String, String> applicationPortfolios) {
		this.applicationPortfolios = applicationPortfolios;
	}
	
	public String getAnalysisBusinessValue() {
		return analysisBusinessValue;
	}
	
	public void setAnalysisBusinessValue(String analysisBusinessValue) {
		this.analysisBusinessValue = analysisBusinessValue;
	}
	
	public String getAnalysisProvider() {
		return analysisProvider;
	}
	
	public void setAnalysisProvider(String analysisProvider) {
		this.analysisProvider = analysisProvider;
	}
	
	public Map<String, String> getAnalysisPortfolios() {
		return analysisPortfolios;
	}
	
	public void setAnalysisPortfolios(Map<String, String> analysisPortfolios) {
		this.analysisPortfolios = analysisPortfolios;
	}
	
	@Override
	public String toString() {
		return "ApplicationResults [name=" + name + ", description="
				+ description + ", URL=" + analysisURL + ", auditResultURL=" + auditResultURL + ", label=" + label + ", date=" + date
				+ ", encoding=" + encoding + ", analysisCode=" + analysisCode
				+ ", analysisStatus=" + analysisStatus + ", languages=" + languages
				+ ", qualityModel=" + qualityModel + ", orderedBy=" + orderedBy
				+ ", riskIndex=" + riskIndex + ", qualityIndicator="
				+ qualityIndicator + ", effortToTarget=" + effortToTarget
				+ ", mainMetrics=" + mainMetrics + "]";
	}
	
	
}
