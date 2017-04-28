package com.kiuwan.client.model.management.users;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationRoleBean {

	/**
	 * Name of the application.
	 */
	private String name;
	
	/**
	 * Name of the role to assign.
	 */
	private String roleName;
	
	/**
	 * Indicates if override the configuration or not.
	 */
	private Boolean override;

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

	/**
	 * @return the override
	 */
	public Boolean getOverride() {
		return override;
	}

	/**
	 * @param override the override to set
	 */
	public void setOverride(Boolean override) {
		this.override = override;
	}
	
}
