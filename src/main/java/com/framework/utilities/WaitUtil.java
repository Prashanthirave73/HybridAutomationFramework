package com.framework.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.factory.DriverFactory;

public class WaitUtil {

	private static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));

	public static void waitForElementVisible(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
