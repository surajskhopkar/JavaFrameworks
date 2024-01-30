package com.api.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.util.Role;
import com.util.TestUtility;
import io.restassured.http.Header;

public class CreateJobAPITest {
	
	private String payload;
	private Header myHeader, myHeader2;
	
	@BeforeMethod(description = "Setup for creating new job", groups = {"api", "sanity", "e2e"})
	public void setup() {
		
		payload = TestUtility.convertToJson(TestUtility.createJobRequestJSON());
		baseURI = "http://139.59.91.96:9000";
		myHeader = new Header("Content-Type","application/json");
		myHeader2 = new Header("Authorization", TestUtility.generateTokenFor(Role.FD));
		
	}

	@Test(description = "Verify if the Supervisor is able to create job", groups = {"api", "sanity", "e2e"})
	public void createJobAPITest() {
		TestUtility.jobId = given().header(myHeader).and().header(myHeader2).and().body(payload).log().all().when().post("/v1/job/create").then().log().all().assertThat().statusCode(200)
				      .and().assertThat().body("message",equalTo("Job created successfully. ")).and().time(lessThan(1500L)).extract().path("data.id");
	}

}
