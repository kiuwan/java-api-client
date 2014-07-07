package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.Defect;

public class AnalysisDefects {

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
			List<Defect> defects = client.getAllAnalysisDefects(analysisCode);
			for (Defect defect: defects) {
				System.out.println(defect);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
