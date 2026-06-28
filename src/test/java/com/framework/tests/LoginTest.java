package com.framework.tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.framework.base.BaseTest;
import com.framework.factory.DriverFactory;
import com.framework.listeners.RetryAnalyzer;
import com.framework.listeners.TestListener;
import com.framework.models.User;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.reports.ExtentTestManager;
import com.framework.utilities.CSVDataProvider;
import com.framework.utilities.CSVUtil;
import com.framework.utilities.ExcelDataProvider;
import com.framework.utilities.FakerUtil;
import com.framework.utilities.JsonDataProvider;
import com.framework.utilities.JsonUtil;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest implements IRetryAnalyzer {

	private static final Logger log = LogManager.getLogger(LoginTest.class);

	@Test()
	public void verifyValidLogin11() {

		ExtentTestManager.getTest().info("Login Started");

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	@Test(groups = { "smoke" })
	public void verifyValidLogin() {

		ExtentTestManager.getTest().info("Login Started");

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyValidLogin1() {

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	@Test(groups = { "regression" })
	public void verifyInvalidLogin() {

		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave90@gmail.com", "Test@123");

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	// Soft Assert
	@Test
	public void verifyHomePage() {
		DriverFactory.getDriver().get("https://automationexercise.com/login");

		// Fluent Design Pattern
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		LoginPage loginPageAfterLogout = homePage.logout();

		SoftAssert softAssert = new SoftAssert();

		// softAssert.assertTrue(homePage.verifyLogo());
		softAssert.assertTrue(homePage.verifyUserLoggedIn());
		softAssert.assertTrue(loginPageAfterLogout.isAtLoginPage());
		softAssert.assertAll(); // Must be last statement
		System.out.println("completed");
	}

	// Data Driven Login Test
	/*
	 * @Test(dataProvider = "loginData", dataProviderClass =
	 * LoginDataProvider.class)
	 * 
	 * public void verifyLogin(String username, String password) {
	 * 
	 * System.out.println(username);
	 * 
	 * System.out.println(password); }
	 */

	// dependsOnMethods on Scenario
	// 1. verifyValidLoginforDepend
	// 2. verifyValidLoginforDependOnMethods
	// Note:If you're using dependsOnMethods, use: @BeforeClass public void setup()
	// and
	// @AfterClass public void tearDown() so both dependent tests share the same
	// browser instance and homePage remains valid.

	/*
	 * @Test() public void verifyValidLoginforDepend() {
	 * 
	 * DriverFactory.getDriver().get("https://automationexercise.com/login");
	 * 
	 * // Fluent Design Pattern LoginPage loginPage = new
	 * LoginPage(DriverFactory.getDriver());
	 * 
	 * HomePage homePage = loginPage.login("prashanthirave96@gmail.com",
	 * "Test@123"); System.out.println("Home Page opened");
	 * 
	 * }
	 * 
	 * @Test(dependsOnMethods = "verifyValidLoginforDepend") public void
	 * verifyValidLoginforDependOnMethods() {
	 * Assert.assertTrue(homePage.verifyUserLoggedIn()); }
	 */

	@Test
	public void verifyLogout() {

		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		LoginPage loginPageAfterLogout = homePage.logout();

		Assert.assertTrue(loginPageAfterLogout.isLoginPageDisplayed(), "Login page is not displayed after logout");
	}

	// @Test(groups = { "smoke" }, retryAnalyzer = RetryAnalyzer.class)
	@Test(groups = { "smoke" })

	public void verifyLoginTestProductionReady() {

		log.info("Starting Login Test");

		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("prashanthirave96@gmail.com", "Test@123");

		Assert.assertTrue(homePage.verifyUserLoggedIn());

		log.info("Login Completed");
	}

	/*
	 * @Test(dataProvider = "loginExcelData", dataProviderClass =
	 * ExcelDataProvider.class)
	 * 
	 * public void verifyLogin(String username, String password) {
	 * 
	 * System.out.println(username);
	 * 
	 * System.out.println(password); }
	 */

	/*
	 * //If You Want to get all username and password in single test
	 * 
	 * @Test()
	 * 
	 * public void verifyLoginbyJson() {
	 * 
	 * User[] users = JsonUtil.getUsers();
	 * 
	 * for (User user : users) {
	 * 
	 * System.out.println(user.getUsername());
	 * System.out.println(user.getPassword());
	 * 
	 * } }
	 * 
	 * //If You Want to Execute Login for Each User
	 * 
	 * @Test(dataProvider = "jsonData", dataProviderClass = JsonDataProvider.class)
	 * public void verifyLoginbyJsonDataProvider(String username, String password) {
	 * 
	 * System.out.println(username); System.out.println(password); }
	 */

	// 1. Get All Products in a Single Test
	@Test()

	public void verifyAllProductsbyCsv() throws Exception {

		List<String[]> products = CSVUtil.getData("src/test/resources/testdata/products.csv");

		for (String[] row : products) {

			System.out.println("Product Name : " + row[0]);

			System.out.println("Price : " + row[1]);
		}
	}

	// 2. Execute Test for Each Product (DataProvider)

	@Test(dataProvider = "productData", dataProviderClass = CSVDataProvider.class)
	public void verifyProduct(String productName, String price) {

		System.out.println(productName);

		System.out.println(price);
	}

	// Faker Util use
	@Test
	public void verifyRandomUserData() {

		String email = FakerUtil.getEmail();

		String password = FakerUtil.getPassword();

		System.out.println("Email    : " + email);

		System.out.println("Password : " + password);
	}

	// Production Login Example
	@Test
	public void verifyLogin() {

		User[] users = JsonUtil.getUsers();

		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

		HomePage homePage = loginPage.login("users[0].getUsername()", "users[0].getPassword()");

		Assert.assertTrue(homePage.verifyUserLoggedIn());
	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}
}
