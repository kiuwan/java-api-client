package com.kiuwan.client.model.audit;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditResultBean {

	private Double approvalThreshold;
    private String overallResult;
    private Double score;
    private List<CheckpointResultBean> checkpointResults;
    
	/**
	 * @return the approvalThreshold
	 */
	public Double getApprovalThreshold() {
		return approvalThreshold;
	}
	/**
	 * @param approvalThreshold the approvalThreshold to set
	 */
	public void setApprovalThreshold(Double approvalThreshold) {
		this.approvalThreshold = approvalThreshold;
	}
	/**
	 * @return the overallResult
	 */
	public String getOverallResult() {
		return overallResult;
	}
	/**
	 * @param overallResult the overallResult to set
	 */
	public void setOverallResult(String overallResult) {
		this.overallResult = overallResult;
	}
	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	/**
	 * @return the checkpointResults
	 */
	public List<CheckpointResultBean> getCheckpointResults() {
		return checkpointResults;
	}
	/**
	 * @param checkpointResults the checkpointResults to set
	 */
	public void setCheckpointResults(List<CheckpointResultBean> checkpointResults) {
		this.checkpointResults = checkpointResults;
	}

	@Override
	public String toString() {
		return  ClassToStringConverter.toString("Audit result", this);
	}
	
}