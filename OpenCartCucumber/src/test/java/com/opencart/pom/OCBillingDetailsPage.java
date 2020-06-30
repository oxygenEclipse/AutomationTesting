package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCBillingDetailsPage {

	public OCBillingDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text' and @name = 'firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@type='text' and @name = 'lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@type='text' and @id = 'input-payment-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@type='text' and @name = 'telephone']")
	private WebElement telephone;
	
	@FindBy(xpath = "//input[@type='text' and @name = 'company']")
	private WebElement company;
	
	@FindBy(xpath = "//input[@type='text' and @name = 'address_1']")
	private WebElement address1;
	
	@FindBy(xpath = "//input[@type='text' and @name = 'city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@type='text' and @name = 'postcode']")
	private WebElement postcode;
	
	@FindBy(id = "input-payment-country")
	private WebElement country;
	
	@FindBy(id = "input-payment-zone")
	private WebElement state;
	
	@FindBy(id = "button-guest")
	private WebElement continueGuest;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostcode() {
		return postcode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getContinueGuest() {
		return continueGuest;
	}

}
