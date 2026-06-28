package com.framework.utilities;

import org.testng.annotations.DataProvider;

import com.framework.models.User;

public class JsonDataProvider {
	@DataProvider(name = "jsonData")
	public Object[][] getJsonData() {

		User[] users = JsonUtil.getUsers();

		Object[][] data = new Object[users.length][2];

		for (int i = 0; i < users.length; i++) {

			data[i][0] = users[i].getUsername();
			data[i][1] = users[i].getPassword();
		}

		return data;
	}
}
