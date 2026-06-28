package com.framework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private DriverFactory() {
	}

	public static void initDriver(String browser) {

		if (browser == null || browser.isBlank()) {
			throw new IllegalArgumentException("Browser cannot be null or empty");
		}

		System.out.println("Launching Browser: " + browser);

		switch (browser.trim().toLowerCase()) {

		case "chrome":
			driver.set(new ChromeDriver());
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\DELL\\Downloads\\edgedriver_win64\\msedgedriver.exe");

			driver.set(new EdgeDriver());
			break;

		case "firefox":
			driver.set(new FirefoxDriver());
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		System.out.println("Driver Created: " + driver.get());
	}

	public static WebDriver getDriver() {

		WebDriver webDriver = driver.get();

		if (webDriver == null) {
			throw new RuntimeException("Driver is not initialized. Call initDriver() first.");
		}

		return webDriver;
	}

	public static void quitDriver() {

		if (driver.get() != null) {

			driver.get().quit();

			driver.remove();
		}
	}
}

/*
 * Instead of hardcoding browser options:
 * 
 * ChromeOptions options = new ChromeOptions();
 * 
 * options.addArguments("--remote-allow-origins=*");
 * 
 * options.addArguments("--disable-notifications");
 * 
 * driver.set(new ChromeDriver(options));
 * 
 * This is commonly discussed in senior interviews.
 */
