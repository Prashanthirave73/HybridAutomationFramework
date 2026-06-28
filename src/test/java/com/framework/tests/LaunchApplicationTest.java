package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.factory.DriverFactory;

public class LaunchApplicationTest extends BaseTest {

	@Test(groups = { "smoke" })
	public void verifyHomePageTitle() {

		String actualTitle = DriverFactory.getDriver().getTitle();

		Assert.assertTrue(actualTitle.contains("Automation"));
	}
}
