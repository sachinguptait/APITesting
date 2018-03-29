	package com.apitesting.pojoClasses;
	
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"Email"
	})
	public class UserID {

	@JsonProperty("Email")
	private String email;

	/**
	* No args constructor for use in serialization
	* 
	*/
	public UserID() {
	}

	/**
	* 
	* @param email
	*/
	public UserID(String email) {
	super();
	this.email = email;
	}

	@JsonProperty("Email")
	public String getEmail() {
	return email;
	}

	@JsonProperty("Email")
	public void setEmail(String email) {
	this.email = email;
	}

	}