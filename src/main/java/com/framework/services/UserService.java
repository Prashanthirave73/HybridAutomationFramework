package com.framework.services;

import com.framework.api.endpoints.UserAPI;
import com.framework.api.models.CreateUserRequest;
import io.restassured.response.Response;

public class UserService {

	private UserAPI userAPI = new UserAPI();

	public Response createUser(CreateUserRequest user) {

		return userAPI.createUser(user);
	}
}