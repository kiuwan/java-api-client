package com.kiuwan.client.examples;

import java.util.Collections;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.PortfolioDefinitionBean;

public class SavePortfolioDefinitions {

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
			//Adds a new provider named 'TestProvider'. The description is null so it is not updated.
			PortfolioDefinitionBean portfolioDefinitionBean = new PortfolioDefinitionBean();
			portfolioDefinitionBean.setName("provider");
			portfolioDefinitionBean.setDescription(null);
			portfolioDefinitionBean.setIsSystemPortfolio(true);
			portfolioDefinitionBean.setValues(Collections.singleton("TestProvider"));
			
			String result = client.savePortfolioDefinitions(Collections.singleton(portfolioDefinitionBean));
			System.out.println(result);
		} catch (KiuwanClientException e) {
			e.printStackTrace();
		}
	}

}
