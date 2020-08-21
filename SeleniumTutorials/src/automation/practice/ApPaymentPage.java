package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApPaymentPage extends BaseClass {
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	private WebElement payment;

	public WebElement getPayment() {
		return payment;
	}

	ApPaymentPage() {
		PageFactory.initElements(driver, this);
	}
}
