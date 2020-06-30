package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApSearchBoxOrder extends BaseClass {
	@FindBy(id = "search_query_top")
	private WebElement searchQuery;

	@FindBy(name = "submit_search")
	private WebElement submitSearch;

	@FindBy(xpath = "(//a[contains(text(),'Blouse') and @title='Blouse'])")
	private WebElement selectedProduct;

	@FindBy(xpath = "//a[@title='View my customer account']/span")
	private WebElement customerName;

	public WebElement getSearchQuery() {
		return searchQuery;
	}

	public WebElement getSubmitSearch() {
		return submitSearch;
	}

	public WebElement getSelectedProduct() {
		return selectedProduct;
	}

	public ApSearchBoxOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerName() {
		return customerName;
	}

}
