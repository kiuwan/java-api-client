/**
 * 
 */
package com.kiuwan.client.model.management.users;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBean {

	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Boolean enabled;

	/**
	 * Indicates if the user is the owner of the account or not.
	 * This field is only for read purpose. When used in update operation this field is ignored.  
	 */
	private Boolean isOwner;

	/**
	 * Indicates if user's password must be generated and sent via email or not.
	 * This field is taken in account only when create a new user. 
	 */
	private Boolean generatePassword;
	
	/**
	 * Indicates if user's password must be regenerated or not.
	 * This field is taken in account only when modify an existent user. 
	 */
	private Boolean regeneratePassword;
	
	private AccessControlConfigurationBean accessControlConfiguration;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the isOwner
	 */
	public Boolean getIsOwner() {
		return isOwner;
	}

	/**
	 * @param isOwner the isOwner to set
	 */
	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
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

	public Boolean getGeneratePassword() {
		return generatePassword;
	}

	public void setGeneratePassword(Boolean generatePassword) {
		this.generatePassword = generatePassword;
	}

	/**
	 * @return the regeneratePassword
	 */
	public Boolean getRegeneratePassword() {
		return regeneratePassword;
	}
	
	/**
	 * @param regeneratePassword the regeneratePassword to set
	 */
	public void setRegeneratePassword(Boolean regeneratePassword) {
		this.regeneratePassword = regeneratePassword;
	}

}