package com.framework.database;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.models.UserDBModel;

public class DBValidationTest {

	/*
	 * @Test
	 * 
	 * public void verifyUserExists() {
	 * 
	 * UserRepository repo = new UserRepository();
	 * 
	 * UserDBModel user = repo.getUserByEmail("user@test.com");
	 * 
	 * Assert.assertEquals(user.getEmail(), "user@test.com"); }
	 */

	@Test
	public void verifyUserExists1() {

		String query = "SELECT * FROM users " + "WHERE email='user@test.com'";

		String email = DBUtils.getSingleValue(query, "email");

		Assert.assertEquals(email, "user@test.com");
	}
}
