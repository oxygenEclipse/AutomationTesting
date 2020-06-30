package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApAddressPage extends BaseClass {

	@FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[1]")
	private WebElement deliveryAddressName;

	@FindBy(xpath = "(//li[@class='address_company'])[1]")
	private WebElement deliveryAddressCompany;

	@FindBy(xpath = "(//li[@class='address_address1 address_address2'])[1]")
	private WebElement deliveryAddressLine1;

	@FindBy(xpath = "(//li[@class='address_city address_state_name address_postcode'])[1]")
	private WebElement deliveryAddressCity;

	@FindBy(xpath = "(//li[@class='address_country_name'])[1]")
	private WebElement deliveryAddressCountry;

	@FindBy(xpath = "(//li[@class='address_phone'])[1]")
	private WebElement deliveryAddressPhone;

	@FindBy(xpath = "(//li[@class='address_phone_mobile'])[1]")
	private WebElement deliveryAddressMobilePhone;
	
	@FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[2]")
	private WebElement invoiceAddressName;

	@FindBy(xpath = "(//li[@class='address_company'])[2]")
	private WebElement invoiceAddressCompany;

	@FindBy(xpath = "(//li[@class='address_address1 address_address2'])[2]")
	private WebElement invoiceAddressLine1;

	@FindBy(xpath = "(//li[@class='address_city address_state_name address_postcode'])[2]")
	private WebElement invoiceAddressCity;

	@FindBy(xpath = "(//li[@class='address_country_name'])[1]")
	private WebElement invoiceAddressCountry;

	@FindBy(xpath = "(//li[@class='address_phone'])[2]")
	private WebElement invoiceAddressPhone;

	@FindBy(xpath = "(//li[@class='address_phone_mobile'])[2]")
	private WebElement invoiceAddressMobilePhone;

	@FindBy(name = "processAddress")
	private WebElement addressCheckOut;

	public WebElement getAddressCheckOut() {
		return addressCheckOut;
	}

	public WebElement getDeliveryAddressName() {
		return deliveryAddressName;
	}

	public WebElement getDeliveryAddressCompany() {
		return deliveryAddressCompany;
	}

	public WebElement getDeliveryAddressLine1() {
		return deliveryAddressLine1;
	}

	public WebElement getDeliveryAddressCity() {
		return deliveryAddressCity;
	}

	public WebElement getDeliveryAddressCountry() {
		return deliveryAddressCountry;
	}

	public WebElement getDeliveryAddressPhone() {
		return deliveryAddressPhone;
	}

	public WebElement getDeliveryAddressMobilePhone() {
		return deliveryAddressMobilePhone;
	}
	
	public WebElement getInvoiceAddressName() {
		return invoiceAddressName;
	}

	public WebElement getInvoiceAddressCompany() {
		return invoiceAddressCompany;
	}

	public WebElement getInvoiceAddressLine1() {
		return invoiceAddressLine1;
	}

	public WebElement getInvoiceAddressCity() {
		return invoiceAddressCity;
	}

	public WebElement getInvoiceAddressCountry() {
		return invoiceAddressCountry;
	}

	public WebElement getInvoiceAddressPhone() {
		return invoiceAddressPhone;
	}

	public WebElement getInvoiceAddressMobilePhone() {
		return invoiceAddressMobilePhone;
	}
	
	ApAddressPage() {
		PageFactory.initElements(driver, this);
	}

}
