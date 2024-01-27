package com.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import com.google.gson.Gson;
import com.pojo.LoginRequestPOJO;

import io.restassured.http.Header;

public class TestUtility {
	
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

}
