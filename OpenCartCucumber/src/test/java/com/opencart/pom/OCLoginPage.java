package com.opencart.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.functionallibrary.BaseClass;

public class OCLoginPage extends BaseClass {

	public OCLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value = 'Login'] ")
	private WebElement login;

	@FindBy(css = ".alert.alert-danger")
	private WebElement alertWarning;

	@FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
	private WebElement returningCustomerLabel;

	@FindBy(xpath = "//strong[contains(text(),'I am a returning customer')]")
	private WebElement returningCustomerText;

	@FindBy(xpath = "//a[text()='Forgotten Password']")
	private WebElement forgetLink;

	public WebElement getForgetLink() {
		return forgetLink;
	}

	public WebElement getReturningCustomerLabel() {
		return returningCustomerLabel;
	}

	public WebElement getReturningCustomerText() {
		return returningCustomerText;
	}

	public WebElement getAlertWarning() {
		return alertWarning;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public boolean loginVerify(String email, String password) {
		passValue(getEmail(), email);
		passValue(getPassword(), password);
		click(getLogin());
		try {
			boolean msg = isDisplayed(getAlertWarning());
			return msg;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getAlertWarningMsg(WebElement alertWarning) {
		return alertWarning.getAttribute("innerText");

	}
}
