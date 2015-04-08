package com.kiuwan.client.model.management.applications;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationBean {

	public static final String BUSINESS_VALUE_CRITICAL = "CRITICAL";
	public static final String BUSINESS_VALUE_HIGH = "HIGH";
	public static final String BUSINESS_VALUE_MEDIUM = "MEDIUM";
	public static final String BUSINESS_VALUE_LOW = "LOW";
	public static final String BUSINESS_VALUE_VERY_LOW = "VERY_LOW";
	
	public static final String TARGET_EFFICIENCY = "EFFICIENCY";
	public static final String TARGET_MAINTAINABILITY = "MAINTAINABILITY";
	public static final String TARGET_PORTABILITY = "PORTABILITY";
	public static final String TARGET_RELIABILITY = "RELIABILITY";
	public static final String TARGET_SECURITY = "SECURITY";
	
	private String name;
	
	private String model;
	
	private String description;
	
	private String newName;
	
	private String businessValue;
	
	private Collection<PortfolioBean> portfolios = new HashSet<PortfolioBean>();

	private Map<String, Double> targets = new HashMap<String, Double>();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the portfolios
	 */
	public Collection<PortfolioBean> getPortfolios() {
		return portfolios;
	}

	/**
	 * @param portfolios the portfolios to set
	 */
	public void setPortfolios(Collection<PortfolioBean> portfolios) {
		this.portfolios = portfolios;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(String businessValue) {
		this.businessValue = businessValue;
	}

	/**
	 * @return the targets
	 */
	public Map<String, Double> getTargets() {
		return targets;
	}

	/**
	 * @param targets the targets to set
	 */
	public void setTargets(Map<String, Double> targets) {
		this.targets = targets;
	}
	
}