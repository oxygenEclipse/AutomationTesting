package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLoginPage extends com.selenium.baseclass.BaseClass {

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginButton;
	
	@FindBy(xpath="//img[@alt='AdactIn Group']")
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
	public WebElement getLogo() {
		return logo;
	}

	public AdactinLoginPage() {
		PageFactory.initElements(driver, this);
	}

	
}
