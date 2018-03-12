package com.apitesting.TestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestWeatherAPI {

	@Test(priority = -1, enabled = false)
	public void getWeatherInfoOfBangaloreWithValidData() {
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		String response = RestAssured.given().param("q", "Bangalore")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then().extract().asString();
		System.out.println("Response is :- " + response);

		Reporter.log("Response is: " + response, true);

		ValidatableResponse res = RestAssured.given().param("q", "Bangalore")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then();

		res.statusCode(200);
		Reporter.log("Verified the Status code successfully", true);

		res.contentType(ContentType.JSON);

		Object countryName = res.extract().response().path("sys.country");
		System.out.println("Country Name is " + countryName);

		JsonPath path = new JsonPath(response);
		Object countryNm = path.get("sys.country");
		System.out.println("Country Name: " + countryNm);

		res.body("sys.country", Matchers.notNullValue());
		res.body("sys.country", Matchers.equalToIgnoringCase("IN"));
		Reporter.log("Country code has verified successfully", true);

		res.body("name", Matchers.notNullValue());
		res.body("name", Matchers.equalToIgnoringCase("Bangalore"));
		Reporter.log("City name has verified successfully", true);

	}

	@Test(enabled = false)
	public void getWeatherInfoOfBangaloreWithInValidData1() {
		ValidatableResponse res = RestAssured.given().param("q", "Bangaloree")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then();

		Reporter.log("Response is: " + res.extract().asString(), true);

		res.statusCode(404);
		res.body("message", Matchers.notNullValue());
		res.body("message", Matchers.equalToIgnoringCase("city not found"));
		Reporter.log("Verified the error message successfully", true);
	}

	@Test(enabled = false)
	public void getWeatherInfoOfBangaloreWithInValidData2() {
		ValidatableResponse res = RestAssured.given().param("q", "Bangalore")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400A").when()
				.get().then();

		Reporter.log("Response is: " + res.extract().asString(), true);

		res.statusCode(401);
		res.body("message", Matchers.notNullValue());
		res.body("message", Matchers.containsString("Invalid API key"));
		Reporter.log("Verified the error message successfully", true);
	}

	@Test(enabled = false)
	public void getWeatherInfoOfDelhiWithValidData() {

		ValidatableResponse response = RestAssured.given().param("q", "Delhi")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then();

		Reporter.log("Response is: " + response.extract().asString(), true);

		response.statusCode(200);
		Reporter.log("Verified the Status code successfully", true);

		response.contentType(ContentType.JSON);

		response.body("sys.country", Matchers.notNullValue());
		response.body("sys.country", Matchers.equalToIgnoringCase("IN"));
		Reporter.log("Country code has verified successfully", true);

		response.body("name", Matchers.notNullValue());
		response.body("name", Matchers.equalToIgnoringCase("Delhi"));
		Reporter.log("City name has verified successfully", true);

	}

	// Execute all the steps despite of the failure of the test steps

	@Test()
	public void getWeatherInfo() {
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";

		ValidatableResponse res = RestAssured.given().param("q", "Delhi")
				.param("appid", "17e5c69afcef0f16365a6c3b0cba4400").when()
				.get().then();

		Reporter.log("Response is: " + res.extract().asString(), true);
		int stsCode = res.extract().statusCode();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(stsCode, 300); // Intentionally Fail at this
													// step
		Reporter.log("Verified the Status code successfully", true);
		String contentType = res.extract().contentType();
		softAssertion.assertEquals(contentType, "JSON");
		String countryCode = (String) res.extract().response()
				.path("sys.country");
		softAssertion.assertEquals(countryCode, "IN");
		Reporter.log("Country code has verified successfully", true);
		String cityName = (String) res.extract().response().path("name");
		softAssertion.assertEquals(cityName, "Delhi");
		Reporter.log("City name has verified successfully", true);
		softAssertion.assertAll();

	}

}
