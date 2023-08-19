package APIautomation;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import UtilityPackage.Utility;

public class JiraTest {

	 public static void main(String[] args) {
		
		 RestAssured.baseURI = "http://localhost:8080";
		 SessionFilter session = new SessionFilter();
		 
		 
		String sessionCookie =  given().header("content-type","application/json").body("{ \"username\": \"ankur.b.rai\", \r\n"
		 		+ "\r\n"
		 		+ "\"password\": \"ankur786786\" }").filter(session).when().post("/rest/auth/1/session").then().extract().response().asString();
		 
		/*
		 * JsonPath js = Utility.StringToJson(sessionCookie); String name =
		 * js.get("session.name"); String Value = js.get("session.value"); String
		 * Actualcookie = name.concat(Value);
		 */
		  
		 given().log().all().pathParam("key","10003").header("content-type","application/json").body("{\r\n"
		 		+ "    \"body\": \"Hi I am adding comment beforeattachent\",\r\n"
		 		+ "    \"visibility\": {\r\n"
		 		+ "        \"type\": \"role\",\r\n"
		 		+ "        \"value\": \"Administrators\"\r\n"
		 		+ "    }\r\n"
		 		+ "}").filter(session).post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201);
		 
		 given().header("X-Atlassian-Token","no-check").header("content-type","multipart/form-data").pathParam("key","10003").multiPart("file",new File("Normal.txt")).filter(session)
		 .when().post("/rest/api/2/issue/{key}/attachments")
		 .then().log().all().assertThat().statusCode(200);
		 
		String responce =  given().filter(session).pathParam("key","10003").queryParam("fields","comment").when().get("/rest/api/2/issue/{key}").then().log().all().extract().response().asString();
		 System.out.println(responce);
		 
	}
	
	
}
