package com.kiuwan.client.examples;

import java.util.List;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.PortfolioDefinitionBean;

public class ListPortfolioDefinitions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

		try {
			List<PortfolioDefinitionBean> portfolioDefinitions = client.listPortfolioDefinitions();
			
			for(PortfolioDefinitionBean portfolioDefinition: portfolioDefinitions) {
				System.out.println(portfolioDefinition);
			}
			
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
		
	}

}
