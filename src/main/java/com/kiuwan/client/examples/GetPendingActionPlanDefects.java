package com.kiuwan.client.examples;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.actionplan.ActionPlanBean;

public class GetPendingActionPlanDefects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 4)
	    {
	        System.out.println("You need to pass 4 parameters: username password applicationName actionPlanName");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String actionPlanName = args[3];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			ActionPlanBean actionPlan = client.getPendingActionPlanDefects(applicationName, actionPlanName);
			System.out.println(actionPlan);
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
