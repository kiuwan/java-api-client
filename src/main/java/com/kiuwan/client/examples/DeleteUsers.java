package com.kiuwan.client.examples;

import java.util.Collections;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.users.UserBean;

public class DeleteUsers {

	public static void main(String[] args) throws KiuwanClientException {
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		UserBean userBean = new UserBean();
		userBean.setUsername("username");
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.deleteUsers(Collections.singletonList(userBean));
		System.out.println(result);
	}
	
}
