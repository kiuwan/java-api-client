java-api-client
===============

Kiuwan Java client for REST API.

Maven configuration:

	<dependency>
		<groupId>com.kiuwan</groupId>
		<artifactId>java-api-client</artifactId>
		<version>0.1.0</version>
	</dependency>
		
Supported actions are: (New actions added in this version are marked with *)

  - List action plans of an application. (*)
  - List analyses of an application.
  - List portfolio definitions of an account. (*)
  - List your applications.
  - Get last analysis results from your application.
  - Get all defects from your application.
  - Get files (with metric values and defects) from your application.
  - Get all defects from your application indicating the analysis code.
  - Get files (with metric values and defects) from your application indicating the analysis code.
  - Get metrics from your application indicating the analysis code.
  - Get the differences of defects between two analysis.
  - Get basic information of an action plan. (*)
  - Get all defects in an action plan. (*)
  - Get pending defects of an action plan. (*)
  - Get removed defects of an action plan. (*)
  - Get rule documentation. (*)
  - Create new applications.
  - Create new users in your account.
  - Create new user groups in your account.
  - Delete applications.
  - Delete users of your account.
  - Delete user groups of your account.
  - Modify applications' information.
  - Modify users' information.
  - Modify user groups' information.
  
Source code includes examples that shows you how to execute each supported action.

  - <a href="src/main/java/com/kiuwan/client/examples/ListActionPlans.java">com.kiuwan.client.examples.ListActionPlans.java</a> (*)
  - <a href="src/main/java/com/kiuwan/client/examples/ListAnalyses.java">com.kiuwan.client.examples.ListAnalyses.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ListActionPlans.java">com.kiuwan.client.examples.ListPortfolioDefinitions.java</a> (*)
  - <a href="src/main/java/com/kiuwan/client/examples/ListApplications.java">com.kiuwan.client.examples.ListApplications.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ApplicationsResults.java">com.kiuwan.client.examples.ApplicationsResults.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ApplicationDefects.java">com.kiuwan.client.examples.ApplicationDefects.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ApplicationFiles.java">com.kiuwan.client.examples.ApplicationFiles.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/AnalysisDefects.java">com.kiuwan.client.examples.AnalysisDefects.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/AnalysisFiles.java">com.kiuwan.client.examples.AnalysisFiles.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/AnalysisMetrics.java">com.kiuwan.client.examples.AnalysisMetrics.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/CompareAnalysisDefects.java">com.kiuwan.client.examples.CompareAnalysisDefects.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/GetActionPlanInfo.java">com.kiuwan.client.examples.GetActionPlanInfo.java</a> (*)
  - <a href="src/main/java/com/kiuwan/client/examples/GetAllActionPlanDefects.java">com.kiuwan.client.examples.GetAllActionPlanDefects.java</a> (*)
  - <a href="src/main/java/com/kiuwan/client/examples/GetPendingActionPlanDefects.java">com.kiuwan.client.examples.GetPendingActionPlanDefects.java</a> (*)
  - <a href="src/main/java/com/kiuwan/client/examples/GetRemovedActionPlanDefects.java">com.kiuwan.client.examples.GetRemovedActionPlanDefects.java</a> (*)
  - <a href="src/main/java/com/kiuwan/client/examples/GetRemovedActionPlanDefects.java">com.kiuwan.client.examples.GetRuleDocumentation.java</a> (*)  
  - <a href="src/main/java/com/kiuwan/client/examples/CreateApplications.java">com.kiuwan.client.examples.CreateApplications.java</a> 
  - <a href="src/main/java/com/kiuwan/client/examples/CreateUsers.java">com.kiuwan.client.examples.CreateUsers.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/CreateUserGroups.java">com.kiuwan.client.examples.CreateUserGroups.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/DeleteApplications.java">com.kiuwan.client.examples.DeleteApplications.java</a> 
  - <a href="src/main/java/com/kiuwan/client/examples/DeleteUsers.java">com.kiuwan.client.examples.DeleteUsers.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/DeleteUserGroups.java">com.kiuwan.client.examples.DeleteUserGroups.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ModifyApplications.java">com.kiuwan.client.examples.ModifyApplications.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ModifyUsers.java">com.kiuwan.client.examples.ModifyUsers.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ModifyUserGroups.java">com.kiuwan.client.examples.ModifyUserGroups.java</a>

Example of use:

	KiuwanRestApiClient client = new KiuwanRestApiClient(username, password);

	try {
		List<Application> apps = client.getApplications();
		for(Application app: apps) {
			System.out.println(app);
		}
		
	} catch (KiuwanClientException e) {
		e.printStackTrace();
	}

