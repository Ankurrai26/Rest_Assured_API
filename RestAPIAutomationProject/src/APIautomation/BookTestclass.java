package APIautomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilityPackage.Utility;
import files.Payloadstore;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class BookTestclass {

	@Test(dataProvider = "addbookdata")
	public void addbookinto(String isbn,String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		
	String Responce = 	given().header("Content-Type", "application/json").body(Payloadstore.Addbook(isbn,aisle))
		.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Utility.StringToJson(Responce);
		String id = js.get("ID");
		System.out.println(id);
		
	}
	
	
	@DataProvider(name="addbookdata")
	public Object[][] getData() {
		//Array = collection of elements
		//new object[] {1,2,3,4,5,/....}
		// multidimentionalarrays = collection of arrays
		//new object[][] {array1,array2,....}
		
	return	new Object [][] {{"ankur","7861"},{"ankur","7862"},{"ankur","7863"}};
		
	}
	
	
}
