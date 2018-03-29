package com.apitesting.TestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;

import com.apitesting.listners.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteRequest {

	
	@Test
	public static void putRequest()
	{
		
		String url="http://Url for the Delete Request";
		RestAssured.baseURI=url;
		
		ValidatableResponse response = RestAssured.given().when().
				header("Content-Type", "application/json").delete().then();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
		response.statusCode(201);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
		response.contentType(ContentType.JSON);
		
		//Implement verification logic as per previous example
	}
}
