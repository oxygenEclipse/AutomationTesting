package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApPaymentPage extends BaseClass {
@FindBy(xpath = "//a[@title='Pay by bank wire']")
private WebElement payment;

public WebElement getPayment() {
	return payment;
}
public ApPaymentPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
}
