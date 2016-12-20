package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.violatedrule.DefectBean;

public class GetViolatedRuleFileDefects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 6)
	    {
	        System.out.println("You need to pass 6 parameters: username password applicationName analysisCode ruleCode file");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String analysisCode = args[3];
		String ruleCode = args[4];
		String file = args[5];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<DefectBean> violatedRuleFileDefects = client.getViolatedRuleFileDefects(applicationName, analysisCode, ruleCode, file);
			for (DefectBean defectBean : violatedRuleFileDefects) {
				System.out.println(defectBean);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
