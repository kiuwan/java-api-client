package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricValue {

	protected String name;
	protected Double value;
	protected List<MetricValue> children = new ArrayList<MetricValue>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public List<MetricValue> getChildren() {
		return children;
	}
	public void setChildren(List<MetricValue> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "MetricValue [name=" + name + ", value=" + value + "]";
	}
	
	
}
