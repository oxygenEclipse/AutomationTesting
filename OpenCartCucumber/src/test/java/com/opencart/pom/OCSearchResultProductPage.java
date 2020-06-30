package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.functionallibrary.BaseClass;

public class OCSearchResultProductPage extends BaseClass {
	public OCSearchResultProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Apple Cinema 30')]")
	private WebElement appleProd;

	public WebElement getAppleProd() {
		return appleProd;
	}
}
