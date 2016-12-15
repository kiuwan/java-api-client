package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.audit.CheckpointDefectBean;

public class GetCheckpointDefects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 7)
	    {
	        System.out.println("You need to pass 7 parameters: username password applicationName deliveryCode ruleCode checkpointId fileName");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String deliveryCode = args[3];
		String ruleCode = args[4];
		String checkpointId = args[5];
		String fileName = args[6];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<CheckpointDefectBean> checkpointDefects = client.getCheckpointDefects(applicationName, deliveryCode, ruleCode, checkpointId, fileName);
			for (CheckpointDefectBean checkpointDefectBean : checkpointDefects) {
				System.out.println(checkpointDefectBean);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
	}

}
