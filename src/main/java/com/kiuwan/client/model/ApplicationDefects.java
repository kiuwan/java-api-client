package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDefects {

	protected String name;
	protected String description;
	protected String label;
	protected Date date;
	protected String encoding;
	protected String qualityModel;
	protected String orderedBy;
	protected Long defectsCount;
	protected Long count;
	protected Long page;
	protected List<Defect> defects = new ArrayList<Defect>();
	protected String analysisCode;
	protected String analysisStatus;
	
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
	@JsonProperty("defects_count")
	public Long getDefectsCount() {
		return defectsCount;
	}
	public void setDefectsCount(Long defectsCount) {
		this.defectsCount = defectsCount;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public List<Defect> getDefects() {
		return defects;
	}
	public void setDefects(List<Defect> defects) {
		this.defects = defects;
	}
	/**
	 * @return the analysisCode
	 */
	public String getAnalysisCode() {
		return analysisCode;
	}
	/**
	 * @param analysisCode the analysisCode to set
	 */
	public void setAnalysisCode(String analysisCode) {
		this.analysisCode = analysisCode;
	}
	/**
	 * @return the analysisStatus
	 */
	public String getAnalysisStatus() {
		return analysisStatus;
	}
	/**
	 * @param analysisStatus the analysisStatus to set
	 */
	public void setAnalysisStatus(String analysisStatus) {
		this.analysisStatus = analysisStatus;
	}
	@Override
	public String toString() {
		return "ApplicationDefects [name=" + name + ", description="
				+ description + ", label=" + label + ", date=" + date
				+ ", encoding=" + encoding + ", defectsCount=" + defectsCount
				+ ", count=" + count + ", page=" + page + ", defects="
				+ defects + "]";
	}
	
	
	
}
