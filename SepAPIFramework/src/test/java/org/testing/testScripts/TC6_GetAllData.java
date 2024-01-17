package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingOrgJson;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC6_GetAllData {
	
	@Test
	public void testcase6() throws IOException {
		
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response resObj=http.GETALLMETHOD("real_URI");
		JsonParsingOrgJson.doParsing(resObj,"id");
		System.out.println(resObj);
		System.out.println(resObj.asString());
		
		
	}

}
