package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testing.responseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testing.utilities.Report;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC3_GetParticularRequest {
	
@Test	
public void testcase3() throws IOException {
	
	    ExtentReports extent=Report.handleReports();
	    ExtentTest test=extent.startTest("TC3_GetParticularRequest");

		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response resObj=http.GetParticular("QA_URI",TC1_PostRequest.returnidValue);
		Boolean result=validateResponse.statusCodeValidate(200,resObj);
		Boolean dataresult=validateResponse.responseDataValidate("Jacob", resObj, "firstName");
		Boolean dataresult1=validateResponse.responseDataValidate("oram", resObj, "lastName");
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
