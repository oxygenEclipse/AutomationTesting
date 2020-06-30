package automation.practice;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeJunit extends BaseClass {
	public static WebDriver driver;

	@BeforeClass
	public static void driverInitialization() throws Exception {
		driver = browserLaunch("chrome");
		driver.get("http://automationpractice.com/index.php");
	}

	@Before
	public void ApHomePageSignIn() {
		ApSignInPage signInPage = new ApSignInPage();
		ApHomePage homePage = new ApHomePage();

		// HomePage - My Store, Mobile Number, Contact Us, Sign In
		
		Assert.assertTrue(isDisplayed(homePage.getMyStore()));
		Assert.assertTrue(isDisplayed(homePage.getMobileNum()));
		Assert.assertTrue(isDisplayed(homePage.getContactUs()));
		Assert.assertTrue(isDisplayed(homePage.getSignIn()));
		Assert.assertEquals(getText(homePage.getMobileNum()), "0123-456-789");
	/*	String mobileNumText = getText(homePage.getMobileNum());
		if (mobileNumText.equalsIgnoreCase("0123-456-789"))
			System.out.println("Mobile Number Validation Check is true");
		else
			System.out.println("Mobile Number Validation Check is false");*/
		
		Assert.assertTrue(isDisplayed(signInPage.getSignIn()));
		clickIsSelected(signInPage.getSignIn());

		ApSignInCreatePage AfterSignInPage = new ApSignInCreatePage();

		// Authentication Header, Already Registered Header, Create Account Header,
		// Email Address, Create Account Button

		Assert.assertTrue(isDisplayed(AfterSignInPage.getAuthenticationHeader()));
		Assert.assertTrue(isDisplayed(AfterSignInPage.getAlreadyRegisteredHeader()));
		Assert.assertTrue(isDisplayed(AfterSignInPage.getCreateAccountHeader()));
		Assert.assertTrue(isDisplayed(AfterSignInPage.getEmailAddress()));
		Assert.assertTrue(isDisplayed(AfterSignInPage.getCreateAccountBtn()));
		Assert.assertTrue(isDisplayed(signInPage.getEmailId()));
		Assert.assertTrue(isDisplayed(signInPage.getPassword()));
		Assert.assertTrue(isDisplayed(signInPage.getSubmitLogin()));

		sendValues(signInPage.getEmailId(), "clear", "automation@abc.com");

		// email Validation - @ and .com check

		String emailAddressAfterPass = getAttributeValue(signInPage.getEmailId(), "value");
		Assert.assertTrue(emailAddressAfterPass.contains("@") && emailAddressAfterPass.contains(".com"));
	/*	if (emailAddressAfterPass.contains("@") && emailAddressAfterPass.contains(".com")) {
			System.out.println("Email Address is Valid");
		} else {
			System.out.println("Email Address is Not Valid");
		}*/
		sendValues(signInPage.getPassword(), "clear", "1234abc");
		clickIsSelected(signInPage.getSubmitLogin());

	}

	@Test
	public void searchBoxOrder() {
		ApSearchBoxOrder searchbox = new ApSearchBoxOrder();

		Assert.assertTrue(isDisplayed(searchbox.getSearchQuery()));
		Assert.assertTrue(isDisplayed(searchbox.getSubmitSearch()));
		

		// Sending Values to Search Text Box

		sendValues(searchbox.getSearchQuery(), "clear", "blouse");
		clickIsSelected(searchbox.getSubmitSearch());

		// Product is selected
		
		String expectedProductName = "Blouse";
		
		Assert.assertTrue(isDisplayed(searchbox.getSelectedProduct()));
		Assert.assertEquals(expectedProductName, getText(searchbox.getSelectedProduct()).trim());
		clickIsSelected(searchbox.getSelectedProduct());

		ApOrderPage orderPage = new ApOrderPage();

		Assert.assertTrue(isDisplayed(orderPage.getQuantity()));
		Assert.assertTrue(isDisplayed(orderPage.getSizeSelect()));
		Assert.assertTrue(isDisplayed(orderPage.getWhitecolor()));
		Assert.assertTrue(isDisplayed(orderPage.getAddToCart()));
		Assert.assertTrue(isDisplayed(orderPage.getProceedCheckOut()));

		clickIsSelected(orderPage.getQuantity(), "check");
		selectBy(orderPage.getSizeSelect(), "value", "2");
		clickIsSelected(orderPage.getWhitecolor());
		
		actionMethods(driver, orderPage.getAddToCart(), "click");
		clickIsSelected(orderPage.getProceedCheckOut());

		// Product Order Summary Page

		ApSummaryPage summaryPage = new ApSummaryPage();

		// Product Total Validation
		
		Assert.assertTrue(isDisplayed(summaryPage.getProductUnitPrice()));
		Assert.assertTrue(isDisplayed(summaryPage.getProductQuantity()));
		Assert.assertTrue(isDisplayed(summaryPage.getProductTotal()));
		Assert.assertTrue(isDisplayed(summaryPage.getSummaryPageProductName()));

		String productUnitPriceStr = getText(summaryPage.getProductUnitPrice()).trim().substring(1);
		String productQuantityStr = getAttributeValue(summaryPage.getProductQuantity(), "value");
		String productTotalStr = getText(summaryPage.getProductTotal()).trim().substring(1);
		
		Assert.assertEquals(expectedProductName, summaryPage.getSummaryPageProductName());

		// Convert String into Int and Float

		float price = Float.parseFloat(productUnitPriceStr);
		float totalPrice = Float.parseFloat(productTotalStr);
		int productQuantityInt = Integer.parseInt(productQuantityStr);

		// Product Total Check

		float productTotalPrice = price * productQuantityInt;
		Float productTotalPriceFloat = new Float(productTotalPrice);
		Float totalPriceFloat = new Float(totalPrice);
		Assert.assertEquals(totalPriceFloat, productTotalPriceFloat, 0.0f);
		/*if (productTotalPriceFloat.equals(totalPriceFloat)) {
			System.out.println("Product Total Price are same");
		} else {
			System.out.println("Product Total Price are not same");
		}*/

		Assert.assertTrue(isDisplayed(summaryPage.getProceedCheckOutBtn()));
		clickIsSelected(summaryPage.getProceedCheckOutBtn());

		// Product Order - Address Page

		ApAddressPage addressPage = new ApAddressPage();

		Set<String> deliveryAddress = new HashSet<String>();
		Set<String> invoiceAddress = new HashSet<String>();

		// Delivery Address

		deliveryAddress.add(getText(addressPage.getDeliveryAddressName()).trim());
		deliveryAddress.add(getText(addressPage.getDeliveryAddressCompany()).trim());
		deliveryAddress.add(getText(addressPage.getDeliveryAddressLine1()).trim());
		deliveryAddress.add(getText(addressPage.getDeliveryAddressCity()).trim());
		deliveryAddress.add(getText(addressPage.getDeliveryAddressCountry()).trim());
		deliveryAddress.add(getText(addressPage.getDeliveryAddressPhone()).trim());
		deliveryAddress.add(getText(addressPage.getDeliveryAddressMobilePhone()).trim());

		// Invoice Address

		invoiceAddress.add(getText(addressPage.getInvoiceAddressName()).trim());
		invoiceAddress.add(getText(addressPage.getInvoiceAddressCompany()).trim());
		invoiceAddress.add(getText(addressPage.getInvoiceAddressLine1()).trim());
		invoiceAddress.add(getText(addressPage.getInvoiceAddressCity()).trim());
		invoiceAddress.add(getText(addressPage.getInvoiceAddressCountry()).trim());
		invoiceAddress.add(getText(addressPage.getInvoiceAddressPhone()).trim());
		invoiceAddress.add(getText(addressPage.getInvoiceAddressMobilePhone()).trim());
		
		// Compare Two Sets
		
		Assert.assertTrue(deliveryAddress.containsAll(invoiceAddress));
		Assert.assertTrue(isDisplayed(addressPage.getAddressCheckOut()));
		clickIsSelected(addressPage.getAddressCheckOut());

		// Product Order - Shipping Page

		ApShippingPage shippingPage = new ApShippingPage();
		Assert.assertTrue(isDisplayed(shippingPage.getAgreeCheckBox()));
		Assert.assertTrue(isDisplayed(shippingPage.getShippingCheckOut()));
		clickIsSelected(shippingPage.getAgreeCheckBox());
		clickIsSelected(shippingPage.getShippingCheckOut());

		// Product Order - Payment Page

		ApPaymentPage paymentPage = new ApPaymentPage();
		Assert.assertTrue(isDisplayed(paymentPage.getPayment()));
		clickIsSelected(paymentPage.getPayment());

		// Product Order - Confirm Payment

		ApConfirmOrderPage confirmOrderPage = new ApConfirmOrderPage();
		Assert.assertTrue(isDisplayed(confirmOrderPage.getConfirmPayment()));
		clickIsSelected(confirmOrderPage.getConfirmPayment());
	}
	
	@Test
	public void menuItemOrder() {

		// Order Placement

		ApOrderPage orderPage = new ApOrderPage();
		
		Assert.assertTrue(isDisplayed(orderPage.getWomenMenu1()));
		Assert.assertTrue(isDisplayed(orderPage.getTopsSubMenu()));

		actionMethods(driver, orderPage.getWomenMenu1(), "mouse hover");
		actionMethods(driver, orderPage.getTopsSubMenu(), "click");

		// Product Selection
		
		Assert.assertTrue(isDisplayed(orderPage.getProductSelect()));
		Assert.assertTrue(isDisplayed(orderPage.getProductSelect()));

		actionMethods(driver, orderPage.getProductSelect(), "mouse hover");
		actionMethods(driver, orderPage.getProductSelect(), "click");

		// Pass the Values
		
		Assert.assertTrue(isDisplayed(orderPage.getQuantity()));
		Assert.assertTrue(isDisplayed(orderPage.getSizeSelect()));
		Assert.assertTrue(isDisplayed(orderPage.getColor()));
		Assert.assertTrue(isDisplayed(orderPage.getAddToCart()));

		clickIsSelected(orderPage.getQuantity(), "check");
		selectBy(orderPage.getSizeSelect(), "value", "2");
		clickIsSelected(orderPage.getColor());

		actionMethods(driver, orderPage.getAddToCart(), "click");
		Assert.assertTrue(isDisplayed(orderPage.getProceedCheckOut()));
		clickIsSelected(orderPage.getProceedCheckOut());

		// Product Order Summary Page

		ApSummaryPage summaryPage = new ApSummaryPage();
		Assert.assertTrue(isDisplayed(summaryPage.getProceedCheckOutBtn()));
		clickIsSelected(summaryPage.getProceedCheckOutBtn());

		ApAddressPage addressPage = new ApAddressPage();
		Assert.assertTrue(isDisplayed(addressPage.getAddressCheckOut()));
		clickIsSelected(addressPage.getAddressCheckOut());

		// Product Order - Shipping Page

		ApShippingPage shippingPage = new ApShippingPage();
		Assert.assertTrue(isDisplayed(shippingPage.getAgreeCheckBox()));
		Assert.assertTrue(isDisplayed(shippingPage.getShippingCheckOut()));
		clickIsSelected(shippingPage.getAgreeCheckBox());
		clickIsSelected(shippingPage.getShippingCheckOut());

		// Product Order - Payment Page

		ApPaymentPage paymentPage = new ApPaymentPage();
		Assert.assertTrue(isDisplayed(paymentPage.getPayment()));
		clickIsSelected(paymentPage.getPayment());

		// Product Order - Confirm Payment

		ApConfirmOrderPage confirmOrderPage = new ApConfirmOrderPage();
		Assert.assertTrue(isDisplayed(confirmOrderPage.getConfirmPayment()));
		clickIsSelected(confirmOrderPage.getConfirmPayment());

	}

	@Test @Ignore
	public void quickViewOrder() {

		// Order Placement

		ApOrderPage orderPage = new ApOrderPage();

		actionMethods(driver, orderPage.getWomenMenu1(), "mouse hover");
		actionMethods(driver, orderPage.getEveningDressSubMenu(), "click");

		// Product Selection

		actionMethods(driver, orderPage.getProductSelect2(), "mouse hover");
		actionMethods(driver, orderPage.getProductQuickView(), "click");

		// Pass the Values

		clickIsSelected(orderPage.getQuantity(), "check");
		selectBy(orderPage.getSizeSelect(), "value", "2");
		clickIsSelected(orderPage.getPinkcolor());

		actionMethods(driver, orderPage.getAddToCart(), "click");
		clickIsSelected(orderPage.getProceedCheckOut());

		// Product Order Summary Page

		ApSummaryPage summaryPage = new ApSummaryPage();
		clickIsSelected(summaryPage.getProceedCheckOutBtn());

		ApAddressPage addressPage = new ApAddressPage();
		clickIsSelected(addressPage.getAddressCheckOut());

		// Product Order - Shipping Page

		ApShippingPage shippingPage = new ApShippingPage();
		clickIsSelected(shippingPage.getAgreeCheckBox());
		clickIsSelected(shippingPage.getShippingCheckOut());

		// Product Order - Payment Page

		ApPaymentPage paymentPage = new ApPaymentPage();
		clickIsSelected(paymentPage.getPayment());

		// Product Order - Confirm Payment

		ApConfirmOrderPage confirmOrderPage = new ApConfirmOrderPage();
		clickIsSelected(confirmOrderPage.getConfirmPayment());

	}

	@After
	public void ApSignOut() {

		// Sign Out Click Item
		ApSignOutPage signOutPage = new ApSignOutPage();
		clickIsSelected(signOutPage.getSignOut1());
	}

	@AfterClass
	public static void driverQuit() {
		driver.quit();

	}
}
