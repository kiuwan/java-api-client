package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.AnalysisComparation;
import com.kiuwan.client.model.Defect;

public class CompareAnalysisDefects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 4)
	    {
	        System.out.println("You need to pass 4 parameters: username password mainAnalysisCode previousAnalysisCode");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String mainAnalysisCode = args[2];
		String previousAnalysisCode = args[3];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		//client.activateLog();

		try {
			AnalysisComparation comparation = client.getAnalysisComparation(mainAnalysisCode, previousAnalysisCode);
			System.out.println(comparation);
			
			List<Defect> newDefects = client.getAllNewDefects(mainAnalysisCode, previousAnalysisCode);
			System.out.println("********New defects (" + newDefects.size() + "): ");
			for (Defect defect: newDefects) {
				System.out.println(defect);
			}
			
			List<Defect> removedDefects = client.getAllRemovedDefects(mainAnalysisCode, previousAnalysisCode);
			System.out.println("********Removed defects (" + removedDefects.size() + "): ");
			for (Defect defect: removedDefects) {
				System.out.println(defect);
			}
			
			
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
