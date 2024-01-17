package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesFile;
import org.testng.annotations.Test;

public class TC10_DeleteEmployee {

	@Test
	public void testCase10() throws IOException {
		Properties pr =PropertiesFile.LoadProperties("../SepAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		http.DeleteMethod("real4_URI",TC8_CreateEmployee.returnidValue);
		
	}
}