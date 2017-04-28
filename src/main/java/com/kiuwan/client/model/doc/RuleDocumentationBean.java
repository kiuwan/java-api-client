package com.kiuwan.client.model.doc;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuleDocumentationBean {
	
	private String description;
	
	private String code;
	
	private String references;
	
	private String benefits;
	
	private String drawbacks;
	
	private String violationCode;
	
	private String fixedCode;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

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
	 * @return the references
	 */
	public String getReferences() {
		return references;
	}

	/**
	 * @param references the references to set
	 */
	public void setReferences(String references) {
		this.references = references;
	}

	/**
	 * @return the benefits
	 */
	public String getBenefits() {
		return benefits;
	}

	/**
	 * @param benefits the benefits to set
	 */
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	/**
	 * @return the drawbacks
	 */
	public String getDrawbacks() {
		return drawbacks;
	}

	/**
	 * @param drawbacks the drawbacks to set
	 */
	public void setDrawbacks(String drawbacks) {
		this.drawbacks = drawbacks;
	}

	/**
	 * @return the violationCode
	 */
	public String getViolationCode() {
		return violationCode;
	}

	/**
	 * @param violationCode the violationCode to set
	 */
	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	/**
	 * @return the fixedCode
	 */
	public String getFixedCode() {
		return fixedCode;
	}

	/**
	 * @param fixedCode the fixedCode to set
	 */
	public void setFixedCode(String fixedCode) {
		this.fixedCode = fixedCode;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ClassToStringConverter.toString("Rule Documentation", this);
	}
	
}
