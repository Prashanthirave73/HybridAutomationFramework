package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.database.UserRepository;
import com.framework.factory.DriverFactory;
import com.framework.models.UserDBModel;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;

public class LoginDBValidationTest extends BaseTest {

	@Test
	public void verifyLoginUserInDB() {

		String email = "prashanthirave96@gmail.com";

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login(email, "Test@123");

		UserRepository repo = new UserRepository();

		UserDBModel dbUser = repo.getUserByEmail(email);

		Assert.assertNotNull(dbUser.getEmail());

		Assert.assertEquals(dbUser.getEmail(), email);

		System.out.println("DB Email : " + dbUser.getEmail());

		System.out.println("DB Name : " + dbUser.getName());

	}
}