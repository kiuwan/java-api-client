package com.kiuwan.client.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.utils.ClassToStringConverter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckpointDefectBean {

	private String code;
	private Integer line;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the line
	 */
	public Integer getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return  ClassToStringConverter.toString("Checkpoint Defect", this);
	}
	
}
