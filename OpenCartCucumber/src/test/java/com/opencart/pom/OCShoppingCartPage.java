package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCShoppingCartPage {

	public OCShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	@FindBy(xpath= "//a[text()='Checkout']")
	private WebElement checkOut;
}
