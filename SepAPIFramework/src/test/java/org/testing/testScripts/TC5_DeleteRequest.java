package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import junit.framework.Assert;

public class TC5_DeleteRequest {

	@Test
	public void testCase5() throws IOException {
		
	    ExtentReports extent=Report.handleReports();
	    ExtentTest test=extent.startTest("TC5_DeleteRequest");
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response resObj=http.DeleteMethod("QA_URI",TC1_PostRequest.returnidValue);
		Boolean result=validateResponse.statusCodeValidate(200,resObj);
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
	}
}
