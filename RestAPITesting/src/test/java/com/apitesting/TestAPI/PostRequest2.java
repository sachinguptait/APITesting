package com.apitesting.TestAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.apitesting.listners.BaseClass;
import com.apitesting.listners.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class PostRequest2 extends BaseClass{
	
	@Test
	public static void postRequestType2() throws IOException {
			
	
	String url="http://restapi.demoqa.com/customer/register";
	RestAssured.baseURI=url;
	
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmmss");
	Date date = new Date();
	String currentDate = formatter.format(date);
		
	String jsonbody="{\"FirstName\":\"Sachin\",\"LastName\":\"Gupta\","
			+ "\"UserName\":\"sachinGupta"+currentDate+"\",\"Password\":\"password112\","
			+ "\"Email\":\"sachingupta"+currentDate+"@gmail.com\"}";
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " +jsonbody);	
	
	ValidatableResponse response = RestAssured.given().when().
			header("Content-Type", "application/json").body(jsonbody).post().then();

	ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
	response.statusCode(201);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
	response.contentType(ContentType.JSON);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
	response.body("SuccessCode", Matchers.containsString("OPERATION_SUCCESS"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the SuccessCode message !!");
	
	response.body("Message", Matchers.containsString("Operation completed successfully"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the request success message !!");
	}
}
