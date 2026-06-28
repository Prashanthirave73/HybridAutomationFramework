package com.framework.api.base;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class APIBase {

	protected RequestSpecification request;

	/*
	 * public APIBase() {
	 * 
	 * RestAssured.baseURI = "https://automationexercise.com"; request =
	 * RestAssured.given().log().all().header("Content-Type", "application/json"); }
	 */
	public APIBase() {

		// RestAssured.baseURI = "https://automationexercise.com";
		request = RestAssured.given().header("Content-Type", "application/x-www-form-urlencoded");
		//request = RestAssured.given().header("Content-Type", "application/json");
	}

}
