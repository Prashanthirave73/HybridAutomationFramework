package com.framework.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "src/test/resources/features",

		glue = {

				"com.framework.stepdefinitions", "com.framework.hooks" }, tags = "not @ignore",

		plugin = {

				"pretty",

				"html:target/cucumber-report.html"

		// "html:reports/cucumber.html",

		// "json:reports/cucumber.json"
		}

// monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();
	}
}