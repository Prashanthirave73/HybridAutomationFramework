package com.framework.api.endpoints;

import static io.restassured.RestAssured.given;

import com.framework.api.base.APIBase;
import com.framework.api.models.CreateUserRequest;
import com.framework.api.models.CreateUserRequestWithoutLombok;

import io.restassured.response.Response;

public class UserAPI extends APIBase {

	public Response createUser(CreateUserRequest request) {

		return given()

				.formParam("name", request.getName())

				.formParam("email", request.getEmail())

				.formParam("password", request.getPassword())

				.formParam("title", request.getTitle())

				.formParam("birth_date", request.getBirth_date())

				.formParam("birth_month", request.getBirth_month())

				.formParam("birth_year", request.getBirth_year())

				.formParam("firstname", request.getFirstname())

				.formParam("lastname", request.getLastname())

				.formParam("company", request.getCompany())

				.formParam("address1", request.getAddress1())

				.formParam("address2", request.getAddress2())

				.formParam("country", request.getCountry())

				.formParam("zipcode", request.getZipcode())

				.formParam("state", request.getState())

				.formParam("city", request.getCity())

				.formParam("mobile_number", request.getMobile_number())

				.when()

				.post("/api/createAccount");
	}

	public Response createUser(CreateUserRequestWithoutLombok request) {

		return given()

				.formParam("name", request.getName())

				.formParam("email", request.getEmail())

				.formParam("password", request.getPassword())

				.formParam("title", request.getTitle())

				.formParam("birth_date", request.getBirth_date())

				.formParam("birth_month", request.getBirth_month())

				.formParam("birth_year", request.getBirth_year())

				.formParam("firstname", request.getFirstname())

				.formParam("lastname", request.getLastname())

				.formParam("company", request.getCompany())

				.formParam("address1", request.getAddress1())

				.formParam("address2", request.getAddress2())

				.formParam("country", request.getCountry())

				.formParam("zipcode", request.getZipcode())

				.formParam("state", request.getState())

				.formParam("city", request.getCity())

				.formParam("mobile_number", request.getMobile_number())

				.when()

				.post("/api/createAccount");
	}

	public Response getUserByEmail(String email) {

		return given()

				.queryParam("email", email)

				.log().all()

				.when()

				.get("/api/getUserDetailByEmail");
	}

	public Response createUser() {

		String email = "prashant" + System.currentTimeMillis() + "@test.com";

		return given().contentType("application/x-www-form-urlencoded").accept("application/json")
				.formParam("name", "Prashant").formParam("email", email).formParam("password", "Test@123")
				.formParam("title", "Mr").formParam("birth_date", "10").formParam("birth_month", "May")
				.formParam("birth_year", "1990").formParam("firstname", "Prashant").formParam("lastname", "Hirave")
				.formParam("company", "ABC").formParam("address1", "Nagpur").formParam("country", "India")
				.formParam("state", "Maharashtra").formParam("city", "Nagpur").formParam("zipcode", "440001")
				.formParam("mobile_number", "9876543210").when().post("/api/createAccount");
	}

}