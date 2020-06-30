package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApSummaryPage extends BaseClass {

	@FindBy(xpath = "(//a[text()='Blouse'])[2]")
	private WebElement summaryPageProductName;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	private WebElement proceedCheckOutBtn;

	@FindBy(xpath = "(//span[@class=\"price\"])[3]")
	private WebElement productUnitPrice;

	@FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
	private WebElement productQuantity;

	@FindBy(xpath = "(//span[@class=\"price\"])[4]")
	private WebElement productTotal;

	public WebElement getProceedCheckOutBtn() {
		return proceedCheckOutBtn;
	}

	public WebElement getProductUnitPrice() {
		return productUnitPrice;
	}

	public WebElement getProductQuantity() {
		return productQuantity;
	}

	public WebElement getProductTotal() {
		return productTotal;
	}

	ApSummaryPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSummaryPageProductName() {
		return summaryPageProductName;
	}

}
