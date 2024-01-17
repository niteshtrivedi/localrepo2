package org.testing.utilities;

import io.restassured.response.Response;

public class JsonParsingUsingJsonPath {
	
	public static String jsonParsing(Response res,String jsonPathValue ) {
		
		String responseExtractedValue=res.jsonPath().get(jsonPathValue);
		return responseExtractedValue;
		
	}

}
