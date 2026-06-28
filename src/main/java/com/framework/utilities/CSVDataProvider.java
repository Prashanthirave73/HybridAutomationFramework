package com.framework.utilities;

import java.util.List;

import org.testng.annotations.DataProvider;

public class CSVDataProvider {
	
	@DataProvider(name = "productData")
	public Object[][] getProducts() throws Exception {

	    List<String[]> products =
	            CSVUtil.getData("src/test/resources/testdata/products.csv");

	    Object[][] data =
	            new Object[products.size()][2];

	    for (int i = 0; i < products.size(); i++) {

	        data[i][0] = products.get(i)[0];

	        data[i][1] = products.get(i)[1];
	    }

	    return data;
	}

}
