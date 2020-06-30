package com.automationtesting.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.functionallibrary.BaseClass;

public class ATAddToBasketPage extends BaseClass {

	public ATAddToBasketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Description']")
	private WebElement description;

	@FindBy(css = "#tab-description>p")
	private WebElement productDescription;

	public WebElement getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(WebElement productDescription) {
		this.productDescription = productDescription;
	}

	public WebElement getDescription() {
		return description;
	}

}
