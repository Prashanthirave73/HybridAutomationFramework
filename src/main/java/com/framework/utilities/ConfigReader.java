package com.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public final class ConfigReader {

	private static final Properties prop = new Properties();

	static {

		try {

			// Common Config
			prop.load(new FileInputStream("src/test/resources/config/config.properties"));

			// Environment Config
			String env = EnvironmentReader.getEnvironment();

			prop.load(new FileInputStream("src/test/resources/config/" + env + ".properties"));

			System.out.println("Environment Loaded : " + env);

		} catch (Exception e) {

			throw new RuntimeException("Failed to load config files", e);
		}
	}

	private ConfigReader() {
	}

	public static String getProperty(String key) {

		return prop.getProperty(key);
	}

}