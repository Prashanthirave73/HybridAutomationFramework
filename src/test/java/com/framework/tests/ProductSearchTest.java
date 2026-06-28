package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.factory.DriverFactory;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.pages.ProductsPage;

public class ProductSearchTest extends BaseTest {

	@Test(groups = { "smoke" })
	public void verifyValidLogin() {

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	@Test(groups = { "regression" }, dependsOnMethods = "verifyValidLogin")
	public void verifySearchProduct() {

		DriverFactory.getDriver().get("https://automationexercise.com/products");

		ProductsPage page = new ProductsPage(DriverFactory.getDriver());

		Assert.assertTrue(page.searchProduct("Blue Top"));
	}
}
