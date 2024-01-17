package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC3_GetParticularRequest {
	
@Test	
public void testcase3() throws IOException {

		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		http.GetParticular("QA_URI",TC1_PostRequest.returnidValue);
		
	}

}
