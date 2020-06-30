package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LogoutPage extends BaseClass {

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

}
