package com.framework.utilities;

import org.openqa.selenium.WebElement;

public class ElementUtil {

	public static void click(WebElement element) {

		WaitUtil.waitForElementClickable(element);

		element.click();
	}

	public static void type(WebElement element, String value) {

		WaitUtil.waitForElementVisible(element);

		element.clear();

		element.sendKeys(value);
	}
}
