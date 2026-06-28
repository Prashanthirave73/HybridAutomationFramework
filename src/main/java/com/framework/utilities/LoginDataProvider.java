package com.framework.utilities;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {

		return new Object[][] {

				{ "prashanthirave11@gmail.com", "Test@1234" },

				{ "prashanthirave12@gmail.com", "Test@234" },

				{ "dada11781427847409@test.com", "Test@231" } };
	}

	// Positive and Negative Login Test
	@DataProvider(name = "verifyLoginData")
	public Object[][] verifyLoginData() {

		return new Object[][] {

				{ "prashanthirave11@gmail.com", "Test@1234", true },

				{ "prashanthirave12@gmail.com", "Test@234", true },

				{ "dada1178142784740@test.com", "Test@231", true } };
	}
}
