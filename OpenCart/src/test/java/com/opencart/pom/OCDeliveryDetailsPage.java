package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCDeliveryDetailsPage {
	
	public OCDeliveryDetailsPage(WebDriver driver) {
       PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//textarea[@name = 'comment']")
	private WebElement comment;
	
	@FindBy(id="button-shipping-method")
	private WebElement continueShipping;
	
	@FindBy(xpath="//input[@name = 'agree']")
	private WebElement agree;
	
	@FindBy(id= "button-payment-method")
	private WebElement continuePayment;
	
	@FindBy(id="button-confirm")
	private WebElement confirmOrder;

	public WebElement getComment() {
		return comment;
	}

	public WebElement getContinueShipping() {
		return continueShipping;
	}

	public WebElement getAgree() {
		return agree;
	}

	public WebElement getContinuePayment() {
		return continuePayment;
	}

	public WebElement getConfirmOrder() {
		return confirmOrder;
	}
	
	
}
