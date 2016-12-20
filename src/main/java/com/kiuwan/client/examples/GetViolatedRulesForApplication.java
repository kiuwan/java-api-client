package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.violatedrule.ViolatedRuleBean;

public class GetViolatedRulesForApplication {

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
			List<ViolatedRuleBean> violatedRules = client.getViolatedRulesForApplication(applicationName);
			for (ViolatedRuleBean violatedRuleBean : violatedRules) {
				System.out.println(violatedRuleBean);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
