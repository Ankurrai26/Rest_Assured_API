package APIautomation;

import static org.testng.Assert.assertEquals;

import UtilityPackage.Utility;
import files.Payloadstore;
import io.restassured.path.json.JsonPath;

public class Complexfile {

	
	
	public static void main(String[] args) {
		
		
		
		JsonPath js= Utility.StringToJson(Payloadstore.DummyResponce());
		
		//Print No of courses returned by API
		
		int count = js.getInt("courses.size()");  // Size method only applies on array "[]" indicates that its an array
		System.out.println(count);
		
		//	2.Print Purchase Amount
		
		int purchaseamount = js.getInt("dashboard.purchaseAmount");  // Based on type of varialbe accordingly method should be called 
		System.out.println(purchaseamount);
		
		//3. Print Title of the first course

		String Title1 = js.getString("courses[0].title");
		System.out.println(Title1);
		
		
		//4. Print All course titles and their respective Prices
		
		for (int i=0;i<=js.getInt("courses.size()")-1;i++) {
			
		String titlee= js.getString("courses["+i+"].title");
		int price = js.getInt("courses["+i+"].price");
			
			System.out.println("Title: " + titlee + "  Price: " + price );
			
			
		}

	//	5. Print no of copies sold by RPA Course

		for (int i=0;i<=js.getInt("courses.size()")-1;i++) {
			
			String titlee= js.getString("courses["+i+"].title");
			if (titlee.equalsIgnoreCase("RPA")) {
			
			int copiescount = js.getInt("courses["+i+"].copies");	
			System.out.println(copiescount);
			break;
			}
			
			
			
		}
	//	System.out.println("Cpoisecount: " + copiescount);
		
	//	6. Verify if Sum of all Course prices matches with Purchase Amount
		

		

			
			
		}
		
		
	}
	
	

