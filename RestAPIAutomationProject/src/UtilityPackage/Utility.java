package UtilityPackage;

import io.restassured.path.json.JsonPath;

public class Utility {

	
	public static JsonPath StringToJson(String Value) {
		
		JsonPath json = new JsonPath(Value); 
		return json;
		
	}

	
	
}
