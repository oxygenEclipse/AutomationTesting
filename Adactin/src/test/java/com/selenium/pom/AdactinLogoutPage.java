package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLogoutPage extends com.selenium.baseclass.BaseClass {

	@FindBy(xpath = "//a[text() = 'Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//a[text() = 'Click here to login again']")
	private WebElement loginAgain;

	public WebElement getLogout() {
		return logout;
	}

	public AdactinLogoutPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginAgain() {
		return loginAgain;
	}
}
