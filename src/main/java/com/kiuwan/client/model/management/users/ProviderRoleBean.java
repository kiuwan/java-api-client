package com.kiuwan.client.model.management.users;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderRoleBean {

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
