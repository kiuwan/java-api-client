/**
 * 
 */
package com.kiuwan.client.model.management.users.groups;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.model.management.users.AccessControlConfigurationBean;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupBean {

	/**
	 * The name of the group.
	 */
	private String name;
	
	/**
	 * The new name of the group.
	 */
	private String newName;
	
	/**
	 * Members of the group.
	 */
	private Collection<String> users = new ArrayList<String>();

	/**
	 * Access control configuration.
	 */
	private AccessControlConfigurationBean accessControlConfiguration;
	
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
	 * @return the newName
	 */
	public String getNewName() {
		return newName;
	}

	/**
	 * @param newName the newName to set
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}

	/**
	 * @return the users
	 */
	public Collection<String> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Collection<String> users) {
		this.users = users;
	}

	/**
	 * @return the accessControlConfiguration
	 */
	public AccessControlConfigurationBean getAccessControlConfiguration() {
		return accessControlConfiguration;
	}

	/**
	 * @param accessControlConfiguration the accessControlConfiguration to set
	 */
	public void setAccessControlConfiguration(AccessControlConfigurationBean accessControlConfiguration) {
		this.accessControlConfiguration = accessControlConfiguration;
	}
	
}