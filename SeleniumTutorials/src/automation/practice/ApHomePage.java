package automation.practice;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApHomePage extends BaseClass {

	@FindBy(xpath = "//img[@alt='My Store']")
	private WebElement myStore;
	
	@FindBy(xpath = "//strong[text()='0123-456-789']")
	private WebElement mobileNum;
	
	@FindBy(xpath = "//a[text()='Contact us']")
	private WebElement contactUs;
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[@title='Women' and @class='sf-with-ul']")
	private WebElement womenMenu;

	public WebElement getMyStore() {
		return myStore;
	}

	public WebElement getMobileNum() {
		return mobileNum;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getWomenMenu() {
		return womenMenu;
	}
	
	ApHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
