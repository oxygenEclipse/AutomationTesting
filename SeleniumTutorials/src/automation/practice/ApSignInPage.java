package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApSignInPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signIn;

	@FindBy(id = "email")
	private WebElement emailId;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement submitLogin;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitLogin() {
		return submitLogin;
	}

	ApSignInPage() {
		PageFactory.initElements(driver, this);
	}
	
}
