package com.kiuwan.client.examples;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.doc.RuleDocumentationBean;

public class GetRuleDocumentation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 5)
	    {
	        System.out.println("You need to pass 5 parameters: username password applicationName modelId ruleCode");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String modelId = args[3];
		String ruleCode = args[4];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			RuleDocumentationBean ruleDocumentation = client.getRuleDocumentation(applicationName, modelId, ruleCode);
			System.out.println(ruleDocumentation);
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
