package com.framework.api.endpoints;

import com.framework.api.base.APIBase;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class LoginAPI extends APIBase {

	public Response login(String email, String password) {

		return request.formParam("email", email)
				.formParam("password", password).when().post("/api/verifyLogin");
		
		//given().contentType("application/x-www-form-urlencoded")
	}
}
