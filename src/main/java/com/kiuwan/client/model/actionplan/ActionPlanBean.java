package com.kiuwan.client.model.actionplan;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionPlanBean {

	private String name;
	private String creation;
	private String expiration;
	private String createdBy;
	private String assignedTo;
	private Double progress;
	private String estimate;
	private String pendingEffort;

	private Double riskIndexBefore;
	private Double globalIndicatorBefore;
	private Double effortToTargetBefore;
	private Map<String, Double> qualityIndicatorsBefore;
	
	private Double riskIndexAfter;
	private Double globalIndicatorAfter;
	private Double effortToTargetAfter;
	private Map<String, Double> qualityIndicatorsAfter;
	
	private List<DefectBean> allDefects;
	
	private List<DefectBean> pendingDefects;
	
	private List<DefectBean> removedDefects;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the creation
	 */
	public String getCreation() {
		return creation;
	}

	/**
	 * @param creation the creation to set
	 */
	public void setCreation(String creation) {
		this.creation = creation;
	}

	/**
	 * @return the expiration
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the assignedTo
	 */
	public String getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo the assignedTo to set
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * @return the progress
	 */
	public Double getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Double progress) {
		this.progress = progress;
	}

	/**
	 * @return the estimate
	 */
	public String getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}

	/**
	 * @return the pendingEffort
	 */
	public String getPendingEffort() {
		return pendingEffort;
	}

	/**
	 * @param pendingEffort the pendingEffort to set
	 */
	public void setPendingEffort(String pendingEffort) {
		this.pendingEffort = pendingEffort;
	}

	/**
	 * @return the riskIndexBefore
	 */
	public Double getRiskIndexBefore() {
		return riskIndexBefore;
	}

	/**
	 * @param riskIndexBefore the riskIndexBefore to set
	 */
	public void setRiskIndexBefore(Double riskIndexBefore) {
		this.riskIndexBefore = riskIndexBefore;
	}

	/**
	 * @return the globalIndicatorBefore
	 */
	public Double getGlobalIndicatorBefore() {
		return globalIndicatorBefore;
	}

	/**
	 * @param globalIndicatorBefore the globalIndicatorBefore to set
	 */
	public void setGlobalIndicatorBefore(Double globalIndicatorBefore) {
		this.globalIndicatorBefore = globalIndicatorBefore;
	}

	/**
	 * @return the effortToTargetBefore
	 */
	public Double getEffortToTargetBefore() {
		return effortToTargetBefore;
	}

	/**
	 * @param effortToTargetBefore the effortToTargetBefore to set
	 */
	public void setEffortToTargetBefore(Double effortToTargetBefore) {
		this.effortToTargetBefore = effortToTargetBefore;
	}

	/**
	 * @return the qualityIndicatorsBefore
	 */
	public Map<String, Double> getQualityIndicatorsBefore() {
		return qualityIndicatorsBefore;
	}

	/**
	 * @param qualityIndicatorsBefore the qualityIndicatorsBefore to set
	 */
	public void setQualityIndicatorsBefore(Map<String, Double> qualityIndicatorsBefore) {
		this.qualityIndicatorsBefore = qualityIndicatorsBefore;
	}

	/**
	 * @return the riskIndexAfter
	 */
	public Double getRiskIndexAfter() {
		return riskIndexAfter;
	}

	/**
	 * @param riskIndexAfter the riskIndexAfter to set
	 */
	public void setRiskIndexAfter(Double riskIndexAfter) {
		this.riskIndexAfter = riskIndexAfter;
	}

	/**
	 * @return the globalIndicatorAfter
	 */
	public Double getGlobalIndicatorAfter() {
		return globalIndicatorAfter;
	}

	/**
	 * @param globalIndicatorAfter the globalIndicatorAfter to set
	 */
	public void setGlobalIndicatorAfter(Double globalIndicatorAfter) {
		this.globalIndicatorAfter = globalIndicatorAfter;
	}

	/**
	 * @return the effortToTargetAfter
	 */
	public Double getEffortToTargetAfter() {
		return effortToTargetAfter;
	}

	/**
	 * @param effortToTargetAfter the effortToTargetAfter to set
	 */
	public void setEffortToTargetAfter(Double effortToTargetAfter) {
		this.effortToTargetAfter = effortToTargetAfter;
	}

	/**
	 * @return the qualityIndicatorsAfter
	 */
	public Map<String, Double> getQualityIndicatorsAfter() {
		return qualityIndicatorsAfter;
	}

	/**
	 * @param qualityIndicatorsAfter the qualityIndicatorsAfter to set
	 */
	public void setQualityIndicatorsAfter(Map<String, Double> qualityIndicatorsAfter) {
		this.qualityIndicatorsAfter = qualityIndicatorsAfter;
	}

	/**
	 * @return the allDefects
	 */
	public List<DefectBean> getAllDefects() {
		return allDefects;
	}

	/**
	 * @param allDefects the allDefects to set
	 */
	public void setAllDefects(List<DefectBean> allDefects) {
		this.allDefects = allDefects;
	}

	/**
	 * @return the pendingDefects
	 */
	public List<DefectBean> getPendingDefects() {
		return pendingDefects;
	}

	/**
	 * @param pendingDefects the pendingDefects to set
	 */
	public void setPendingDefects(List<DefectBean> pendingDefects) {
		this.pendingDefects = pendingDefects;
	}

	/**
	 * @return the removedDefects
	 */
	public List<DefectBean> getRemovedDefects() {
		return removedDefects;
	}

	/**
	 * @param removedDefects the removedDefects to set
	 */
	public void setRemovedDefects(List<DefectBean> removedDefects) {
		this.removedDefects = removedDefects;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ClassToStringConverter.toString("Action Plan", this);
	}
	
}
