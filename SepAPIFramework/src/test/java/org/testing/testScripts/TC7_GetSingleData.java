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

public class TC7_GetSingleData {
	
	@Test	
	public void testcase7() throws IOException {
		
		    ExtentReports extent=Report.handleReports();
	        ExtentTest test=extent.startTest("TC7_GetSingleData");		
			Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
			HTTPMethods http=new HTTPMethods(pr);
			Response resObj= http.GETALLMETHOD("real1_URI");
			Boolean result=validateResponse.statusCodeValidate(200,resObj);
			//Boolean dataresult=validateResponse.responseDataValidate("Tiger Nixon", resObj, "employee_name");
			//Boolean dataresult1=validateResponse.responseDataValidate("320800", resObj, "employee_salary");
			//Boolean dataresult2=validateResponse.responseDataValidate("1",resObj, "id");
			//Boolean dataresult3=validateResponse.responseDataValidate("61", resObj, "employee_age");
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
