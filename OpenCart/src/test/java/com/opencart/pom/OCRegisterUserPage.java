package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.functionallibrary.BaseClass;

public class OCRegisterUserPage extends BaseClass {

	public OCRegisterUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".fa.fa-user")
	private WebElement myAccount;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement register;
	
	@FindBy(id ="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id= "input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-fax")
	private WebElement fax;
	
	@FindBy(id="input-company")
	private WebElement company;
	
	@FindBy(id="input-address-1")
	private WebElement address1;
	
	@FindBy(id = "input-address-2")
	private WebElement address2;
	
	@FindBy(id="input-city")
	private WebElement city;
	
	@FindBy(id="input-postcode")
	private WebElement postcode;
	
	@FindBy(id = "input-country")
	private WebElement country;
	
	@FindBy(id="input-zone")
	private WebElement state;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="(//input[@type='radio' and @name = 'newsletter'])[1]")
	private WebElement newsletter;
	
	@FindBy(xpath = "//input[@type='checkbox' and @name = 'agree']")
	private WebElement agree;
	
	@FindBy(xpath = "//input[@type='submit' and @value= 'Continue']")
	private WebElement continueRegistration;

	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement accountSuccessMsg;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueAccountPage;

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getRegister() {
		return register;
	}

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

	public WebElement getFax() {
		return fax;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
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

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getNewsletter() {
		return newsletter;
	}

	public WebElement getAgree() {
		return agree;
	}

	public WebElement getContinueRegistration() {
		return continueRegistration;
	}

	public WebElement getAccountSuccessMsg() {
		return accountSuccessMsg;
	}

	public WebElement getContinueAccountPage() {
		return continueAccountPage;
	}
	
	
	

}
