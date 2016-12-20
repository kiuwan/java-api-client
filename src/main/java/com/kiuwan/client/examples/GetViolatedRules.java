package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.violatedrule.ViolatedRuleBean;

public class GetViolatedRules {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 4)
	    {
	        System.out.println("You need to pass 4 parameters: username password applicationName analysisCode");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String analysisCode = args[3];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<ViolatedRuleBean> violatedRules = client.getViolatedRules(applicationName, analysisCode);
			for (ViolatedRuleBean violatedRuleBean : violatedRules) {
				System.out.println(violatedRuleBean);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
