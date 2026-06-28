package com.framework.context;

import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;

public class TestContext {

	private LoginPage loginPage;

	private HomePage homePage;

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}
}