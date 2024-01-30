package com.api.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.pojo.CreateJobRequestPOJO;
import com.pojo.Customer;
import com.pojo.CustomerAddress;
import com.pojo.CustomerProduct;
import com.pojo.LoginRequestPOJO;
import com.pojo.Problem;
import com.util.Role;
import com.util.TestUtility;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateJobAPITest {

	@Test
	public void createJobAPITest() {
		
		
		String payload = TestUtility.convertToJson(TestUtility.createJobRequestJSON());
		
		baseURI = "http://139.59.91.96:9000";
		
		Header myHeader = new Header("Content-Type","application/json");
		
		Header myHeader2 = new Header("Authorization", TestUtility.generateTokenFor(Role.FD));
		
		TestUtility.jobId = given().header(myHeader).and().header(myHeader2).and().body(payload).log().all().when().post("/v1/job/create").then().log().all().assertThat().statusCode(200)
				      .and().assertThat().body("message",equalTo("Job created successfully. ")).and().time(lessThan(1500L)).extract().path("data.id");
		
		System.out.println(TestUtility.jobId);
							   
							   
		
		
		
		
		
		
		
		
		

	}

}
