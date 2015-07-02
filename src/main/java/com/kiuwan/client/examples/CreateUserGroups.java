/**
 * 
 */
package com.kiuwan.client.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.users.AccessControlConfigurationBean;
import com.kiuwan.client.model.management.users.ApplicationRoleBean;
import com.kiuwan.client.model.management.users.PortfolioRoleBean;
import com.kiuwan.client.model.management.users.groups.UserGroupBean;

public class CreateUserGroups {
	
	public static void main(String[] args) throws KiuwanClientException {
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		UserGroupBean userGroupBean = new UserGroupBean();
		userGroupBean.setName("TheGroup");
		userGroupBean.setUsers(Arrays.asList("john@mycompany.com", "luis@mycompany.com", "kate@mycompany.com"));
		
		ApplicationRoleBean applicationRoleBean = new ApplicationRoleBean();
		applicationRoleBean.setName("TheApplication");
		applicationRoleBean.setOverride(false);
		applicationRoleBean.setRoleName("Readonly");
		
		Collection<ApplicationRoleBean> applicationRoles = new ArrayList<ApplicationRoleBean>();
		applicationRoles.add(applicationRoleBean);
		
		Collection<String> managementFeatures = new ArrayList<String>();
		managementFeatures.add(AccessControlConfigurationBean.MANAGE_MODELS);
		
		PortfolioRoleBean portfolioRoleBean = new PortfolioRoleBean();
		portfolioRoleBean.setPortfolioName("TechPortfolio");
		portfolioRoleBean.setPortfolioValue("JavaApplications");
		portfolioRoleBean.setRoleName("Write");
		
		Collection<PortfolioRoleBean> portfolioRoles = new ArrayList<PortfolioRoleBean>();
		portfolioRoles.add(portfolioRoleBean);
		
		AccessControlConfigurationBean accessControlConfiguration = new AccessControlConfigurationBean();
		accessControlConfiguration.setApplicationRoles(applicationRoles);
		accessControlConfiguration.setManagementFeatures(managementFeatures);
		accessControlConfiguration.setPortfolioRoles(portfolioRoles);
		
		userGroupBean.setAccessControlConfiguration(accessControlConfiguration);
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.createUserGroups(Collections.singletonList(userGroupBean));
		System.out.println(result);
	}

}