package com.framework.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.factory.DriverFactory;

public class ScreenshotUtil {

	public static String captureScreenshot(String testName) {

		try {

			File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

			String destination = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

			FileUtils.copyFile(src, new File(destination));

			return destination;

		} catch (Exception e) {

			e.printStackTrace();

			return "";
		}
	}
}
