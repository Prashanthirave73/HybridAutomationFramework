package com.framework.utilities;

import net.datafaker.Faker;

public class FakerUtil {

	private static Faker faker = new Faker();

	public static String getEmail() {

		return faker.internet().emailAddress();
	}

	public static String getName() {

		return faker.name().fullName();
	}

	public static String getPassword() {

		return faker.internet().password();
	}
}