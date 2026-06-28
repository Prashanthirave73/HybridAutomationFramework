package com.framework.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.api.endpoints.UserAPI;
import com.framework.api.models.CreateUserRequest;
import com.framework.api.models.CreateUserRequestWithoutLombok;
import com.framework.api.models.CreateUserResponseWithoutLombok;

import com.framework.testdata.TestDataFactory;
import com.framework.utilities.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserAPITest extends BaseAPITest {

	// With Builder: by using Lombok Builder- The Builder approach is cleaner for
	// large payloads
	@Test
	public void verifyCreateUser() {

		CreateUserRequest user = CreateUserRequest.builder()

				.name("Prashant Hirave").email("prashanthirave12@gmail.com").password("Test@234").title("Mr")

				.birth_date("1").birth_month("May").birth_year("1996")

				.firstname("Prashant").lastname("Hirave")

				.company("ABCD Technologies")

				.address1("Pune").address2("Hinjewadi2")

				.country("India").zipcode("411033").state("Maharashtra").city("Pune")

				.mobile_number("98765432101")

				.build();

		UserAPI userAPI = new UserAPI();

		Response response = userAPI.createUser(user);

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// Without Lombok builder - Rest Assured automatically serializes:Serialize POJO
	// to JSON
	@Test
	public void verifyCreateUserWithoutLombok() {

		CreateUserRequestWithoutLombok user = new CreateUserRequestWithoutLombok();

		user.setName("Dada1");
		user.setEmail("dada1" + System.currentTimeMillis() + "@test.com");
		user.setPassword("Test@231");
		user.setTitle("Mr");

		user.setBirth_date("1");
		user.setBirth_month("May");
		user.setBirth_year("1996");

		user.setFirstname("Dada1");
		user.setLastname("Hirave");

		user.setCompany("ABCDE");

		user.setAddress1("Pune");
		user.setAddress2("Hinjewadi1");

		user.setCountry("India");
		user.setZipcode("411033");
		user.setState("Maharashtra");
		user.setCity("Pune");

		user.setMobile_number("987654321052");

		UserAPI userAPI = new UserAPI();

		Response response = userAPI.createUser(user);

		System.out.println(response.asPrettyString());

		System.out.println("========== USER CREATED ==========");

		System.out.println("Email    : " + user.getEmail());

		System.out.println("Password : " + user.getPassword());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void verifyGetUserByEmail() {

		String email = "dada11781427847409@test.com";

		Response response = new UserAPI().getUserByEmail(email);

		response.prettyPrint();

		Assert.assertEquals(response.getStatusCode(), 200);

		JsonPath json = response.jsonPath();

		Assert.assertEquals(json.getInt("responseCode"), 200);

		Assert.assertEquals(json.getString("user.email"), email);

		System.out.println("User Name : " + json.getString("user.name"));

		System.out.println("User Email : " + json.getString("user.email"));

		System.out.println("User Pass : " + json.getString("user.company"));
	}

	// Complete End-to-End Test---dynamically create email of user get by email that
	// user

	@Test
	public void verifyCreateAndGetUser() {

		UserAPI userAPI = new UserAPI();

		CreateUserRequest user = TestDataFactory.getUser();

		Response createResponse = userAPI.createUser(user);

		Assert.assertEquals(createResponse.jsonPath().getInt("responseCode"), 201);

		Response getResponse = userAPI.getUserByEmail(user.getEmail());

		System.out.println("User Name : " + getResponse.jsonPath().getString("user.name"));

		System.out.println("User Email : " + getResponse.jsonPath().getString("user.email"));

		Assert.assertEquals(getResponse.jsonPath().getString("user.email"), user.getEmail());

		Assert.assertEquals(getResponse.jsonPath().getString("user.name"), user.getName());
	}

	// Test using Deserialization
	// By using Rest assured automatically deserialization possible if respons is
	// only in JSOn format : CreateUserResponse responseObj
	// =response.as(CreateUserResponse.class);
	// But here response in text/html; charset=utf-8---<htmal> <body>..... </body>
	// </html> format, So we neet to convert in JSO by using Jackson, or JsonPath

	@Test
	public void verifyCreateUser1() throws Exception {

		Response response = userAPI.createUser();

		String json = ResponseUtil.extractJsonFromHtml(response.asString());

		// using ObjectMapper comes from the Jackson Databind library.

		/*
		 * ObjectMapper mapper = new ObjectMapper();
		 * 
		 * CreateUserResponseWithoutLombok responseObj = mapper.readValue(json,
		 * CreateUserResponseWithoutLombok.class);
		 */

		// using JsonPath comes from the Jackson Databind library.

		CreateUserResponseWithoutLombok responseObj = JsonPath.from(json).getObject("",
				CreateUserResponseWithoutLombok.class);

		Assert.assertEquals(responseObj.getResponseCode(), 201);

		Assert.assertEquals(responseObj.getMessage(), "User created!");

		System.out.println("Response Code : " + responseObj.getResponseCode());

		System.out.println("Message : " + responseObj.getMessage());

	}
}