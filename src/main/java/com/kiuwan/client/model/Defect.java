package com.kiuwan.client.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Defect {

	protected String language;
	protected String characteristic;
	protected String priority;
	protected String effort;
	protected String rule;
	protected String file;
	protected Long line;
	protected String code;
	protected String ruleCode;
	protected Boolean muted;
	protected Long modelId;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getEffort() {
		return effort;
	}
	public void setEffort(String effort) {
		this.effort = effort;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Long getLine() {
		return line;
	}
	public void setLine(Long line) {
		this.line = line;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public Boolean getMuted() {
		return muted;
	}
	public void setMuted(Boolean muted) {
		this.muted = muted;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	@Override
	public String toString() {
		return "Defect [language=" + language + ", characteristic="
				+ characteristic + ", priority=" + priority + ", effort="
				+ effort + ", rule=" + rule + ", file=" + file + ", line="
				+ line + ", code=" + code + ", ruleCode=" + ruleCode + ", muted=" + muted + ", modelId=" + modelId + "]";
	}
	
}
