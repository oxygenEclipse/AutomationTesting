package automation.practice;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class AutomationpracticeTest extends BaseClass {

	public static void main(String[] args) throws Exception {
		driver = browserLaunch("chrome");
		driver.get("http://automationpractice.com/index.php");
		ApSignInPage signInPage = new ApSignInPage();
		Assert.assertTrue(isDisplayed(signInPage.getSignIn()));
		clickIsSelected(signInPage.getSignIn());

		sendValues(signInPage.getEmailId(), "clear", "automation@abc.com");
		sendValues(signInPage.getPassword(), "clear", "1234abc");
		clickIsSelected(signInPage.getSubmitLogin());
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
		
		Assert.assertEquals(expectedProductName, summaryPage.getSummaryPageProductName().getText().trim());

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
		Assert.assertTrue(isDisplayed(shippingPage.getShippingCheckOut()));
		actionMethods(driver, shippingPage.getAgreeCheckBox(), "click");
		clickIsSelected(shippingPage.getShippingCheckOut());

		// Product Order - Payment Page

		ApPaymentPage paymentPage = new ApPaymentPage();
		Assert.assertTrue(isDisplayed(paymentPage.getPayment()));
		clickIsSelected(paymentPage.getPayment());

		// Product Order - Confirm Payment

		ApConfirmOrderPage confirmOrderPage = new ApConfirmOrderPage();
		Assert.assertTrue(isDisplayed(confirmOrderPage.getConfirmPayment()));
		clickIsSelected(confirmOrderPage.getConfirmPayment());
		ApSignOutPage signOutPage = new ApSignOutPage();
		clickIsSelected(signOutPage.getSignOut1());
		driver.quit();


	}

}
