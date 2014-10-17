package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.List;

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
