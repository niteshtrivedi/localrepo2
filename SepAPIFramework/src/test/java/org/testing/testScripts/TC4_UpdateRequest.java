package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.jsonFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC4_UpdateRequest {
	
	@Test
	public void testCase4() throws IOException {
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		String requestBody=jsonFile.LoadJsonData("../SepAPIFramework/src/test/java/org/testing/resources/updateRequest.json");
		requestBody=JsonReplacement.jsonVariableAssign(requestBody, "id", TC1_PostRequest.returnidValue);
		System.out.println("Request body is ");
		System.out.println(requestBody);
		HTTPMethods http=new HTTPMethods(pr);
		Response resObj=http.PutMethod(requestBody, "QA_URI", TC1_PostRequest.returnidValue);

	}

}
