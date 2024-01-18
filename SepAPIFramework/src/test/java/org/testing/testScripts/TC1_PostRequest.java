package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingJsonPath;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testing.utilities.jsonFile;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import junit.framework.Assert;

public class TC1_PostRequest {
	public static String returnidValue;
	@Test
	public void testcase1() throws IOException {
		
		ExtentReports extent=Report.handleReports();
		ExtentTest test=extent.startTest("TC1_PostRequest");
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
		Boolean result=validateResponse.statusCodeValidate(201, resObj);
		if(result==false)
		{
			test.log(LogStatus.FAIL,"Status code is not matching");
			extent.endTest(test);
			extent.flush();
			Assert.assertTrue(result);
		}
		else
		{
		test.log(LogStatus.PASS,"Status code is matching");
		extent.endTest(test);
		extent.flush();
		}
		returnidValue=JsonParsingUsingJsonPath.jsonParsing(resObj, "id");
	}

}
