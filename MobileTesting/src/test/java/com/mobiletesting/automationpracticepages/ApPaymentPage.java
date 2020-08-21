package com.mobiletesting.automationpracticepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiletesting.baseclass.BaseClass;

public class ApPaymentPage extends BaseClass {
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	private WebElement payment;

	public WebElement getPayment() {
		return payment;
	}

	public ApPaymentPage() {
		PageFactory.initElements(driver, this);
	}
}
