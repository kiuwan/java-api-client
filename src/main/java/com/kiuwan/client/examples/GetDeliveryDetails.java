package com.kiuwan.client.examples;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.delivery.DeliveryDetailsBean;

public class GetDeliveryDetails {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 5)
	    {
	        System.out.println("You need to pass 5 parameters: username password applicationName changeRequest label");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		String changeRequest = args[3];
		String label = args[4];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			DeliveryDetailsBean deliveryDetails = client.getDeliveryDetails(applicationName, changeRequest, label);
			System.out.println(deliveryDetails);
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
