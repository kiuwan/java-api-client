package com.kiuwan.client.model;

public class Language {

	protected String name;
	protected Double size;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Language [name=" + name + ", size=" + size + "]";
	}
	
}
