package com.framework.utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name = "loginExcelData")

	public Object[][] getLoginData() {

		return ExcelUtil.getData("src/test/resources/testdata/LoginData.xlsx", "Login");
	}
}