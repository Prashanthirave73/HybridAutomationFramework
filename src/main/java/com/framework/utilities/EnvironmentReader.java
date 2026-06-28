package com.framework.utilities;

public final class EnvironmentReader {

	private EnvironmentReader() {
	}

	public static String getEnvironment() {

		return System.getProperty("env", "qa");
	}
}