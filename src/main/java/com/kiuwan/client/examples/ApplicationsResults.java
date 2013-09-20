package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.Application;
import com.kiuwan.client.model.ApplicationResults;

public class ApplicationsResults {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		//client.activateLog();

		try {
			List<Application> apps = client.getApplications();
			
			System.out.println("Found " + apps.size() + " applications in your account.\n");
			for(Application app: apps) {
				ApplicationResults results = client.getApplicationResults(app.getName());
				System.out.println(results);
			}
			
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
