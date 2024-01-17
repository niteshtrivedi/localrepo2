package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingJsonPath;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.jsonFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC9_UpdateEmployee {

	@Test
	public void testCase9() throws IOException, InterruptedException {
		Properties pr = PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		String requestBody = jsonFile.LoadJsonData("../SepAPIFramework/src/test/java/org/testing/resources/updateRequest1.json");
		requestBody = JsonReplacement.jsonVariableAssign(requestBody, "id", TC8_CreateEmployee.returnidValue);
		System.out.println("Request body is ");
		System.out.println(requestBody);
		Thread.sleep(4000);
		HTTPMethods http = new HTTPMethods(pr);
		Response resObj = http.PutMethod(requestBody, "real3_URI",TC8_CreateEmployee.returnidValue);

	}

}
