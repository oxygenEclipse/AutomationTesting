package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.functionallibrary.BaseClass;

public class OCAccountPage extends BaseClass {

	public OCAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Logout' and @class='list-group-item']")
	private WebElement logout;

	@FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
	private WebElement accountLogoutMsg;

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement logoutContinue;

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getAccountLogoutMsg() {
		return accountLogoutMsg;
	}

	public WebElement getLogoutContinue() {
		return logoutContinue;
	}

}
