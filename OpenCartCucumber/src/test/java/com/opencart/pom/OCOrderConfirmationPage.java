package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCOrderConfirmationPage {

	public OCOrderConfirmationPage(WebDriver driver) {
           PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueHomePage;

	public WebElement getContinueHomePage() {
		return continueHomePage;
	}
}
