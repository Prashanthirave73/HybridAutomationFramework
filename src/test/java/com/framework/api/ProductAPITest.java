package com.framework.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.api.base.ResponseValidator;
import com.framework.api.endpoints.ProductAPI;
import com.framework.utilities.APIUtil;
import com.framework.utilities.JsonUtil;
import com.framework.utilities.ResponseUtil;
import com.framework.utilities.SchemaValidator;

import static org.hamcrest.Matchers.lessThan;
import io.restassured.path.json.JsonPath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.response.Response;

public class ProductAPITest extends BaseAPITest {

	@Test
	public void verifyProductsAPI() {

		ProductAPI api = new ProductAPI();

		Response response = api.getProducts();

		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println(response.asPrettyString());
	}

	@Test
	public void verifyProductsList() {

		Response response = productAPI.getProducts();

		response.then()

				.statusCode(200)

				.header("Content-Type", "text/html; charset=utf-8")

				.time(lessThan(5000L));

		Assert.assertTrue(response.asString().contains("products"));

		JsonPath json = response.jsonPath();

		Assert.assertEquals(json.getInt("responseCode"), 200);

		Assert.assertFalse(json.getList("products").isEmpty());

		Assert.assertTrue(json.getList("products").size() > 0);

		System.out.println("Total Products : " + json.getList("products").size());

		System.out.println("===== RESPONSE =====");

		// response.prettyPrint();

		JsonUtil.printPrettyJson(response.asString());
		// JsonUtil.printPrettyJson(ResponseUtil.extractJsonFromHtml(response.asString()));
	}

	@Test
	public void verifyBrandsList() {

		Response response = productAPI.getBrandsList();

		response.then()

				.statusCode(200)

				.header("Content-Type", "text/html; charset=utf-8")

				.time(lessThan(5000L));

		JsonPath json = response.jsonPath();

		Assert.assertEquals(json.getInt("responseCode"), 200);

		Assert.assertFalse(json.getList("brands").isEmpty());

		System.out.println("Total Brands : " + json.getList("brands").size());

		// response.prettyPrint();
		JsonUtil.printPrettyJson(response.asString());

		// Assert.assertNotNull(json.getString("brands[0].brand"));

		String firstBrand = json.getString("brands[0].brand");

		System.out.println("First Brand : " + firstBrand);

	}

	// Response Specification : By using ResponseValidator.successResponse() it
	// centralizes response validation and keeps test cases clean and maintainable.

	@Test
	public void verifyProductList() {

		/*
		 * ProductAPI api = new ProductAPI(); Response response = api.getProducts();
		 */
		// Response response =
		// given().when().get("https://automationexercise.com/api/productsList");
		// Response response = productAPI.getProducts();

		// ProductAPI productAPI = new ProductAPI();
		Response response = productAPI.getProducts();

		response.then().spec(ResponseValidator.successResponse());

		System.out.println(response.asPrettyString());
	}

	// Schema validate test method level
	@Test
	public void verifyProductsListwithScema() {

		Response response = productAPI.getProducts();

		response.then().statusCode(200).body(matchesJsonSchemaInClasspath("schema/products-schema.json"));

		System.out.println("Schema validation passed");
	}

	// Schema validate using ScemaValidator utility

	@Test
	public void verifyProductsListwithScemaValidatorutility() {

		Response response = productAPI.getProducts();

		SchemaValidator.validate(response, "schema/products-schema.json");

		System.out.println("Schema validation passed");

		JsonUtil.printPrettyJson(ResponseUtil.extractJsonFromHtml(response.asString()));
	}

	// Genric API Utils statuscode,ResponseTime and Header use in this method

	@Test
	public void verifyProductsList2() {

		Response response = productAPI.getProducts();

		APIUtil.verifyStatusCode(response, 200);

		APIUtil.verifyResponseTime(response, 5000);

		APIUtil.verifyHeader(response, "Content-Type", "text/html; charset=utf-8");

		System.out.println("Products API validation passed");
	}

}
