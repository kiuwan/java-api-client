package com.kiuwan.client.examples;

import java.util.Collections;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.users.groups.UserGroupBean;

public class DeleteUserGroups {

	public static void main(String[] args) throws KiuwanClientException {
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		UserGroupBean userGroupBean = new UserGroupBean();
		userGroupBean.setName("MyGroup");
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.deleteUserGroups(Collections.singletonList(userGroupBean));
		System.out.println(result);
	}
	
}
