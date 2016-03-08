package com.kiuwan.client.examples;

import java.util.Map;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;

public class AnalysisMetrics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 3)
	    {
	        System.out.println("You need to pass 3 parameters: username password analysisCode");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String analysisCode = args[2];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		//client.activateLog();

		try {
			Map<String, Double> metrics = client.getMetrics(analysisCode);
			for (String metricCode: metrics.keySet()) {
				System.out.println(metricCode+": "+metrics.get(metricCode));
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
