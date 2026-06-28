package com.framework.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.framework.factory.DriverFactory;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage;
	private HomePage homePage;

	@Given("User launches application")
	public void user_launches_application() {

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		loginPage = new LoginPage(DriverFactory.getDriver());
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {

		homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	@When("User logs in")
	public void user_logs_in() {

		homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");
	}

	@And("User clicks logout")
	public void user_clicks_logout() {

		loginPage = homePage.logout();
	}

	@Then("User should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {

		Assert.assertTrue(loginPage.isLoginPageDisplayed());
	}

	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {

		homePage = loginPage.login(username, password);
	}

	@Then("Login should be {string}")
	public void login_should_be(String result) {

		if (result.equalsIgnoreCase("success")) {

			Assert.assertTrue(homePage.verifyUserLoggedIn());

		} else {

			Assert.assertTrue(loginPage.isLoginErrorDisplayed());
		}
	}
	
	@When("User enters following credentials")
	public void user_enters_following_credentials(
	        DataTable dataTable) {

	    List<Map<String, String>> users =
	            dataTable.asMaps(
	                    String.class,
	                    String.class);

	    for (Map<String, String> user : users) {

	        HomePage homePage =
	                loginPage.login(
	                        user.get("username"),
	                        user.get("password"));

	        System.out.println(
	                "Login Attempted For: "
	                + user.get("username"));
	    }
	}
}