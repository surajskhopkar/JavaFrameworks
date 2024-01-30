package com.api.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pojo.LoginRequestPOJO;
import com.util.TestUtility;
import io.restassured.http.Header;

public class LoginAPITest {
	
	private Header myHeader;
	private String jsonData;
	
	@BeforeMethod(description = "Setup for login")
	public void setup() {
		
		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamfd","password");
		jsonData = TestUtility.convertToJson(loginRequestPOJO);
		baseURI = "http://139.59.91.96:9000";
		myHeader = new Header("Content-Type","application/json");
	}

	@Test(description = "Verify if login is successful")
	public void loginAPITest() {
		
		
		
		String data = given().header(myHeader).and().body(jsonData).log().all().when().post("/v1/login").then().log().all().assertThat().statusCode(200)
				      .and().assertThat().body("message",equalTo("Success")).and().time(lessThan(1500L)).extract().path("data.token");
		
		System.out.println(data);
							   
							   
		
		
		
		
		
		
		
		
		

	}

}
