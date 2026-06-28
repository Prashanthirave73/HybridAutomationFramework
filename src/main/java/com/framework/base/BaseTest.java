package com.framework.base;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framework.factory.DriverFactory;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.EnvironmentReader;

public class BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("===== SETUP STARTED =====");

		System.out.println("Environment : " + EnvironmentReader.getEnvironment());

		System.out.println("Browser : " + ConfigReader.getProperty("browser"));

		System.out.println("URL : " + ConfigReader.getProperty("url"));

		DriverFactory.initDriver(ConfigReader.getProperty("browser"));

		DriverFactory.getDriver().manage().window().maximize();

		DriverFactory.getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));

		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"env"})   //Set environment by testng.xml file
	public void setup(@Optional("qa") String env) {

		System.out.println("Environment = " + env);
		System.out.println("Browser : " + ConfigReader.getProperty("browser"));

		System.out.println("URL : " + ConfigReader.getProperty("url"));

		DriverFactory.initDriver(ConfigReader.getProperty("browser"));

		DriverFactory.getDriver().manage().window().maximize();

		DriverFactory.getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));

		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));

	}

	// cross browser testing...//parallel Execution

	/*
	 * @BeforeMethod
	 * 
	 * @Parameters({ "browser" }) public void setup(String browser) {
	 * 
	 * DriverFactory.initDriver(browser);
	 * 
	 * DriverFactory.getDriver().manage().window().maximize();
	 * 
	 * DriverFactory.getDriver().manage().timeouts()
	 * .implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty(
	 * "implicitWait"))));
	 * 
	 * DriverFactory.getDriver().get(ConfigReader.getProperty("url")); }
	 */

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		DriverFactory.quitDriver();
	}
}
