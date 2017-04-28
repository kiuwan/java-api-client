package com.kiuwan.client.model.violatedrule;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefectBean {

	private String code;
	private Integer line;
	private Boolean muted;
	
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ClassToStringConverter.toString("Defect", this);
	}
	
}