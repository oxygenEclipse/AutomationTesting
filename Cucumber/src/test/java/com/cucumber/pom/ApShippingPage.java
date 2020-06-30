package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApShippingPage extends BaseClass {

	@FindBy(id = "cgv")
	private WebElement agreeCheckBox;
	
	@FindBy(name = "processCarrier")
	private WebElement shippingCheckOut;

	public WebElement getAgreeCheckBox() {
		return agreeCheckBox;
	}

	public WebElement getShippingCheckOut() {
		return shippingCheckOut;
	}
	public ApShippingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
}
