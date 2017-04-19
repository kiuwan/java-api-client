package com.kiuwan.client.model.delivery;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.model.Language;
import com.kiuwan.client.model.MetricValue;
import com.kiuwan.client.model.audit.AuditResultBean;
import com.kiuwan.client.utils.ClassToStringConverter;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDetailsBean {

	private String name;
	private String description;
	private String label;
	private Date date;
	private String encoding;
	private String analysisCode;
	private String auditResultURL;
	private String analysisStatus;
	private String modelId;
	private String changeRequest;
	private String changeRequestStatus;
	private String branchName;
	private String analysisScope;
	private String baselineAnalysisCode;
	private DeliveryFilesBean deliveryFiles;
	private DeliveryDefectsBean deliveryDefects;
	private AuditResultBean auditResult;
	private List<Language> languages = new ArrayList<Language>();
	private String qualityModel;
	private String orderedBy;
	private MetricValue riskIndex;
	private MetricValue qualityIndicator;
	private MetricValue effortToTarget;
	private List<MetricValue> mainMetrics = new ArrayList<MetricValue>();
	private String analysisBusinessValue;
	private String analysisProvider;
	private Map<String, String> analysisPortfolios = new HashMap<String, String>();
	
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
	
	public String getModelId() {
		return modelId;
	}
	
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
	public String getChangeRequest() {
		return changeRequest;
	}
	
	public void setChangeRequest(String changeRequest) {
		this.changeRequest = changeRequest;
	}
	
	public String getChangeRequestStatus() {
		return changeRequestStatus;
	}
	
	public void setChangeRequestStatus(String changeRequestStatus) {
		this.changeRequestStatus = changeRequestStatus;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getAnalysisScope() {
		return analysisScope;
	}
	
	public void setAnalysisScope(String analysisScope) {
		this.analysisScope = analysisScope;
	}
	
	public String getBaselineAnalysisCode() {
		return baselineAnalysisCode;
	}
	
	public void setBaselineAnalysisCode(String baselineAnalysisCode) {
		this.baselineAnalysisCode = baselineAnalysisCode;
	}
	
	public DeliveryFilesBean getDeliveryFiles() {
		return deliveryFiles;
	}
	
	public void setDeliveryFiles(DeliveryFilesBean deliveryFiles) {
		this.deliveryFiles = deliveryFiles;
	}
	
	public DeliveryDefectsBean getDeliveryDefects() {
		return deliveryDefects;
	}
	
	public void setDeliveryDefects(DeliveryDefectsBean deliveryDefects) {
		this.deliveryDefects = deliveryDefects;
	}
	
	public AuditResultBean getAuditResult() {
		return auditResult;
	}
	
	public void setAuditResult(AuditResultBean auditResult) {
		this.auditResult = auditResult;
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
		return ClassToStringConverter.toString("Delivery details", this);
	}
	
}
