package com.api.tests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.util.*;
import com.util.TestUtility;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserDetailsAPITest {
	
	Header myAuthorizationHeader;
	
	@BeforeMethod(description = "Setup for User Details")
	public void setup() {
		baseURI = "http://139.59.91.96:9000";
		myAuthorizationHeader = new Header("Authorization", TestUtility.generateTokenFor(Role.SUP));
	}

	@Test
	public void userDetailsAPITest()  {
		Response myResponse = given().header(myAuthorizationHeader).when().get("/v1/userdetails");
		}

}
