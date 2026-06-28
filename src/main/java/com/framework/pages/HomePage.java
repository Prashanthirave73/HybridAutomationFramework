package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	private WebElement loggedInUser;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logoutLink;

	public boolean verifyUserLoggedIn() {

		return loggedInUser.isDisplayed();
	}

	public LoginPage logout() {

		logoutLink.click();

		return new LoginPage(driver);
	}

	public boolean verifyLogo() {
		// TODO Auto-generated method stub
		return false;
	}
}
