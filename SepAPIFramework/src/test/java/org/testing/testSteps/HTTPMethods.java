package org.testing.testSteps;

import static io.restassured.RestAssured.given;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPMethods {
	Properties pr;
	public HTTPMethods(Properties pr) {
		this.pr=pr;
	}

	public Response PostMethod(String jsonRequestBody,String uriKeyName) {
		
		String uriValue=pr.getProperty(uriKeyName);
		Response resObj=
		given()
	    .contentType(ContentType.JSON)
	    .body(jsonRequestBody)
		.when()
		.post(uriValue);
		System.out.println("Status code is ");
		System.out.println(resObj . statusCode());
		System.out.println("Reponse data is ");
		System.out.println(resObj.asString());
		return resObj;
	}
	
public Response GETALLMETHOD(String uriKeyName) {
		
		String uriValue=pr.getProperty(uriKeyName);
		Response resObj=
		given()
	    .contentType(ContentType.JSON)
		.when()
		.get(uriValue);
		System.out.println("Status code is ");
		System.out.println(resObj . statusCode());
		System.out.println("Reponse data is ");
		System.out.println(resObj.asString());
		return resObj;
	}
public void GetParticular(String uriKeyName, String endPointValue) {
	
	String uriValue=pr.getProperty(uriKeyName)+"/"+endPointValue;
	Response resObj=
	given()
    .contentType(ContentType.JSON)
	.when()
	.get(uriValue);
	System.out.println("Status code is ");
	System.out.println(resObj . statusCode());
	System.out.println("Reponse data is ");
	System.out.println(resObj.asString());

}

public Response PutMethod(String jsonRequestBody,String uriKeyName,String endPointValue) {
	
	String uriValue=pr.getProperty(uriKeyName)+"/"+endPointValue;
	Response resObj=
	given()
    .contentType(ContentType.JSON)
    .body(jsonRequestBody)
	.when()
	.put(uriValue);
	System.out.println("Status code is ");
	System.out.println(resObj . statusCode());
	System.out.println("Reponse data is ");
	System.out.println(resObj.asString());
	return resObj;
}

public void DeleteMethod(String uriKeyName, String endPointValue) {
	
	String uriValue=pr.getProperty(uriKeyName)+"/"+endPointValue;
	Response resObj=
	given()
    .contentType(ContentType.JSON)
	.when()
	.delete(uriValue);
	System.out.println("Status code is ");
	System.out.println(resObj . statusCode());
	System.out.println("Reponse data is ");
	System.out.println(resObj.asString());
    
}


}
