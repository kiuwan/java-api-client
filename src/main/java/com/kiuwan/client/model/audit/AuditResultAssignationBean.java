package com.kiuwan.client.model.audit;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditResultAssignationBean {

	private String analysisCode;
	private Boolean passAudit;
	
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
	 * @return the passAudit
	 */
	public Boolean getPassAudit() {
		return passAudit;
	}
	
	/**
	 * @param passAudit the passAudit to set
	 */
	public void setPassAudit(Boolean passAudit) {
		this.passAudit = passAudit;
	}
	
}