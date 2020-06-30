package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApSignInCreatePage extends BaseClass {

	@FindBy(xpath = "//h1[text()='Authentication']")
	private WebElement authenticationHeader;

	@FindBy(xpath = "//h3[text()='Create an account']")
	private WebElement createAccountHeader;

	@FindBy(xpath = "//h3[text()='Already registered?']")
	private WebElement alreadyRegisteredHeader;

	@FindBy(id = "email_create")
	private WebElement emailAddress;

	@FindBy(id = "SubmitCreate")
	private WebElement createAccountBtn;

	public WebElement getAuthenticationHeader() {
		return authenticationHeader;
	}

	public WebElement getCreateAccountHeader() {
		return createAccountHeader;
	}

	public WebElement getAlreadyRegisteredHeader() {
		return alreadyRegisteredHeader;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}

	public ApSignInCreatePage() {
		PageFactory.initElements(driver, this);
	}
}
