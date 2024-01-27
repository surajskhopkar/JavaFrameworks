package com.api.tests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.util.*;
import com.util.TestUtility;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserDetailsAPIRequest {

	@Test
	public void userDetailsAPITest()  {
		// TODO Auto-generated method stub
		
		baseURI = "http://139.59.91.96:9000";
		Header myAuthorizationHeader = new Header("Authorization", TestUtility.generateTokenFor(Role.SUP));
		Response myResponse = given().header(myAuthorizationHeader).when().get("/v1/userdetails");
		
		System.out.println(myResponse.asPrettyString());
			
	
			
		

	}

}
