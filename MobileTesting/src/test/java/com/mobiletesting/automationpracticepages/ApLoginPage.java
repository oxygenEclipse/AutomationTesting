package com.mobiletesting.automationpracticepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiletesting.baseclass.BaseClass;

public class ApLoginPage extends BaseClass {
	@FindBy(xpath = "//span[text() ='Automation Lastname']")
	private WebElement loginPageName;

	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement signOut;

	@FindBy(xpath = "//span[text() ='Order history and details']")
	private WebElement orderHistory;

	@FindBy(xpath = "//span[text() ='My credit slips']")
	private WebElement creditSlips;

	@FindBy(xpath = "//span[text() ='My addresses']")
	private WebElement myAddress;

	@FindBy(xpath = "//span[text() ='My personal information']")
	private WebElement personalInfo;

	@FindBy(xpath = "//span[text() ='My wishlists']")
	private WebElement wishLists;

	public WebElement getLoginPageName() {
		return loginPageName;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getOrderHistory() {
		return orderHistory;
	}

	public WebElement getCreditSlips() {
		return creditSlips;
	}

	public WebElement getMyAddress() {
		return myAddress;
	}

	public WebElement getPersonalInfo() {
		return personalInfo;
	}

	public WebElement getWishLists() {
		return wishLists;
	}

	public ApLoginPage() {
		PageFactory.initElements(driver, this);
	}

}
