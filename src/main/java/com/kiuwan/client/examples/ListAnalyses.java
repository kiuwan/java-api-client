package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.AnalysisBean;

public class ListAnalyses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 3 parameters: username password applicationName");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<AnalysisBean> analyses = client.getAnalyses(applicationName);
			
			System.out.println("Found " + analyses.size() + " analyses in the application "+applicationName+".\n");
			for(AnalysisBean analysis: analyses) {
				System.out.println(analysis);
			}
			
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
