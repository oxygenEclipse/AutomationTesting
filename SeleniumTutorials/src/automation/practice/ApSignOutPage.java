package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApSignOutPage extends BaseClass {
	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement signOut1;

	public WebElement getSignOut1() {
		return signOut1;
	}
	
	ApSignOutPage() {
		PageFactory.initElements(driver, this);
	}

}
