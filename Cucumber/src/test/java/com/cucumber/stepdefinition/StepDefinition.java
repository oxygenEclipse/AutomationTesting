package com.cucumber.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.funtionallibrary.BaseClass;
import com.cucumber.manager.PageObjectManager;
import com.cucumber.pom.ApAddressPage;
import com.cucumber.pom.ApConfirmOrderPage;
import com.cucumber.pom.ApOrderPage;
import com.cucumber.pom.ApPaymentPage;
import com.cucumber.pom.ApRegistrationFormPage;
import com.cucumber.pom.ApSearchBoxOrder;
import com.cucumber.pom.ApShippingPage;
import com.cucumber.pom.ApSignInCreatePage;
import com.cucumber.pom.ApSignInPage;
import com.cucumber.pom.ApSignOutPage;
import com.cucumber.pom.ApSummaryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver;
	public String productName = "";
	public String userFirstName, userLastName;
	PageObjectManager pageObjectManager;
	ApSignInPage signInPage;
	ApSignInCreatePage signInCreatePage;
	ApSearchBoxOrder searchbox;
	ApOrderPage orderPage;
	ApSummaryPage summaryPage;
	ApAddressPage addressPage;
	ApShippingPage shippingPage;
	ApPaymentPage paymentPage;
	ApConfirmOrderPage confirmOrderPage;
	ApSignOutPage signOutPage;
	ApRegistrationFormPage registerDetails;

/*	@Given("^User launches the browser and hit the Automation Practice application$")
	public void user_launches_the_browser_and_hit_the_Automation_Practice_application() throws Throwable {
		driver = browserLaunch("chrome");
		pageObjectManager = new PageObjectManager(driver);
		orderPage = pageObjectManager.getOrderPage();
		getURL(driver, "http://automationpractice.com/index.php");
	}

	@When("^User clicks on the Sign In in the Home Page$")
	public void user_clicks_on_the_Sign_In_in_the_Home_Page() throws Throwable {
		signInPage = pageObjectManager.getSignInPage();
		signOutPage = pageObjectManager.getSignOutPage();
		Assert.assertTrue(isDisplayed(signInPage.getSignIn()));
		clickIsSelected(signInPage.getSignIn());
	}

	@Then("^User verifies whether the SignIn Page is displayed$")
	public void user_verifies_whether_the_SignIn_Page_is_displayed() throws Throwable {
		signInCreatePage = pageObjectManager.getSignInCreatePage();
		isDisplayed(signInCreatePage.getAuthenticationHeader());
		isDisplayed(signInCreatePage.getAlreadyRegisteredHeader());
		isDisplayed(signInCreatePage.getCreateAccountHeader());
		isDisplayed(signInCreatePage.getEmailAddress());
		isDisplayed(signInCreatePage.getCreateAccountBtn());
	}

	@When("^User enters the \"([^\"]*)\" as username and \"([^\"]*)\" as password$")
	public void user_enters_the_as_username_and_as_password(String username, String password) throws Throwable {
		Assert.assertTrue(isDisplayed(signInPage.getEmailId()));
		Assert.assertTrue(isDisplayed(signInPage.getPassword()));
		sendValues(signInPage.getEmailId(), "clear", username);
		String emailAddressAfterPass = getAttributeValue(signInPage.getEmailId(), "value");
		Assert.assertTrue(emailAddressAfterPass.contains("@") && emailAddressAfterPass.contains(".com"));
		sendValues(signInPage.getPassword(), "clear", password);
	}

	@When("^User clicks on the Sign in button in the Sign In Page$")
	public void user_clicks_on_the_Sign_in_button_in_the_Sign_In_Page() throws Throwable {
		Assert.assertTrue(isDisplayed(signInPage.getSubmitLogin()));
		clickIsSelected(signInPage.getSubmitLogin());
	}

	@Then("^User verifies whether Sign In is successful$")
	public void user_verifies_whether_Sign_In_is_successful() throws Throwable {
		searchbox = pageObjectManager.getSearchbox();
		Assert.assertEquals("My account - My Store", PageTitle(driver));
		Assert.assertTrue(isDisplayed(searchbox.getCustomerName()));
		Assert.assertNotNull(getText(searchbox.getCustomerName()));
	}

	@When("^User enters the \"([^\"]*)\" in search box$")
	public void user_enters_the_in_search_box(String product) throws Throwable {
		Assert.assertTrue(isDisplayed(searchbox.getSearchQuery()));
		Assert.assertTrue(isEnabled(searchbox.getSearchQuery()));
		sendValues(searchbox.getSearchQuery(), "clear", product);
	}

	@When("^User clicks on the Search button in the Search Page$")
	public void user_clicks_on_the_Search_button_in_the_Search_Page() throws Throwable {
		Assert.assertTrue(isDisplayed(searchbox.getSubmitSearch()));
		Assert.assertTrue(isEnabled(searchbox.getSubmitSearch()));
		clickIsSelected(searchbox.getSubmitSearch());
	}

	@Then("^User verifies whether the products are displayed$")
	public void user_verifies_whether_the_products_are_displayed() throws Throwable {
		List<WebElement> productList = orderPage.getProductList();
		Assert.assertFalse(productList.isEmpty());
	}

	@When("^User clicks on any one of the listed product$")
	public void user_clicks_on_any_one_of_the_listed_product() throws Throwable {
		List<WebElement> productList = orderPage.getProductList();
		// Generate a random number with in range
		int randonNumber = ThreadLocalRandom.current().nextInt(0, productList.size());
		// Selecting Random value
		clickIsSelected(productList.get(randonNumber));
	}

	@Then("^User verifies whether the product detail page is displayed$")
	public void user_verifies_whether_the_product_detail_page_is_displayed() throws Throwable {
		productName = orderPage.getDynamicProductName().getText().trim();
		Assert.assertTrue(PageTitle(driver).contains(productName + " - My Store"));
		Assert.assertTrue(isDisplayed(orderPage.getQuantity()));
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOf(orderPage.getSizeSelect()));
		 * Assert.assertTrue(isDisplayed(orderPage.getSizeSelect()));
		 */
/*	}

	@When("^User selects the quantity, size and color$")
	public void user_selects_the_quantity_size_and_color() throws Throwable {
		clickIsSelected(orderPage.getQuantity(), "check");
		selectBy(orderPage.getSizeSelect(), "value", "2");
		List<WebElement> dynamicProductColor = orderPage.getDynamicProductColor();
		// Generate a random number with in range
		int randonNumber = ThreadLocalRandom.current().nextInt(0, dynamicProductColor.size());
		// Selecting Random value
		clickIsSelected(dynamicProductColor.get(randonNumber));
	}

	@When("^User clicks on the Add to cart button$")
	public void user_clicks_on_the_Add_to_cart_button() throws Throwable {
		Assert.assertTrue(isDisplayed(orderPage.getAddToCart()));
		actionMethods(driver, orderPage.getAddToCart(), "click");
	}

	@Then("^User verifies whether the Proceed to cart popup is displayed$")
	public void user_verifies_whether_the_Proceed_to_cart_popup_is_displayed() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(orderPage.getProceedCheckOut()));
		wait.until(ExpectedConditions.visibilityOf(orderPage.getProductNameDisplay()));
		Assert.assertTrue(isDisplayed(orderPage.getProceedCheckOut()));
		Assert.assertEquals(productName, orderPage.getProductNameDisplay().getText().trim());
	}

	@When("^User clicks on the Proceed to checkout button$")
	public void user_clicks_on_the_Proceed_to_checkout_button() throws Throwable {
		Assert.assertTrue(isDisplayed(orderPage.getProceedCheckOut()));
		clickIsSelected(orderPage.getProceedCheckOut());
	}

	@Then("^User verifies whether Summary Page is displayed$")
	public void user_verifies_whether_Summary_Page_is_displayed() throws Throwable {
		Assert.assertTrue(PageTitle(driver).contains("Order - My Store"));
	}

	@Then("^User verifies whether expected Product Name, Unit Price and Total Price are displayed$")
	public void user_verifies_whether_expected_Product_Name_Unit_Price_and_Total_Price_are_displayed()
			throws Throwable {
		summaryPage = pageObjectManager.getSummaryPage();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(isDisplayed(summaryPage.getProductUnitPrice()));
		Assert.assertTrue(isDisplayed(summaryPage.getProductQuantity()));
		Assert.assertTrue(isDisplayed(summaryPage.getProductTotal()));
		wait.until(ExpectedConditions.visibilityOf(summaryPage.getSummaryPageProductName()));
		Assert.assertTrue(isDisplayed(summaryPage.getSummaryPageProductName()));

		String productUnitPriceStr = getText(summaryPage.getProductUnitPrice()).trim().substring(1);
		String productQuantityStr = getAttributeValue(summaryPage.getProductQuantity(), "value");
		String productTotalStr = getText(summaryPage.getProductTotal()).trim().substring(1);

		// Convert String into Int and Float

		float price = Float.parseFloat(productUnitPriceStr);
		float totalPrice = Float.parseFloat(productTotalStr);
		int productQuantityInt = Integer.parseInt(productQuantityStr);

		// Product Total Check

		float productTotalPrice = price * productQuantityInt;
		Float productTotalPriceFloat = new Float(productTotalPrice);
		Float totalPriceFloat = new Float(totalPrice);
		Assert.assertEquals(totalPriceFloat, productTotalPriceFloat, 0.0f);
		Assert.assertTrue(isDisplayed(summaryPage.getProceedCheckOutBtn()));

	}

	@When("^User clicks on the Proceed to checkout button in Summary Page$")
	public void user_clicks_on_the_Proceed_to_checkout_button_in_Summary_Page() throws Throwable {
		Assert.assertTrue(isDisplayed(summaryPage.getProceedCheckOutBtn()));
		clickIsSelected(summaryPage.getProceedCheckOutBtn());
	}

	@Then("^User verifies whether the Address Page is displayed$")
	public void user_verifies_whether_the_Address_Page_is_displayed() throws Throwable {
		Assert.assertTrue(PageTitle(driver).contains("Order - My Store"));
	}

	@Then("^User verifies whether Your Deilvery Address and Your Billing Address are same$")
	public void user_verifies_whether_Your_Deilvery_Address_and_Your_Billing_Address_are_same() throws Throwable {
		addressPage = pageObjectManager.getAddressPage();
		List<WebElement> deliveryAddress = addressPage.getDeliveryAddress();
		List<WebElement> invoiceAddress = addressPage.getInvoiceAddress();
		List<String> deliveryAddressList = new ArrayList<String>();
		List<String> invoiceAddressList = new ArrayList<String>();
		for (int i = 1; i < deliveryAddress.size() - 1; i++) {
			deliveryAddressList.add(deliveryAddress.get(i).getText().trim());
		}
		for (int i = 1; i < invoiceAddress.size() - 1; i++) {
			invoiceAddressList.add(invoiceAddress.get(i).getText().trim());
		}
		Assert.assertTrue(deliveryAddressList.containsAll(invoiceAddressList));
	}

	@When("^User clicks on the Proceed to checkout button in Address Page$")
	public void user_clicks_on_the_Proceed_to_checkout_button_in_Address_Page() throws Throwable {
		Assert.assertTrue(isDisplayed(addressPage.getAddressCheckOut()));
		clickIsSelected(addressPage.getAddressCheckOut());
	}

	@Then("^User verifies whether the Shipping Page is displayed$")
	public void user_verifies_whether_the_Shipping_Page_is_displayed() throws Throwable {
		Assert.assertTrue(PageTitle(driver).contains("Order - My Store"));
	}

	@When("^User clicks the Agree checkbox$")
	public void user_clicks_the_Agree_checkbox() throws Throwable {
		shippingPage = pageObjectManager.getShippingPage();
		clickIsSelected(shippingPage.getAgreeCheckBox());
	}

	@When("^User clicks on the Proceed to Checkout button in Shipping Page$")
	public void user_clicks_on_the_Proceed_to_Checkout_button_in_Shipping_Page() throws Throwable {
		clickIsSelected(shippingPage.getShippingCheckOut());
	}

	@Then("^User verifies whether Payment Page is displayed$")
	public void user_verifies_whether_Payment_Page_is_displayed() throws Throwable {
		Assert.assertTrue(PageTitle(driver).contains("Order - My Store"));
	}

	@When("^User clicks on the Pay by bank wire from the Payment options$")
	public void user_clicks_on_the_Pay_by_bank_wire_from_the_Payment_options() throws Throwable {
		paymentPage = pageObjectManager.getPaymentPage();
		Assert.assertTrue(isDisplayed(paymentPage.getPayment()));
		clickIsSelected(paymentPage.getPayment());
	}

	@Then("^User verifies whether the Bank-Wire Payment Details are displayed$")
	public void user_verifies_whether_the_Bank_Wire_Payment_Details_are_displayed() throws Throwable {
		Assert.assertTrue(PageTitle(driver).contains("My Store"));
	}

	@When("^User clicks on the I confirm my order button$")
	public void user_clicks_on_the_I_confirm_my_order_button() throws Throwable {
		confirmOrderPage = pageObjectManager.getConfirmOrderPage();
		Assert.assertTrue(isDisplayed(confirmOrderPage.getConfirmPayment()));
		clickIsSelected(confirmOrderPage.getConfirmPayment());
	}

	@Then("^User verifies whether the order is complete$")
	public void user_verifies_whether_the_order_is_complete() throws Throwable {
		Assert.assertTrue(PageTitle(driver).contains("Order confirmation - My Store"));
	}

	@When("^User clicks logout button in the application$")
	public void user_clicks_logout_button_in_the_application() throws Throwable {
		Assert.assertTrue(isDisplayed(signOutPage.getSignOut1()));
		clickIsSelected(signOutPage.getSignOut1());
	}

	@Then("^User verifies if the user is logged out of the application$")
	public void user_verifies_if_the_user_is_logged_out_of_the_application() throws Throwable {
		Assert.assertTrue(isDisplayed(signInPage.getSignIn()));
	}

	@Then("^User quits the browser$")
	public void user_quits_the_browser() throws Throwable {
		driver.quit();
	}

	@Then("^User enters the \"([^\"]*)\" to create an account$")
	public void user_enters_the_to_create_an_account(String emailAddr) throws Throwable {
		sendValues(signInCreatePage.getEmailAddress(), emailAddr);
	}

	@Then("^User clicks on create an account button$")
	public void user_clicks_on_create_an_account_button() throws Throwable {
		clickIsSelected(signInCreatePage.getCreateAccountBtn());
	}

	@Then("^User verifies User Registration Page is displayed$")
	public void user_verifies_User_Registration_Page_is_displayed() throws Throwable {
		Assert.assertTrue(isDisplayed(signInCreatePage.getCreateAccountHeader()));
	}

	@When("^User enters the user details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_user_details_as_and(String title, String firstName, String lastName, String eMail,
			String password, String dob) throws Throwable {
		registerDetails = pageObjectManager.getRegisterDetails();
		clickIsSelected(registerDetails.getTitleRadioBtn());
		sendValues(registerDetails.getFirstName(), firstName);
		userFirstName = firstName;
		sendValues(registerDetails.getLastName(), lastName);
		userLastName = lastName;
		sendValues(registerDetails.getPassword(), password);
		// Selecting the Values for the Date of Birth
		String[] dateParts = dob.split("/");
		if (dateParts[1].startsWith("0"))
			dateParts[1] = dateParts[1].substring(1);

		selectBy(registerDetails.getDays(), "Index", dateParts[0]);
		selectBy(registerDetails.getMonths(), "Value", dateParts[1]);
		selectBy(registerDetails.getYears(), "Value", dateParts[2]);
		clickIsSelected(registerDetails.getSignUpNews());
		clickIsSelected(registerDetails.getOtherNews());
	}

	@When("^User enters the address details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_address_details_as_and(String company, String address, String city, String state,
			String postalCode, String country) throws Throwable {
		//ApRegistrationFormPage registerDetails = new ApRegistrationFormPage(driver);
		sendValues(registerDetails.getCompanyName(), "clear", company);
		sendValues(registerDetails.getAddrLine1(), "clear", address);
		sendValues(registerDetails.getCity(), "clear", city);
		selectBy(registerDetails.getState(), "Visible Text", state);
		sendValues(registerDetails.getPostalCode(), "clear", postalCode);
		selectBy(registerDetails.getCountry(), "Visible Text", country);
	}

	@When("^User enters the contact details as \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_contact_details_as_and(String homePhone, String mobilePhone, String addrAlias)
			throws Throwable {
		sendValues(registerDetails.getPhone(), "clear", homePhone);
		sendValues(registerDetails.getMobilePhone(), "clear", mobilePhone);
		sendValues(registerDetails.getAlias(), "clear", addrAlias);
	}

	@When("^User clicks on register button$")
	public void user_clicks_on_register_button() throws Throwable {
		clickIsSelected(registerDetails.getRegisterBtn());
	}

	@Then("^User verifies the user name is displayed on header on successful registration$")
	public void user_verifies_the_user_name_is_displayed_on_header_on_successful_registration() throws Throwable {
		String userName = getText(signInPage.getUserName());
		Assert.assertEquals(userName, userFirstName + " " + userLastName);
	}

	@When("^User clicks on logout button$")
	public void user_clicks_on_logout_button() throws Throwable {
		clickIsSelected(signOutPage.getSignOut1());
	}

	@Then("^User verifies if the user is logout of the application$")
	public void user_verifies_if_the_user_is_logout_of_the_application() throws Throwable {
		Assert.assertTrue(isDisplayed(signOutPage.getSignInPage()));
	}

	@When("^User closes the browser$")
	public void user_closes_the_browser() throws Throwable {
		driver.close();
	}

	@When("^User clicks on Women Blouses from the menu$")
	public void user_clicks_on_Women_Blouses_from_the_menu() throws Throwable {
		actionMethods(driver, orderPage.getWomenMenu1(), "mouse hover");
		actionMethods(driver, orderPage.getBlouses(), "click");
	}

	@Then("^User verifies whether the displayed product is in range mentioned in the page$")
	public void user_verifies_whether_the_displayed_product_is_in_range_mentioned_in_the_page() throws Throwable {
		String priceRange = getText(orderPage.getProductPriceRange());
		actionMethods(driver, orderPage.getBlouseMouseOver(), "mouse hover");
		String[] priceRangeList = priceRange.split("-");
		float lowerPrice = Float.parseFloat(priceRangeList[0].trim().replace("$", ""));
		float higherPrice = Float.parseFloat(priceRangeList[1].trim().replace("$", ""));
		float productPrice = Float.parseFloat(getText(orderPage.getProductPrice()).trim().replace("$", ""));
		int compareLowerPrice = Float.compare(productPrice, lowerPrice);
		int compareHigherPrice = Float.compare(productPrice, higherPrice);
		Assert.assertTrue(((compareLowerPrice > 0 || compareLowerPrice == 0)
				&& (compareHigherPrice < 0 || compareHigherPrice == 0)));
	}*/

}
