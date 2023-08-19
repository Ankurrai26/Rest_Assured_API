package APIautomation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import UtilityPackage.Utility;
import files.Payloadstore;
import io.restassured.path.json.JsonPath;

public class Sumvalidation {

	public static int Sumprice = 0;
	public static int purchaseamount;
	
	@Test
	
	public static void SumPrac() {
		
		JsonPath js= Utility.StringToJson(Payloadstore.DummyResponce());
		int count = js.getInt("courses.size()");
		purchaseamount = js.getInt("dashboard.purchaseAmount"); 
		System.out.println("PurchaseAmount: " + purchaseamount);
		
			for (int i=0;i<=js.getInt("courses.size()")-1;i++) {
					int Price = js.getInt("courses["+i+"].price");
					int copiesC = js.getInt("courses["+i+"].copies");
			
					int tempSumprice = Price*copiesC;
					Sumprice = Sumprice+tempSumprice;
					}
		System.out.println("Sum Price: " + Sumprice);	 
		assertEquals(Sumprice, purchaseamount, "Purchase and sum amount is not equal");
	}
	
}
