package com.api.tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pojo.AssignEngineerRequestPOJO;
import com.util.Role;
import com.util.TestUtility;
import io.restassured.http.Header;

public class AssignJobAPITest {
	
	private String payload;
	private Header myHeader, myHeader2;
	
	@BeforeMethod(description = "Setting up Base URI, payload and Header")
	public void setup() {
		
		AssignEngineerRequestPOJO assignEngineerRequestPOJO = new AssignEngineerRequestPOJO(TestUtility.jobId, 2);;
		payload = TestUtility.convertToJson(assignEngineerRequestPOJO);
		baseURI = "http://139.59.91.96:9000";
		myHeader = new Header("Content-Type","application/json");
		myHeader2 = new Header("Authorization", TestUtility.generateTokenFor(Role.SUP));
	}
	
	
	@Test(description = "Verify if the Supervisor is able to assign the job to the engineer", groups = {"api", "sanity", "e2e"})
	public void assignJobAPITest() {
	given().header(myHeader).and().header(myHeader2).and().body(payload).log().all().when().post("/v1/engineer/assign").then().log().all().assertThat().statusCode(200)
				      .and().assertThat().body("message",equalTo("Engineer assigned successfully")).and().time(lessThan(2500L)).extract().path("data.id");
		
		
							   
							   
		
		
		
		
		
		
		
		
		

	}

}
