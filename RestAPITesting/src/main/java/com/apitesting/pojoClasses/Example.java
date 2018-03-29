	package com.apitesting.pojoClasses;
	
	import java.util.List;
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"State",
	"UserID",
	"UserDetails"
	})
	public class Example {

	@JsonProperty("State")
	private String state;
	@JsonProperty("UserID")
	private UserID userID;
	@JsonProperty("UserDetails")
	private List<UserDetail> userDetails = null;

	/**
	* No args constructor for use in serialization
	* 
	*/
	public Example() {
	}

	/**
	* 
	* @param userID
	* @param state
	* @param userDetails
	*/
	public Example(String state, UserID userID, List<UserDetail> userDetails) {
	super();
	this.state = state;
	this.userID = userID;
	this.userDetails = userDetails;
	}

	@JsonProperty("State")
	public String getState() {
	return state;
	}

	@JsonProperty("State")
	public void setState(String state) {
	this.state = state;
	}

	@JsonProperty("UserID")
	public UserID getUserID() {
	return userID;
	}

	@JsonProperty("UserID")
	public void setUserID(UserID userID) {
	this.userID = userID;
	}

	@JsonProperty("UserDetails")
	public List<UserDetail> getUserDetails() {
	return userDetails;
	}

	@JsonProperty("UserDetails")
	public void setUserDetails(List<UserDetail> userDetails) {
	this.userDetails = userDetails;
	}

	}