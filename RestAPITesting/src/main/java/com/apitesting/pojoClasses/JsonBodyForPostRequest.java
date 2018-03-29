	package com.apitesting.pojoClasses;
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"FirstName",
	"LastName",
	"UserName",
	"Password",
	"Email"
	})
	public class JsonBodyForPostRequest {
	
	@JsonProperty("FirstName")
	public String firstName;
	@JsonProperty("LastName")
	public String lastName;
	@JsonProperty("UserName")
	public String userName;
	@JsonProperty("Password")
	public String password;
	@JsonProperty("Email")
	public String email;
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public JsonBodyForPostRequest() {
	}
	
	/**
	* 
	* @param lastName
	* @param email
	* @param userName
	* @param firstName
	* @param password
	*/
	public JsonBodyForPostRequest(String firstName, String lastName, String userName, String password, String email) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
	this.email = email;
	}
	}
	
