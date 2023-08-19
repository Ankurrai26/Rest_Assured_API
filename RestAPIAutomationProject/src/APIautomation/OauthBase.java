package APIautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCource;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import UtilityPackage.Utility;
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

public class OauthBase {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException{
	
//		
//		 WebDriverManager.chromedriver().setup();
//		 driver = new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.get("https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=https://rahulshettyacademy.com/getCourse.php&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&scope=https://www.googleapis.com/auth/userinfo.email&response_type=code&auth_url=https://accounts.google.com/o/oauth2/v2/auth");
//		 driver.findElement(By.xpath("//*[@type=\"email\"]")).sendKeys("ankur.rai@impactguru.com");
//		 driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
//		 Thread.sleep(3000);
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"Passwd\"]")));
//		 
//		 driver.findElement(By.xpath("//*[@name=\"Passwd\"]")).sendKeys("Divankur@143");
//		 Thread.sleep(10000);
//		 driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
//		 Thread.sleep(20000);
//		 
//		 String URL = driver.getCurrentUrl();
//		 String partial = URL.split("code=")[1];
//		 String Code = partial.split("&scope")[0];
//		 System.out.println(Code);
//				
//		
// String AccessTokenFromResponce = given().log().all().urlEncodingEnabled(false)
// .queryParams("code",Code)
// .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
// .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
// .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
// .queryParams("grant_type","authorization_code")
// .when().post("https://www.googleapis.com/oauth2/v4/token").then().log().all().extract().response().asString();
// 
//JsonPath js = Utility.StringToJson(AccessTokenFromResponce);
//String accessToken = js.get("access_token");	
//
//System.out.println("..........................................................................."+ accessToken);	
//		
//		
//Thread.sleep(5000);		
//		
GetCource gc = 	given().urlEncodingEnabled(false).queryParam("access_token","ya29.a0AfB_byCRjigD3JYqVKxBGC93W8Z9y8uFKB6cH4kjPRevIcpr4pY32Umy9c8Lllf0wtDN3vqS3PgcLiKPowrT0lATzcM4ncxbz-UNPI9P1BixZmzGzjvMCJ4PFvi5YkhxeQ6M71EmbBr3x-02kaiccGrPqBr02gc9vetbvM0aCgYKAXUSARISFQHsvYlsuMX3khG4emFqQezrYsEZbg0174").expect().defaultParser(Parser.JSON)
		.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCource.class);
	
System.out.println(gc.getLinkedIn());	
System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

List<pojo.api> GetAPIlist = gc.getCourses().getApi();
List<pojo.webAutomation> GetWebList = gc.getCourses().getWebAutomation();

String[] expectedString = {"Selenium Webdriver Java","Cypress","Protractor"};

for (int i=0;i<GetAPIlist.size();i++) {
	
	if (GetAPIlist.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
		
		System.out.println(GetAPIlist.get(i).getPrice());
	}
	
	
}

for (int i=0;i<GetWebList.size();i++) {
	
	//System.out.println(i + 1 + ":" + GetWebList.get(i).getCourseTitle());
	//System.out.println(expectedString[i]);
	
	assertEquals(GetWebList.get(i).getCourseTitle(),expectedString[i]);
	
} 






//System.out.println(responce);
	
	//JsonPath js = Utility.StringToJson(responce);
	//System.out.println(js);
		
	
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
