package com.mobiletesting.automationpracticepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiletesting.baseclass.BaseClass;

public class ApSignOutPage extends BaseClass {
	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement signOut1;

	public WebElement getSignOut1() {
		return signOut1;
	}
	
	public ApSignOutPage() {
		PageFactory.initElements(driver, this);
	}

}
