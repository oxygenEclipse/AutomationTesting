package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApSignOutPage extends BaseClass {
	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement signOut1;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signInPage;

	public WebElement getSignOut1() {
		return signOut1;
	}
	
	public ApSignOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignInPage() {
		return signInPage;
	}

	

}
