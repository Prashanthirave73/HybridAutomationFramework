package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "search_product")
	private WebElement searchBox;

	@FindBy(id = "submit_search")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@class='productinfo text-center']")
	private WebElement searchedProduct;

	public boolean searchProduct(String productName) {

		searchBox.sendKeys(productName);

		searchButton.click();

		return searchedProduct.isDisplayed();
	}
}
