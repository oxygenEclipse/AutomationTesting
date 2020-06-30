package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCCheckOutPage {
	
	public OCCheckOutPage(WebDriver driver) {
     PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='guest']")
	private WebElement guest;
	
	@FindBy(id = "button-account")
	private WebElement continueGuest;

	public WebElement getGuest() {
		return guest;
	}

	public WebElement getContinueGuest() {
		return continueGuest;
	}
	

}
