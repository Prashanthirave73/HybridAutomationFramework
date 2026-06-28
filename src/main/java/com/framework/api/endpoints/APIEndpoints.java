package com.framework.api.endpoints;

public final class APIEndpoints {

	private APIEndpoints() {
	}

	public static final String PRODUCTS = "/api/productsList";

	public static final String BRANDS = "/api/brandsList";

	public static final String CREATE_USER = "/api/createAccount";

	public static final String VERIFY_USER = "/api/verifyLogin";

	public static final String DELETE_USER = "/api/deleteAccount";

	public static final String UPDATE_USER = "/api/updateAccount";

	public static final String GET_USER_BY_EMAIL = "/api/getUserDetailByEmail";
}