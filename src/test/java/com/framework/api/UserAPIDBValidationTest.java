package com.framework.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.api.models.CreateUserRequestWithoutLombok;
import com.framework.database.UserRepository;
import com.framework.models.UserDBModel;

import io.restassured.response.Response;

public class UserAPIDBValidationTest extends BaseAPITest {

	@Test
	public void verifyUserCreatedInDB() {

		CreateUserRequestWithoutLombok user = new CreateUserRequestWithoutLombok();

		String email = "dada11" + System.currentTimeMillis() + "@test.com";

		user.setName("PrashantDada1");
		user.setEmail(email);

		Response response = userAPI.createUser(user);

		response.then().statusCode(200);

		UserRepository repository = new UserRepository();

		UserDBModel dbUser = repository.getUserByEmail(email);

		Assert.assertEquals(dbUser.getEmail(), email);
	}
}