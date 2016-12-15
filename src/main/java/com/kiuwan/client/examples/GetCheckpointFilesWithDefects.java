package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.audit.CheckpointFileWithDefectsBean;

public class GetCheckpointFilesWithDefects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 6)
	    {
	        System.out.println("You need to pass 6 parameters: username password applicationName deliveryCode ruleCode checkpointId ");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String deliveryCode = args[3];
		String ruleCode = args[4];
		String checkpointId = args[5];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<CheckpointFileWithDefectsBean> checkpointFilesWithDefects = client.getCheckpointFilesWithDefects(applicationName, deliveryCode, ruleCode, checkpointId);
			for (CheckpointFileWithDefectsBean checkpointFileWithDefectsBean : checkpointFilesWithDefects) {
				System.out.println(checkpointFileWithDefectsBean);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
