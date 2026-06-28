package com.framework.api;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.framework.api.endpoints.LoginAPI;
import com.framework.api.endpoints.ProductAPI;
import com.framework.api.endpoints.UserAPI;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

public class BaseAPITest {

	protected UserAPI userAPI;
	protected ProductAPI productAPI;
	protected LoginAPI loginAPI;

	@BeforeSuite(alwaysRun = true)
	public void suiteSetup() {

		RestAssured.baseURI = "https://automationexercise.com";

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
	}

	@BeforeMethod(alwaysRun = true)
	public void testSetup() {

		userAPI = new UserAPI();

		productAPI = new ProductAPI();

		loginAPI = new LoginAPI();

	}
}
