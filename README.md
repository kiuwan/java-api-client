java-api-client
===============

Kiuwan Java client for REST API.

Maven configuration:

	<dependency>
		<groupId>com.kiuwan</groupId>
		<artifactId>java-api-client</artifactId>
		<version>0.0.3</version>
	</dependency>
	

Supported actions are:

  - List your applications.
  - Get last analysis results from your application.
  - Get all defects from your application.
  - Get files (with metric values and defects) from your application.
  - Get all defects from your application indicating the analysis code.
  - Get files (with metric values and defects) from your application indicating the analysis code.
  - Get the differences of defects between two analysis.
  
Source code includes examples that shows you how to execute each supported action.

  - <a href="src/main/java/com/kiuwan/client/examples/ListApplications.java">com.kiuwan.client.examples.ListApplications.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ApplicationsResults.java">com.kiuwan.client.examples.ApplicationsResults.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ApplicationDefects.java">com.kiuwan.client.examples.ApplicationDefects.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/ApplicationFiles.java">com.kiuwan.client.examples.ApplicationFiles.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/AnalysisDefects.java">com.kiuwan.client.examples.AnalysisDefects.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/AnalysisFiles.java">com.kiuwan.client.examples.AnalysisFiles.java</a>
  - <a href="src/main/java/com/kiuwan/client/examples/CompareAnalysisDefects.java">com.kiuwan.client.examples.CompareAnalysisDefects.java</a>

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

