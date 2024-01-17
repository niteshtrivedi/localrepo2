package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC7_GetSingleData {
	
	@Test	
	public void testcase7() throws IOException {
			
			Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
			HTTPMethods http=new HTTPMethods(pr);
			Response resObj= http.GETALLMETHOD("real1_URI");
		}

}
