package com.kiuwan.client.model.actionplan;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.utils.ClassToStringConverter;

/**
 * Bean containing the action plan defect information.
 */
@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefectBean {

	private String rule;

	private String language;
	
	private String characteristic;
	
	private String priority;
	
	private String effort;
	
	private Boolean muted;
	
	private DefectFileBean file;

	private String ruleCode;
	
	private Long modelId;
	
	/**
	 * @return the rule
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the characteristic
	 */
	public String getCharacteristic() {
		return characteristic;
	}

	/**
	 * @param characteristic the characteristic to set
	 */
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the effort
	 */
	public String getEffort() {
		return effort;
	}

	/**
	 * @param effort the effort to set
	 */
	public void setEffort(String effort) {
		this.effort = effort;
	}
	
	/**
	 * @return the muted
	 */
	public Boolean getMuted() {
		return muted;
	}

	/**
	 * @param muted the muted to set
	 */
	public void setMuted(Boolean muted) {
		this.muted = muted;
	}

	/**
	 * @return the file
	 */
	public DefectFileBean getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(DefectFileBean file) {
		this.file = file;
	}
	
	/**
	 * @return the ruleCode
	 */
	public String getRuleCode() {
		return ruleCode;
	}

	/**
	 * @param ruleCode the ruleCode to set
	 */
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	/**
	 * @return the modelId
	 */
	public Long getModelId() {
		return modelId;
	}

	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ClassToStringConverter.toString("Defect", this)+"\n";
	}
	
}