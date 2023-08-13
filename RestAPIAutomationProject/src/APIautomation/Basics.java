package APIautomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import Files.Payloadstore;

public class Basics {

	public static void main(String[] args) {

		// Validate if add place api is working as expected
		// Given > all the input detail required to submit api
		// When > Submit api detail (Resource and http method)
		// and Then > Validate the responce

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String AddplaceResponce = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payloadstore.AddPlacebody()).when().post("maps/api/place/add/json").then().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract()
				.response().asString();

		// Add place --> Update place with neww address -> Get place to validate if new
		// address is present in responce

		JsonPath js = new JsonPath(AddplaceResponce); // Class to parse string into actual json and parsed value can be
														// fetch from the js.

		String Place_id = js.getString("place_id");
		System.out.println(Place_id);

		String actualaddress = "Falguni building";
		System.out.println("Actual address assress " + actualaddress);
		// Update place

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").when()
				.body("{\r\n" + "\"place_id\":\"" + Place_id + "\",\r\n" + "\"address\":\"" + actualaddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")

				.put("/maps/api/place/update/json").then().log().all().assertThat()
				.body("msg", equalTo("Address successfully updated"));

		// Get
		System.out.println("*************************************");

		String ReplacedAddress = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", Place_id)
				.when().get("/maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		System.out.println( "aaaaaaaaaaaaaaaaa"+Place_id);
		System.out.println(ReplacedAddress);

		
		  JsonPath js1 = new JsonPath(ReplacedAddress); String expectedaddress =
		  js1.getString("address"); System.out.println("Updated address " +
		  expectedaddress);
		 
		 assertEquals(actualaddress,expectedaddress,"assertion");
		 
	}

}
