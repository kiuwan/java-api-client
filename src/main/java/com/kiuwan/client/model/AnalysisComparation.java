package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisComparation {

	private String mainAnalysisCode;
	private String previousAnalysisCode;
		
	private Integer newViolatedRulesCount;
	private Integer removedViolatedRulesCount;
	private Integer newDefectsCount;
	private Integer removedDefectsCount;
	
	protected Long count;
	protected Long page;
	private List<Defect> newDefects = new ArrayList<Defect>();
	private List<Defect> removedDefects = new ArrayList<Defect>();
	
	
	
	@JsonProperty("Main analysis code")
	public String getMainAnalysisCode() {
		return mainAnalysisCode;
	}






	public void setMainAnalysisCode(String mainAnalysisCode) {
		this.mainAnalysisCode = mainAnalysisCode;
	}





	@JsonProperty("Previous analysis code")
	public String getPreviousAnalysisCode() {
		return previousAnalysisCode;
	}






	public void setPreviousAnalysisCode(String previousAnalysisCode) {
		this.previousAnalysisCode = previousAnalysisCode;
	}





	@JsonProperty("New violated rules count")
	public Integer getNewViolatedRulesCount() {
		return newViolatedRulesCount;
	}






	public void setNewViolatedRulesCount(Integer newViolatedRulesCount) {
		this.newViolatedRulesCount = newViolatedRulesCount;
	}





	@JsonProperty("Removed violated rules count")
	public Integer getRemovedViolatedRulesCount() {
		return removedViolatedRulesCount;
	}






	public void setRemovedViolatedRulesCount(Integer removedViolatedRulesCount) {
		this.removedViolatedRulesCount = removedViolatedRulesCount;
	}





	@JsonProperty("New defects count")
	public Integer getNewDefectsCount() {
		return newDefectsCount;
	}






	public void setNewDefectsCount(Integer newDefectsCount) {
		this.newDefectsCount = newDefectsCount;
	}





	@JsonProperty("Removed defects count")
	public Integer getRemovedDefectsCount() {
		return removedDefectsCount;
	}






	public void setRemovedDefectsCount(Integer removedDefectsCount) {
		this.removedDefectsCount = removedDefectsCount;
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





	@JsonProperty("New defects")
	public List<Defect> getNewDefects() {
		return newDefects;
	}






	public void setNewDefects(List<Defect> newDefects) {
		this.newDefects = newDefects;
	}





	@JsonProperty("Removed defects")
	public List<Defect> getRemovedDefects() {
		return removedDefects;
	}






	public void setRemovedDefects(List<Defect> removedDefects) {
		this.removedDefects = removedDefects;
	}






	@Override
	public String toString() {
		return "AnalysisComparation [mainAnalysisCode=" + mainAnalysisCode + ", previousAnalysisCode="
				+ previousAnalysisCode + ", newViolatedRulesCount=" + newViolatedRulesCount + ", removedViolatedRulesCount="
				+ removedViolatedRulesCount + ", newDefectsCount=" + newDefectsCount + ", removedDefectsCount=" + removedDefectsCount 
				+ ", page=" + page + ", count=" + count + ", newDefects=" + newDefects + ", removedDefects=" + removedDefects + "]";
	}
	
}
