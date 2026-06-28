package com.framework.utilities;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.response.Response;

public class SchemaValidator {

	public static void validate(Response response, String schemaPath) {

		response.then().body(matchesJsonSchemaInClasspath(schemaPath));
	}
}
