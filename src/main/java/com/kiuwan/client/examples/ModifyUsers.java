package com.kiuwan.client.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.users.AccessControlConfigurationBean;
import com.kiuwan.client.model.management.users.ApplicationRoleBean;
import com.kiuwan.client.model.management.users.PortfolioRoleBean;
import com.kiuwan.client.model.management.users.UserBean;

public class ModifyUsers {

	public static void main(String[] args) throws KiuwanClientException {
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		UserBean userBean = new UserBean();
		//Username can not be modified.
		userBean.setUsername("username");
		userBean.setFirstName("newFirstName");
		userBean.setLastName("newLastName");
		userBean.setEnabled(true);
		userBean.setRegeneratePassword(false);
		
		ApplicationRoleBean applicationRoleBean = new ApplicationRoleBean();
		applicationRoleBean.setName("MyApplication");
		//Overrides portfolio role for this application.
		applicationRoleBean.setOverride(true);
		applicationRoleBean.setRoleName("write");
		
		Collection<ApplicationRoleBean> applicationRoles = new ArrayList<ApplicationRoleBean>();
		applicationRoles.add(applicationRoleBean);

		//Overwriting (AccessControlConfigurationBean.managementMode: OVERWRITE) with empty managementFeatures, disables all existing managementFeatures for the user.
		Collection<String> managementFeatures = new ArrayList<String>();
		
		PortfolioRoleBean portfolioRoleBean = new PortfolioRoleBean();
		portfolioRoleBean.setPortfolioName("MyPortfolio");
		portfolioRoleBean.setPortfolioValue("JavaApplications");
		portfolioRoleBean.setRoleName("none");
		
		Collection<PortfolioRoleBean> portfolioRoles = new ArrayList<PortfolioRoleBean>();
		portfolioRoles.add(portfolioRoleBean);
		
		AccessControlConfigurationBean accessControlConfiguration = new AccessControlConfigurationBean();
		accessControlConfiguration.setApplicationRoles(applicationRoles);
		accessControlConfiguration.setManagementFeatures(managementFeatures);
		accessControlConfiguration.setPortfolioRoles(portfolioRoles);
		accessControlConfiguration.setAssignmentMode("OVERWRITE");
		
		userBean.setAccessControlConfiguration(accessControlConfiguration);
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.modifyUsers(Collections.singletonList(userBean));
		
		System.out.println(result);
	}
	
}