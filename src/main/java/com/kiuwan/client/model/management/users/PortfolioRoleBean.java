package com.kiuwan.client.model.management.users;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioRoleBean {

	private String portfolioName;
	
	private String portfolioValue;

	private String roleName;
	
	/**
	 * @return the portfolioName
	 */
	public String getPortfolioName() {
		return portfolioName;
	}

	/**
	 * @param portfolioName the portfolioName to set
	 */
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

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
