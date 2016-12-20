package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.violatedrule.FileWithDefectsBean;

public class GetViolatedRuleFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 5)
	    {
	        System.out.println("You need to pass 5 parameters: username password applicationName analysisCode ruleCode");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String analysisCode = args[3];
		String ruleCode = args[4];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<FileWithDefectsBean> violatedRuleFiles = client.getViolatedRuleFiles(applicationName, analysisCode, ruleCode);
			for (FileWithDefectsBean fileWithDefectsBean : violatedRuleFiles) {
				System.out.println(fileWithDefectsBean);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
