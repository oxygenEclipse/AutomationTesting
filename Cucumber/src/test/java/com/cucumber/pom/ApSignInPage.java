package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApSignInPage extends BaseClass {
	WebDriver driver;

	public ApSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signIn;

	@FindBy(id = "email")
	private WebElement emailId;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement submitLogin;

	@FindBy(xpath = "//a[@title='View my customer account']/span")
	private WebElement userName;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitLogin() {
		return submitLogin;
	}

	public WebElement getUserName() {
		return userName;
	}
}
