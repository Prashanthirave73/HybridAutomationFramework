package com.framework.api.endpoints;

import com.framework.api.base.APIBase;

import io.restassured.response.Response;

public class ProductAPI extends APIBase {

	public Response getProducts() {

		return request

				.get(APIEndpoints.PRODUCTS);
	}

	public Response getBrandsList() {

		return request

				.when()

				.get(APIEndpoints.BRANDS);
	}
}
