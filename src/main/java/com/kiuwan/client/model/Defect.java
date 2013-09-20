package com.kiuwan.client.model;

public class Defect {

	protected String language;
	protected String characteristic;
	protected String priority;
	protected String difficulty;
	protected String rule;
	protected String file;
	protected Long line;
	protected String code;
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
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
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
	@Override
	public String toString() {
		return "Defect [language=" + language + ", characteristic="
				+ characteristic + ", priority=" + priority + ", difficulty="
				+ difficulty + ", rule=" + rule + ", file=" + file + ", line="
				+ line + ", code=" + code + "]";
	}
	
}
