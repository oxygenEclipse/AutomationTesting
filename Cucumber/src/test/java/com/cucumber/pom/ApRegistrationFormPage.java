package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApRegistrationFormPage extends BaseClass {
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement createAccountHeader1;
	
	@FindBy(xpath = "//input[@value='2' and @type='radio']")
    private WebElement titleRadioBtn;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement lastName;
	
	@FindBy(id = "email")
    private WebElement registeredEmail;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "days")
	private WebElement days;
	
	@FindBy(id = "months")
	private WebElement months;
	
	@FindBy(id = "years")
	private WebElement years;
	
	@FindBy(id = "newsletter")
	private WebElement signUpNews;
	
	@FindBy(id = "optin")
	private WebElement otherNews;
	
	@FindBy(id = "firstname")
	private WebElement addressFirstName;
	
	@FindBy(id = "lastname")
	private WebElement addressLastName;
	
	@FindBy(id = "company")
	private WebElement companyName;
	
	@FindBy(id = "address1")
	private WebElement addrLine1;
	
	@FindBy(id = "address2")
	private WebElement addrLine2;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "id_state")
	private WebElement state;
	
	@FindBy(id = "postcode")
	private WebElement postalCode;
	
	@FindBy(id = "id_country")
	private WebElement country;
	
	@FindBy(id = "other")
	private WebElement other;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id ="phone_mobile")
	private WebElement mobilePhone;
	
	@FindBy(id = "alias")
	private WebElement alias;
	
	@FindBy(id = "submitAccount")
	private WebElement registerBtn;

	public WebElement getCreateAccountHeader1() {
		return createAccountHeader1;
	}

	public WebElement getTitleRadioBtn() {
		return titleRadioBtn;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getRegisteredEmail() {
		return registeredEmail;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getDays() {
		return days;
	}

	public WebElement getMonths() {
		return months;
	}

	public WebElement getYears() {
		return years;
	}

	public WebElement getSignUpNews() {
		return signUpNews;
	}

	public WebElement getOtherNews() {
		return otherNews;
	}

	public WebElement getAddressFirstName() {
		return addressFirstName;
	}

	public WebElement getAddressLastName() {
		return addressLastName;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getAddrLine1() {
		return addrLine1;
	}

	public WebElement getAddrLine2() {
		return addrLine2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getMobilePhone() {
		return mobilePhone;
	}

	public WebElement getAlias() {
		return alias;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	
	public ApRegistrationFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
