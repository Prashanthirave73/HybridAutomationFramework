package com.framework.utilities;

import org.testng.Assert;

import io.restassured.response.Response;

public class APIUtil {

	public static void verifyStatusCode(Response response, int expectedStatusCode) {

		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
	}

	public static void verifyResponseTime(Response response, long maxTime) {

		Assert.assertTrue(response.getTime() < maxTime, "Response Time Exceeded");
	}

	public static void verifyHeader(Response response, String headerName, String expectedValue) {

		Assert.assertEquals(response.getHeader(headerName), expectedValue);
	}

	public static void verifyResponseCode(Response response, int expectedCode) {

		Assert.assertEquals(response.jsonPath().getInt("responseCode"), expectedCode);
	}

}
