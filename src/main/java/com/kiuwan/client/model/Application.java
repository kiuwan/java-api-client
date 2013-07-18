package com.kiuwan.client.model;

public class Application {

	protected String name;
	protected String description;
	
	
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
	
	@Override
	public String toString() {
		return "Application [name=" + name + ", description=" + description + "]";
	}
	
	
}
