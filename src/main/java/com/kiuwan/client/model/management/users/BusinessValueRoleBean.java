package com.kiuwan.client.model.management.users;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessValueRoleBean {

	/**
	 * Available business values: CRITICAL, HIGH, MEDIUM, LOW and VERY LOW.
	 */
	public final static String CRITICAL = "CRITICAL";
	public final static String HIGH = "HIGH";
	public final static String MEDIUM = "MEDIUM";
	public final static String LOW = "LOW";
	public final static String VERY_LOW = "VERY LOW";
	
	private String portfolioValue;

	private String roleName;
	
	/**
	 * @return the portfolioValue
	 */
	public String getPortfolioValue() {
		return portfolioValue;
	}

	/**
	 * @param portfolioValue the portfolioValue to set
	 */
	public void setPortfolioValue(String portfolioValue) {
		this.portfolioValue = portfolioValue;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
