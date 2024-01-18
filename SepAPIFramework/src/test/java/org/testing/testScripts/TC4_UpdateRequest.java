package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
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

public class TC4_UpdateRequest {
	
	@Test
	public void testCase4() throws IOException {
		
	    ExtentReports extent=Report.handleReports();
	    ExtentTest test=extent.startTest("TC4_UpdateRequest");
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		String requestBody=jsonFile.LoadJsonData("../SepAPIFramework/src/test/java/org/testing/resources/updateRequest.json");
		requestBody=JsonReplacement.jsonVariableAssign(requestBody, "id", TC1_PostRequest.returnidValue);
		System.out.println("Request body is ");
		System.out.println(requestBody);
		HTTPMethods http=new HTTPMethods(pr);
		Response resObj=http.PutMethod(requestBody, "QA_URI", TC1_PostRequest.returnidValue);
		Boolean result=validateResponse.statusCodeValidate(200,resObj);
		Boolean dataresult=validateResponse.responseDataValidate("Mitchel33", resObj, "firstName");
		Boolean dataresult1=validateResponse.responseDataValidate("Marsh33", resObj, "lastName");
		//Boolean dataresult2=validateResponse.responseDataValidate("{{id}}",resObj, "id");
		Boolean dataresult3=validateResponse.responseDataValidate("Team Lead", resObj, "designation");
		if((result==false)||(dataresult==false)||(dataresult1==false)||(dataresult3==false))
		{
			test.log(LogStatus.FAIL,"Status code/Data is not matching");
			extent.endTest(test);
			extent.flush();
			Assert.assertTrue(result);
		}
		else
		{
		test.log(LogStatus.PASS,"Status code and Data is matching");
		extent.endTest(test);
		extent.flush();
		}
	}

}
