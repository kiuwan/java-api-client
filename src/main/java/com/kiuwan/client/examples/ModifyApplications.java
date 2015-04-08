package com.kiuwan.client.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.kiuwan.client.KiuwanClientException;
import com.kiuwan.client.KiuwanRestApiClient;
import com.kiuwan.client.model.management.applications.ApplicationBean;
import com.kiuwan.client.model.management.applications.PortfolioBean;

public class ModifyApplications {

	public static void main(String[] args) throws KiuwanClientException {
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		//Assigns the application into new portfolio without modifying other portfolio assignments.
		PortfolioBean portfolioBean = new PortfolioBean();
		portfolioBean.setPortfolioName("Factory");
		portfolioBean.setPortfolioValue("Sweden");

		Collection<PortfolioBean> portfolios = new ArrayList<PortfolioBean>();
		portfolios.add(portfolioBean);
		
		//Set not indicated targets to default value.
		Map<String, Double> targets = new HashMap<String, Double>();
		targets.put(ApplicationBean.TARGET_SECURITY, 12.34);
		
		ApplicationBean application = new ApplicationBean();
		application.setName("MyFirstApplication");
		application.setNewName("TheApplication");
		application.setModel("CQM for frameworks");
		application.setPortfolios(portfolios);
		application.setBusinessValue(ApplicationBean.BUSINESS_VALUE_MEDIUM);
		application.setTargets(targets);
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.modifyApplications(Collections.singletonList(application));
		
		System.out.println(result);
	}
	
}
