package com.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.pojo.CreateJobRequestPOJO;
import com.pojo.Customer;
import com.pojo.CustomerAddress;
import com.pojo.CustomerProduct;
import com.pojo.LoginRequestPOJO;
import com.pojo.Problem;

import io.restassured.http.Header;

public class TestUtility {
	
	public static int jobId;
	
	public static String convertToJson(Object refVariable) {
		
		Gson gson = new Gson();
		return gson.toJson(refVariable);
		
	}
	
	public static String generateTokenFor(Role role) {
		
		LoginRequestPOJO loginRequestPOJO = null;
		
		if(role == Role.FD) {
			loginRequestPOJO = new LoginRequestPOJO("iamfd","password");
		}
		
		else if(role == Role.SUP) {
			loginRequestPOJO = new LoginRequestPOJO("iamsup","password");
		}
		
		else if(role == Role.ENG) {
			loginRequestPOJO = new LoginRequestPOJO("iameng","password");
		}
		
		else if(role == Role.QC) {
			loginRequestPOJO = new LoginRequestPOJO("iamqc","password");
		}
		
		else if(role == Role.FST) {
			loginRequestPOJO = new LoginRequestPOJO("iamfst","password");
		}
		else if(role == Role.CC) {
			loginRequestPOJO = new LoginRequestPOJO("iamcc","password");
		}
		
		Header myHeader = new Header("Content-Type","application/json");
		String jsonData = TestUtility.convertToJson(loginRequestPOJO);
		return given().header(myHeader).and().body(jsonData).log().all().when().post("/v1/login").then().log().all().extract().path("data.token");
		
	}
	
	public static CreateJobRequestPOJO createJobRequestJSON() {
		Faker faker = new Faker();
		String fName = faker.name().firstName();
		String lName = faker.name().lastName();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String emailAddress = faker.internet().emailAddress();
		String aptNumber = faker.address().buildingNumber();
		String aptName = faker.address().streetName();
		String streetName = faker.address().streetName();
		String IMEINUMBER = faker.numerify("8##############");
		
		
		
        Customer customer = new Customer(fName, lName, phoneNumber, null, emailAddress, null);
		
		CustomerAddress address  = new CustomerAddress(aptNumber, aptName, streetName, "landmark1", "area1", "421306", "India", "Maharashtra");
		
		CustomerProduct product = new CustomerProduct("2023-12-02T18:30:00.000Z", IMEINUMBER, IMEINUMBER, IMEINUMBER, "2023-12-02T18:30:00.000Z", 1, 1);
		
		Problem[] deviceproblems = new Problem[1];
		
		deviceproblems[0] = new Problem(1, "Phone not working");
		
		
		CreateJobRequestPOJO createJobRequestPOJO = new CreateJobRequestPOJO(0,2,1,1,customer,address, product, deviceproblems);
		
		return createJobRequestPOJO;
	}

}
