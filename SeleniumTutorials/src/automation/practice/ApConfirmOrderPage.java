package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApConfirmOrderPage extends BaseClass {
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	private WebElement confirmPayment;

	public WebElement getConfirmPayment() {
		return confirmPayment;
	}

	ApConfirmOrderPage() {
		PageFactory.initElements(driver, this);
	}
}
