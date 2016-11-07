package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.actionplan.ActionPlanBean;

public class ListActionPlans {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 3)
	    {
	        System.out.println("You need to pass 3 parameters: username password applicationName");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<ActionPlanBean> actionPlans = client.listActionPlans(applicationName);
			
			System.out.println("Found " + actionPlans.size() + " action plans in the application "+applicationName+".\n");
			for(ActionPlanBean actionPlan: actionPlans) {
				System.out.println(actionPlan);
			}
			
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
