package com.api.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.pojo.LoginRequestPOJO;
import com.util.TestUtility;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class LoginAPIRequest {

	@Test
	public void loginAPITest() {
		
		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamfd","password");
		
		String jsonData = TestUtility.convertToJson(loginRequestPOJO);
		
		baseURI = "http://139.59.91.96:9000";
		
		Header myHeader = new Header("Content-Type","application/json");
		
		String data = given().header(myHeader).and().body(jsonData).log().all().when().post("/v1/login").then().log().all().assertThat().statusCode(200)
				      .and().assertThat().body("message",equalTo("Success")).and().time(lessThan(900L)).extract().path("data.token");
		
		System.out.println(data);
							   
							   
		
		
		
		
		
		
		
		
		

	}

}
