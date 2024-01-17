package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

public class TC5_DeleteRequest {

	@Test
	public void testCase5() throws IOException {
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		http.DeleteMethod("QA_URI",TC1_PostRequest.returnidValue);
		
	}
}
