package org.testing.responseValidation;

import org.testing.assertion.Assertion1;
import org.testing.utilities.JsonParsingUsingJsonPath;

import io.restassured.response.Response;

public class validateResponse {
	
	public static Boolean statusCodeValidate(int expected, Response resObj )
	{
		int actual=resObj.getStatusCode();
		Boolean result=Assertion1.assertion(actual, expected);
		return result;
	}
	public static Boolean responseDataValidate(String expected, Response resObj, String jsonPath)
	{
		String actual=JsonParsingUsingJsonPath.jsonParsing(resObj, jsonPath);
		Boolean result=Assertion1.assertion(actual, expected);
		return result;
	}

}
