package com.kiuwan.client.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

	protected String name;
	protected String description;
	protected String applicationBusinessValue;
	protected String applicationProvider;
	protected Map<String, String> applicationPortfolios = new HashMap<String, String>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getApplicationBusinessValue() {
		return applicationBusinessValue;
	}

	public void setApplicationBusinessValue(String applicationBusinessValue) {
		this.applicationBusinessValue = applicationBusinessValue;
	}

	public String getApplicationProvider() {
		return applicationProvider;
	}

	public void setApplicationProvider(String applicationProvider) {
		this.applicationProvider = applicationProvider;
	}

	public Map<String, String> getApplicationPortfolios() {
		return applicationPortfolios;
	}

	public void setApplicationPortfolios(Map<String, String> applicationPortfolios) {
		this.applicationPortfolios = applicationPortfolios;
	}

	@Override
	public String toString() {
		return "Application [name=" + name + ", description=" + description + "]";
	}
	
}
