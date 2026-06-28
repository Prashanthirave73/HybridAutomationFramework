package com.framework.testdata;

import com.framework.api.models.CreateUserRequest;

import net.datafaker.Faker;

public class TestDataFactory {

	private static final Faker faker = new Faker();

	public static CreateUserRequest getUser() {

		CreateUserRequest user = new CreateUserRequest();

		user.setName(faker.name().fullName());

		user.setEmail(faker.internet().emailAddress());

		user.setPassword(faker.internet().password());

		user.setTitle("Mr");

		user.setBirth_date("10");
		user.setBirth_month("May");
		user.setBirth_year("1996");

		user.setFirstname(faker.name().firstName());

		user.setLastname(faker.name().lastName());

		user.setCompany(faker.company().name());

		user.setAddress1(faker.address().streetAddress());

		user.setAddress2(faker.address().secondaryAddress());

		user.setCountry("India");

		user.setZipcode("411033");

		user.setState("Maharashtra");

		user.setCity("Pune");

		user.setMobile_number(faker.phoneNumber().cellPhone());

		return user;
	}
}
