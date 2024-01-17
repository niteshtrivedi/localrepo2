package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingJsonPath;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.jsonFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC1_PostRequest {
	public static String returnidValue;
	@Test
	public void testcase1() throws IOException {
		
		System.out.println("Please enter id value");
		//Scanner s=new Scanner(System.in);
		//Integer idvalue=s.nextInt();
		Random r=new Random();
		Integer idvalue=r.nextInt();

		//String firstName=s.next();
		//String lastName=s.next();
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		String requestBody=jsonFile.LoadJsonData("../SepAPIFramework/src/test/java/org/testing/resources/inputRequest.json");
		requestBody=JsonReplacement.jsonVariableAssign(requestBody, "id", idvalue.toString());
		//requestBody=JsonReplacement.jsonVariableAssign(requestBody, "firstName", firstName);
		//requestBody=JsonReplacement.jsonVariableAssign(requestBody, "lastName", lastName);
		System.out.println("Request body is ");
		System.out.println(requestBody);
		HTTPMethods http=new HTTPMethods(pr);
		Response resObj=http.PostMethod(requestBody, "QA_URI");
		returnidValue=JsonParsingUsingJsonPath.jsonParsing(resObj, "id");
	}

}
