package com.framework.validators;

import org.testng.Assert;

public class OrderValidator {

	public void verifyOrder(String orderId) {

		Assert.assertNotNull(orderId);
	}
}
