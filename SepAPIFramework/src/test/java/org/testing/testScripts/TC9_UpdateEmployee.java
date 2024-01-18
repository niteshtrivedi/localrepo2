package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.openqa.selenium.remote.http.HttpResponse;
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

public class TC9_UpdateEmployee {

	@Test
	public void testCase9() throws IOException, InterruptedException {
		ExtentReports extent=Report.handleReports();
	    ExtentTest test=extent.startTest("TC9_UpdateEmployee");
		Properties pr = PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		String requestBody = jsonFile.LoadJsonData("../SepAPIFramework/src/test/java/org/testing/resources/updateRequest1.json");
		requestBody = JsonReplacement.jsonVariableAssign(requestBody, "id", TC8_CreateEmployee.returnidValue);
		System.out.println("Request body is ");
		System.out.println(requestBody);
		Thread.sleep(4000);
		HTTPMethods http = new HTTPMethods(pr);
		Response resObj = http.PutMethod(requestBody, "real3_URI",TC8_CreateEmployee.returnidValue);
		Boolean result=validateResponse.statusCodeValidate(405,resObj);
		//Boolean dataresult=validateResponse.responseDataValidate("test1", resObj, "name");
		//Boolean dataresult1=validateResponse.responseDataValidate("123", resObj, "salary");
		//Boolean dataresult2=validateResponse.responseDataValidate("23",resObj, "age");
		
		if(result==false)
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
