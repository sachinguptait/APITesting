package com.apitesting.TestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.apitesting.listners.BaseClass;
import com.apitesting.listners.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class PostRequest1 extends BaseClass{
	
	static String currentDir=System.getProperty("user.dir")+File.separator+"Library\\JsonBody.txt";
	@Test
	public static void postRequestType1() throws IOException {
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(currentDir));
		String json = "";
		try {
		    StringBuilder sb = new StringBuilder();
		    line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    json = sb.toString();
		} finally {
		    reader.close();
		}
	
	
	String url="http://restapi.demoqa.com/customer/register";
	RestAssured.baseURI=url;
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " +json);
	
	ValidatableResponse response = RestAssured.given().when().
			header("Content-Type", "application/json").
			body(json).post().then();

	ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
	response.statusCode(200);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
	response.contentType(ContentType.JSON);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
	response.body("FaultId", Matchers.containsString("User already exists"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the already exist user message");
	}
}
