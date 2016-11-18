package com.kiuwan.client.model.management;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Bean containing the portfolio criterion information.
 */
@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioDefinitionBean {

	private String name;
	private Collection<String> values;
	private Boolean isSystemPortfolio;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<String> getValues() {
		return values;
	}
	
	public void setValues(Collection<String> values) {
		this.values = values;
	}
	
	public Boolean getIsSystemPortfolio() {
		return isSystemPortfolio;
	}
	
	public void setIsSystemPortfolio(Boolean isSystemPortfolio) {
		this.isSystemPortfolio = isSystemPortfolio;
	}
	
	@Override
	public String toString() {
		return "Portfolio Definition [name=" + name + ", values=" + values + ", Is System Portfolio=" + isSystemPortfolio + "]";
	}
	
}
