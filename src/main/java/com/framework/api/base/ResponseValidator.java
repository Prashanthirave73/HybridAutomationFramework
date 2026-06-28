package com.framework.api.base;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseValidator {

	public static ResponseSpecification successResponse() {
		return new ResponseSpecBuilder().expectStatusCode(200).build();
	}

	public static ResponseSpecification createdResponse() {
		return new ResponseSpecBuilder().expectStatusCode(201).build();
	}

	public static ResponseSpecification badRequestResponse() {
		return new ResponseSpecBuilder().expectStatusCode(400).build();
	}

	public static ResponseSpecification unauthorizedResponse() {
		return new ResponseSpecBuilder().expectStatusCode(401).build();
	}

	public static ResponseSpecification notFoundResponse() {
		return new ResponseSpecBuilder().expectStatusCode(404).build();
	}
}
