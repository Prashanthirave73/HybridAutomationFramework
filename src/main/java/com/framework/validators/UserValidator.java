package com.framework.validators;

import org.testng.Assert;

import com.framework.database.UserRepository;
import com.framework.models.UserDBModel;

public class UserValidator {

	private UserRepository repo = new UserRepository();

	public void verifyUserExists(String email) {

		UserDBModel user = repo.getUserByEmail(email);

		Assert.assertEquals(user.getEmail(), email);
	}
}
