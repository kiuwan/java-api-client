package com.kiuwan.client.model.management.applications;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioBean {
	
	protected String portfolioName;
	
	private String portfolioValue;

	public String getPortfolioName() {
		return portfolioName;
	}
	
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	
	public String getPortfolioValue() {
		return portfolioValue;
	}

	public void setPortfolioValue(String portfolioValue) {
		this.portfolioValue = portfolioValue;
	}

}