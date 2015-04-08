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


public class CreateApplications {

	public static void main(String[] args) throws KiuwanClientException {
		if(args.length != 2)
	    {
	        System.out.println("You need to pass 2 parameters: username password");
	        return;
	    }
		
		String username = args[0];
		String password = args[1];
		
		PortfolioBean portfolioBean = new PortfolioBean();
		portfolioBean.setPortfolioName("MyPortfolio");
		portfolioBean.setPortfolioValue("LightweightApplications");
		
		Collection<PortfolioBean> portfolios = new ArrayList<PortfolioBean>();
		portfolios.add(portfolioBean);

		Map<String, Double> targets = new HashMap<String, Double>();
		targets.put(ApplicationBean.TARGET_EFFICIENCY, 1.0);
		targets.put(ApplicationBean.TARGET_MAINTAINABILITY, 2.0);
		targets.put(ApplicationBean.TARGET_PORTABILITY, 3.0);
		targets.put(ApplicationBean.TARGET_RELIABILITY, 4.0);
		targets.put(ApplicationBean.TARGET_SECURITY, 5.0);
		
		ApplicationBean application = new ApplicationBean();
		application.setName("MyFirstApplication");
		application.setModel("CQM");
		application.setDescription("This is my first application created in Kiuwan.");
		application.setPortfolios(portfolios);
		application.setBusinessValue(ApplicationBean.BUSINESS_VALUE_LOW);
		application.setTargets(targets);
		
		KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);
		String result = client.createApplications(Collections.singletonList(application));
		
		System.out.println(result);
	}
	
}