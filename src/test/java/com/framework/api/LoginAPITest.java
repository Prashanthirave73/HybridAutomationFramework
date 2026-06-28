package com.framework.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.utilities.APIUtil;
import com.framework.utilities.JsonUtil;
import com.framework.utilities.LoginDataProvider;
import com.framework.utilities.ResponseUtil;

import io.restassured.response.Response;

public class LoginAPITest extends BaseAPITest {

	// Verify Login Details using Valid email and Password

	@Test()
	public void verifySimpleValidLogin() {

		Response response = loginAPI.login("prashanthirave12@gmail.com", "Test@234");

		response.then().statusCode(200);

		// APIUtil.verifyStatusCode(response, 200);

		APIUtil.verifyResponseCode(response, 200);
	}

	// Verify Login Details using Invalid email

	@Test()
	public void verifySimpleInvalidLogin() {

		Response response = loginAPI.login("prashanthirave112@gmail.com", "Test@234");
		ResponseUtil.extractJsonFromHtml(response.asString());
		response.then().statusCode(200);

		String json = ResponseUtil.extractJsonFromHtml(response.asString());
		System.out.println(json);

		APIUtil.verifyResponseCode(response, 404);

		// response.prettyPrint();

		JsonUtil.printPrettyJson(ResponseUtil.extractJsonFromHtml(response.asString()));
	}

	// Verify Login Details Positive With DataProvider

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void verifyLogin(String email, String password) {

		Response response = loginAPI.login(email, password);

		response.then().statusCode(200);

		System.out.println("Email : " + email);

		response.prettyPrint();
	}

	// Verify Login Details Positive or Negative With DataProvider

	@Test(dataProvider = "verifyLoginData", dataProviderClass = LoginDataProvider.class)
	public void verifyLoginPositiveandNagativeData(String email, String password, boolean expectedResult) {

		Response response = loginAPI.login(email, password);

		APIUtil.verifyStatusCode(response, 200);

		int responseCode = response.jsonPath().getInt("responseCode");

		if (expectedResult) {

			Assert.assertEquals(responseCode, 200, "Login should be successful");

		} else {

			Assert.assertNotEquals(responseCode, 200, "Login should fail");
		}
	}
}
