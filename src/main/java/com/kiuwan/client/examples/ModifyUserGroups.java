package com.kiuwan.client.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.users.AccessControlConfigurationBean;
import com.kiuwan.client.model.management.users.PortfolioRoleBean;
import com.kiuwan.client.model.management.users.groups.UserGroupBean;

public class ModifyUserGroups {

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
		userGroupBean.setNewName("MyGroup");
		//Overwrites the existing group members. So removes the existing users from the group before adding these users.
		userGroupBean.setUsers(Arrays.asList("john@mycompany.com", "emily@mycompany.com"));
		
		PortfolioRoleBean portfolioRoleBean = new PortfolioRoleBean();
		portfolioRoleBean.setPortfolioName("TechPortfolio");
		portfolioRoleBean.setPortfolioValue("C-SharpApplications");
		portfolioRoleBean.setRoleName("Readonly");
		
		Collection<PortfolioRoleBean> portfolioRoles = new ArrayList<PortfolioRoleBean>();
		portfolioRoles.add(portfolioRoleBean);
		
		AccessControlConfigurationBean accessControlConfiguration = new AccessControlConfigurationBean();
		accessControlConfiguration.setPortfolioRoles(portfolioRoles);
		accessControlConfiguration.setAssignmentMode("ADD");
		
		userGroupBean.setAccessControlConfiguration(accessControlConfiguration);
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.modifyUserGroups(Collections.singletonList(userGroupBean));
		
		System.out.println(result);
	}
	
}