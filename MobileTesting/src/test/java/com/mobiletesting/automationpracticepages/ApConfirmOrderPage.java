package com.mobiletesting.automationpracticepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiletesting.baseclass.BaseClass;

public class ApConfirmOrderPage extends BaseClass {
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	private WebElement confirmPayment;

	public WebElement getConfirmPayment() {
		return confirmPayment;
	}

	public ApConfirmOrderPage() {
		PageFactory.initElements(driver, this);
	}
}
