package org.testing.utilities;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

public class JsonParsingOrgJson {
	
	public static void doParsing(Response resObj,String keyName) {
		
		JSONObject js=new JSONObject(resObj.asString());
		JSONArray j=js.getJSONArray("data");
		int L=j.length();
		
		for(int i=0;i<L;i=i+1)
		{
		JSONObject jobj=j.getJSONObject(i);
		System.out.println(jobj.get(keyName));
		//}
		//Set<String>allkeys=jobj.keySet();
		//for(String s : allkeys)
		//{
			//System.out.println("key name is "+s);
			//System.out.println("Value is "+jobj.get(s));
			
		//}
	}
	}
}
