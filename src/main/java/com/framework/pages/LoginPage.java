package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.utilities.WaitUtil;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement loginHeader;

	@FindBy(xpath = "//*[contains(text(),'incorrect')]")
	private WebElement errorMessage;

	public HomePage login(String user, String pass) {

		WaitUtil.waitForElementVisible(email);

		email.clear();
		email.sendKeys(user);

		password.clear();
		password.sendKeys(pass);

		loginBtn.click();

		return new HomePage(driver);
	}

	public boolean isAtLoginPage() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl().contains("/login");
	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public boolean isLoginPageDisplayed() {
		// TODO Auto-generated method stub
		return loginHeader.isDisplayed();
	}

	public boolean isLoginErrorDisplayed() {

		return errorMessage.isDisplayed();
	}

	/*
	 * //for Phase 1 without extends private WebDriver driver;
	 * 
	 * public LoginPage(WebDriver driver) {
	 * 
	 * this.driver = driver; }
	 * 
	 * By signupLogin = By.xpath("//a[contains(text(),'Signup')]");
	 * 
	 * public void clickSignupLogin() {
	 * 
	 * driver.findElement(signupLogin).click(); }
	 */
}
