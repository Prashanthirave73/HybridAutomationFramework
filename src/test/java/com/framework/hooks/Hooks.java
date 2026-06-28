package com.framework.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.time.Duration;

import com.framework.factory.DriverFactory;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.EnvironmentReader;
import com.framework.utilities.ScreenshotUtil;

public class Hooks {

	@Before(order = 0)

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

	@After(order = 1)

	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {

			ScreenshotUtil.captureScreenshot(scenario.getName());
		}
	}

	@After(order = 0)

	public void tearDown() {

		DriverFactory.quitDriver();
	}
}