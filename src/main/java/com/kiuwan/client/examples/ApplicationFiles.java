package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.File;

public class ApplicationFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 3)
	    {
	        System.out.println("You need to pass 3 parameters: username password appName");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String appName = args[2];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
//		client.activateLog();

		try {
			List<File> files = client.getAllFiles(appName);
			for (File file: files) {
				System.out.println(file);
			}
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
