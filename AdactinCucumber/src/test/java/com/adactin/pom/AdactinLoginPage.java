package com.adactin.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.functionallibrary.BaseClass;

public class AdactinLoginPage extends BaseClass {

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginButton;

	@FindBy(xpath = "//img[@alt='AdactIn Group']")
	private WebElement logo;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public AdactinLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}
}
