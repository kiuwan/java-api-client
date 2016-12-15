package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.delivery.DeliveryBean;

public class ListDeliveries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 3)
	    {
	        System.out.println("You need to pass 3 parameters: username password applicationName");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		String applicationName = args[2];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<DeliveryBean> deliveries = client.getDeliveries(applicationName);
			
			System.out.println("Found " + deliveries.size() + " deliveries in the application "+applicationName+".\n");
			for(DeliveryBean delivery: deliveries) {
				System.out.println(delivery);
			}
			
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
