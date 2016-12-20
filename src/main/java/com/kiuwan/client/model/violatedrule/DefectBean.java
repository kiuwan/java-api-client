package com.kiuwan.client.model.violatedrule;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefectBean {

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
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ClassToStringConverter.toString("Defect", this);
	}
	
}