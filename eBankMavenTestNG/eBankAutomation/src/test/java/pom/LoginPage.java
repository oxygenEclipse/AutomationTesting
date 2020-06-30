package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(name="uid")
	private WebElement userId;
	
	@FindBy(name="password")
	private WebElement userPassword;
	
	@FindBy(name="btnLogin")
	private WebElement login;

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getLogin() {
		return login;
	}
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
}
