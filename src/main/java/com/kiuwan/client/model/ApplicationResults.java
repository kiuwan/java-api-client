package com.kiuwan.client.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ApplicationResults {

	protected String name;
	protected String description;
	protected String label;
	protected Date date;
	protected String encoding;
	protected String analysisCode;
	protected String analysisStatus;
	List<Language> languages;
	String qualityModel;
	String orderedBy;
	MetricValue riskIndex;
	MetricValue qualityIndicator;
	MetricValue effortToTarget;
	List<MetricValue> mainMetrics;
	
	
	
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
	@Override
	public String toString() {
		return "ApplicationResults [name=" + name + ", description="
				+ description + ", label=" + label + ", date=" + date
				+ ", encoding=" + encoding + ", analysisCode=" + analysisCode
				+ ", analysisStatus=" + analysisStatus + ", languages=" + languages
				+ ", qualityModel=" + qualityModel + ", orderedBy=" + orderedBy
				+ ", riskIndex=" + riskIndex + ", qualityIndicator="
				+ qualityIndicator + ", effortToTarget=" + effortToTarget
				+ ", mainMetrics=" + mainMetrics + "]";
	}
	
	
}
