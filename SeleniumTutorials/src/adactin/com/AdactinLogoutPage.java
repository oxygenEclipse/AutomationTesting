package adactin.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.practice.BaseClass;

public class AdactinLogoutPage extends BaseClass {

	@FindBy(xpath = "//a[text() = 'Logout']")
	private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

	public AdactinLogoutPage() {
		PageFactory.initElements(driver, this);
	}
}
