	package com.apitesting.pojoClasses;
	
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"FirstName",
	"LastName",
	"City"
	})
	public class UserDetail {

	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("City")
	private String city;

	/**
	* No args constructor for use in serialization
	* 
	*/
	public UserDetail() {
	}

	/**
	* 
	* @param lastName
	* @param firstName
	* @param city
	*/
	public UserDetail(String firstName, String lastName, String city) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.city = city;
	}

	@JsonProperty("FirstName")
	public String getFirstName() {
	return firstName;
	}

	@JsonProperty("FirstName")
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}

	@JsonProperty("LastName")
	public String getLastName() {
	return lastName;
	}

	@JsonProperty("LastName")
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}

	@JsonProperty("City")
	public String getCity() {
	return city;
	}

	@JsonProperty("City")
	public void setCity(String city) {
	this.city = city;
	}

	}