package automation.practice;

import org.openqa.selenium.WebDriver;

public class AutomationPracticePOM extends BaseClass {

	public static void main(String[] args) throws Exception {
		WebDriver driver = browserLaunch("chrome");
		driver.get("http://automationpractice.com/index.php");

		// HomePage WebElement Locators

		ApHomePage homePage = new ApHomePage();

		// My Store, Mobile Number, Contact Us, Sign In
		isDisplayed(homePage.getMyStore());
		isDisplayed(homePage.getMobileNum());
		isDisplayed(homePage.getContactUs());
		isDisplayed(homePage.getSignIn());

		// Home Page Screenshot AutomationPracticeHomePage.png
		takeScreenShot("Page 1", driver);

		clickIsSelected(homePage.getSignIn());

		// Sign In Page

		ApSignInCreatePage signInPage = new ApSignInCreatePage();

		// Authentication Header, Already Registered Header, Create Account Header,
		// Email Address, Create Account Button

		isDisplayed(signInPage.getAuthenticationHeader());
		isDisplayed(signInPage.getAlreadyRegisteredHeader());
		isDisplayed(signInPage.getCreateAccountHeader());
		isDisplayed(signInPage.getEmailAddress());
		isDisplayed(signInPage.getCreateAccountBtn());

		// Create an Account. Pass the email address

		sendValues(signInPage.getEmailAddress(), "clear", "automationabc4@abc.com");

		// Take Screenshot
		scrollUpDown(driver, 200, 200); // ScrollByPixel
		takeScreenShot("Page 2", driver);

		// Click on Create Account Button
		clickIsSelected(signInPage.getCreateAccountBtn(), "check");

		/*****************************************/
		/*********** Registration Form *************/
		/*****************************************/

		ApRegistrationFormPage formPage = new ApRegistrationFormPage();

		isDisplayed(formPage.getCreateAccountHeader1());
		isDisplayed(formPage.getTitleRadioBtn());
		isDisplayed(formPage.getFirstName());
		isDisplayed(formPage.getLastName());
		isDisplayed(formPage.getRegisteredEmail());
		isDisplayed(formPage.getPassword());
		isDisplayed(formPage.getMonths());
		isDisplayed(formPage.getDays());
		isDisplayed(formPage.getYears());
		isDisplayed(formPage.getSignUpNews());
		isDisplayed(formPage.getOtherNews());
		isDisplayed(formPage.getCompanyName());
		isDisplayed(formPage.getAddrLine1());
		isDisplayed(formPage.getAddrLine2());
		isDisplayed(formPage.getCity());
		isDisplayed(formPage.getState());
		isDisplayed(formPage.getPostalCode());
		isDisplayed(formPage.getCountry());
		isDisplayed(formPage.getOther());
		isDisplayed(formPage.getPhone());
		isDisplayed(formPage.getMobilePhone());
		isDisplayed(formPage.getAlias());

		// Send Values to the Registration Form

		clickIsSelected(formPage.getTitleRadioBtn());

		sendValues(formPage.getFirstName(), "clear", "Automation");
		sendValues(formPage.getLastName(), "clear", "Lastname");
		sendValues(formPage.getPassword(), "clear", "1234abc");

		selectBy(formPage.getDays(), "Index", "4");
		selectBy(formPage.getMonths(), "Value", "7");
		selectBy(formPage.getYears(), "Value", "2019");

		clickIsSelected(formPage.getSignUpNews());
		clickIsSelected(formPage.getOtherNews());

		sendValues(formPage.getCompanyName(), "clear", "ABC Automation Company");
		sendValues(formPage.getAddrLine1(), "clear", "First Lane");
		sendValues(formPage.getAddrLine1(), "clear", "Plot # 15");
		sendValues(formPage.getCity(), "clear", "New Jersey");
		selectBy(formPage.getState(), "Index", "5");
		sendValues(formPage.getPostalCode(), "clear", "74502");
		selectBy(formPage.getCountry(), "Value", "21");
		sendValues(formPage.getOther(), "clear", "Landmark : Opposite to City Park");
		sendValues(formPage.getPhone(), "clear", "2445845");
		sendValues(formPage.getMobilePhone(), "clear", "9558348758");
		sendValues(formPage.getAlias(), "clear", "My Address");

		takeScreenShot("Page 3", driver);

		clickIsSelected(formPage.getRegisterBtn());

		// Resgistration COMPLETE

		// Login Page Check

		ApLoginPage loginPage = new ApLoginPage();

		isDisplayed(loginPage.getOrderHistory());
		isDisplayed(loginPage.getCreditSlips());
		isDisplayed(loginPage.getMyAddress());
		isDisplayed(loginPage.getPersonalInfo());
		isDisplayed(loginPage.getWishLists());

		// Screenshot of Sign In Page

		takeScreenShot("Page 4", driver);

		// Order Placement

		ApOrderPage orderPage = new ApOrderPage();

		actionMethods(driver, orderPage.getWomenMenu1(), "mouse hover");
		actionMethods(driver, orderPage.getTopsSubMenu(), "click");

		// Screenshot of the Tops Menu item

		takeScreenShot("Page 5", driver);

		// Scroll Down
		scrollUpDown(driver, "down");

		// Product Selection

		actionMethods(driver, orderPage.getProductSelect(), "mouse hover");
		actionMethods(driver, orderPage.getProductSelect(), "click");

		// Pass the Values

		clickIsSelected(orderPage.getQuantity(), "check");
		selectBy(orderPage.getSizeSelect(), "value", "2");
		clickIsSelected(orderPage.getColor());

		actionMethods(driver, orderPage.getAddToCart(), "click");

		// Scroll by Pixel
		scrollUpDown(driver, 200, 200);

		// Screenshot of Add To Cart Page
		takeScreenShot("Page 6", driver);

		clickIsSelected(orderPage.getProceedCheckOut());

		// Product Order Summary Page

		ApSummaryPage summaryPage = new ApSummaryPage();

		clickIsSelected(summaryPage.getProceedCheckOutBtn());

		// Scroll by Pixel
		scrollUpDown(driver, 200, 200);

		// Take Screenshot
		takeScreenShot("Page 7", driver);

		// Product Order - Address Page

		ApAddressPage addressPage = new ApAddressPage();

		clickIsSelected(addressPage.getAddressCheckOut());

		// Scroll by Pixel
		scrollUpDown(driver, 200, 200);

		// Take Screenshot
		takeScreenShot("Page 8", driver);

		// Product Order - Shipping Page

		ApShippingPage shippingPage = new ApShippingPage();

		clickIsSelected(shippingPage.getAgreeCheckBox());
		clickIsSelected(shippingPage.getShippingCheckOut());

		// Scroll by Pixel
		scrollUpDown(driver, 200, 200);

		// Take Screenshot
		takeScreenShot("Page 9", driver);

		// Product Order - Payment Page

		ApPaymentPage paymentPage = new ApPaymentPage();
		clickIsSelected(paymentPage.getPayment());

		// Scroll by Pixel
		scrollUpDown(driver, 200, 200);

		takeScreenShot("Page 10", driver);
		
		// Product Order - Confirm Payment
		
		ApConfirmOrderPage confirmOrderPage = new ApConfirmOrderPage();
		
		clickIsSelected(confirmOrderPage.getConfirmPayment());

		// Scroll by Pixel
		scrollUpDown(driver, 200, 200);

		// Take ScreenShot
		takeScreenShot("Page 11", driver);
		
		// Sign Out
		
		ApSignOutPage signOutPage = new ApSignOutPage();
		
		clickIsSelected(signOutPage.getSignOut1());
		
		driver.quit();

	}
}
