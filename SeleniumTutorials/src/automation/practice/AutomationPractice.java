package automation.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPractice extends BaseClass {
	public static void main(String[] args) throws Exception {
		WebDriver driver = browserLaunch("chrome");
		driver.get("http://automationpractice.com/index.php");

		// Home Page - Logo Check
		WebElement logo = driver.findElement(By.xpath("//img[@alt='My Store']"));
		isDisplayed(logo);

		// Home Page - Mobile Number Validation
		WebElement mobileNum = driver.findElement(By.xpath("//strong[text()='0123-456-789']"));
		isDisplayed(mobileNum);
		String mobileNumText = getText(mobileNum);
		if (mobileNumText.equalsIgnoreCase("0123-456-789"))
			System.out.println("Mobile Number Validation Check is true");
		else
			System.out.println("Mobile Number Validation Check is false");

		// Home Page - Contact Us Check
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact us']"));
		isDisplayed(contactUs);

		// Home Page - Sign In Check
		WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		isDisplayed(signIn);

		// Home Page - Search Check
		WebElement searchText = driver.findElement(By.id("search_query_top"));
		isDisplayed(searchText);

		// Home Page - Menus - Women, Dresses, T-Shirts Check
		WebElement womenMenu = driver.findElement(By.xpath("//a[@title='Women' and @class='sf-with-ul']"));
		isDisplayed(womenMenu);

		// Home Page Screenshot AutomationPracticeHomePage.png
		takeScreenShot("Page 1", driver);

		// Click on Sign In Button

		// signIn.click();
		clickIsSelected(signIn);

		/*
		 * WebElement emailId = driver.findElement(By.id("email")); WebElement password
		 * = driver.findElement(By.id("passwd")); WebElement submitLogin =
		 * driver.findElement(By.id("SubmitLogin"));
		 * sendValues(emailId,"clear","automation@abc.com");
		 * sendValues(password,"clear","1234abc"); clickIsSelected(submitLogin);
		 */

		// Check the Authentication Header
		WebElement authenticationHeader = driver.findElement(By.xpath("//h1[text()='Authentication']"));
		isDisplayed(authenticationHeader);

		// Create an Account Header
		WebElement createAccountHeader = driver.findElement(By.xpath("//h3[text()='Create an account']"));
		isDisplayed(createAccountHeader);

		// Already Registered Header
		WebElement alreadyRegisteredHeader = driver.findElement(By.xpath("//h3[text()='Already registered?']"));
		isDisplayed(alreadyRegisteredHeader);

		// Display Page Title
		System.out.println("Login Page Title : " + driver.getTitle());
		Map<String, String> userDetails = new LinkedHashMap<String, String>();
		userDetails.put("User Name1", "automation@abc.com");
		userDetails.put("Password1", "1234abc");
		userDetails.put("User Name2", "automation90@abc.com");
		userDetails.put("Password2", "1234abc");

		// Create an Account
		WebElement emailAddress = driver.findElement(By.id("email_create"));
		sendValues(emailAddress, "clear", userDetails.get("User Name2"));
		String emailAddressAfterPass = emailAddress.getAttribute("value");
		if (emailAddressAfterPass.contains("@") && emailAddressAfterPass.contains(".com")) {
			System.out.println("Email Address is Valid");
		} else {
			System.out.println("Email Address is Not Valid");
		}

		// Click on Create an Account Button
		WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));

		// Home Page Screenshot AutomationPracticeHomePage.png

		scrollUpDown(driver, 200, 200); // ScrollByPixel
		takeScreenShot("Page 2", driver);

		clickIsSelected(createAccountBtn, "check"); // Button click and isSelected Check
		try {
		if (driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).isEnabled()) {
			System.out.println("User Account already Exists");
		} else {
			sendValues(emailAddress, "clear");
		}}
		catch(NoSuchElementException e) {
			System.out.println("No Such Element Exception");
		}

		/*-------------------*/
		/* Registration Form */
		/*-------------------*/

		// Create an Account Header Check
		/*
		 * WebElement createAccountHeader1 =
		 * driver.findElement(By.xpath("//h1[text()='Create an account']"));
		 * isDisplayed(createAccountHeader1);
		 * 
		 * // Create an Registration Form - START // Title WebElement titleRadioBtn =
		 * driver.findElement(By.xpath("//input[@value='2' and @type='radio']"));
		 * clickIsSelected(titleRadioBtn);
		 * 
		 * // First Name WebElement firstName =
		 * driver.findElement(By.id("customer_firstname")); sendValues(firstName,
		 * "clear", "Automation"); String firstNameStr = getAttributeValue(firstName,
		 * "value");
		 * 
		 * // Last Name WebElement lastName =
		 * driver.findElement(By.id("customer_lastname")); sendValues(lastName, "clear",
		 * "Lastname"); String lastNameStr = getAttributeValue(lastName, "value");
		 * 
		 * // Email Address Check - if the Create Account Page email Address is
		 * populated // in Registration Form Page
		 * 
		 * WebElement registeredEmail = driver.findElement(By.id("email")); String
		 * registeredEmailVal = registeredEmail.getAttribute("value"); if
		 * (registeredEmailVal.equals(emailAddressAfterPass)) { System.out.
		 * println("Create an Account Page Email Address and Registeration Form Email Address are same"
		 * ); } else { System.out
		 * .println("Create an Account Page Email Address and Registeration Form Email Address are not same"
		 * ); }
		 * 
		 * // Password WebElement password = driver.findElement(By.id("passwd"));
		 * sendValues(password, "clear", "1234abc");
		 * 
		 * // Date of Birth WebElement days = driver.findElement(By.id("days"));
		 * WebElement months = driver.findElement(By.id("months")); WebElement years =
		 * driver.findElement(By.id("years"));
		 * 
		 * // Selecting the Values for the Date of Birth
		 * 
		 * selectBy(days, "Index", "4"); selectBy(months, "Value", "7"); selectBy(years,
		 * "Value", "2019");
		 * 
		 * // Check Box - Receiving News Letter
		 * 
		 * WebElement signUpNews = driver.findElement(By.id("newsletter")); WebElement
		 * otherNews = driver.findElement(By.id("optin")); clickIsSelected(signUpNews);
		 * clickIsSelected(otherNews);
		 * 
		 * // Check Whether the first name and Last name are populated in Address
		 * Section
		 * 
		 * WebElement addressFirstName = driver.findElement(By.id("firstname")); String
		 * addressFirstNameVal = addressFirstName.getAttribute("value"); if
		 * (addressFirstNameVal.contains(firstNameStr)) { System.out.
		 * println("Your Personal Information and Your Address Section First Name are same "
		 * ); } else { System.out.
		 * println("Your Personal Information and Your Address Section First Name are not same"
		 * ); } WebElement addressLastName = driver.findElement(By.id("lastname"));
		 * String addressLastNameVal = addressLastName.getAttribute("value"); if
		 * (addressLastNameVal.contains(lastNameStr)) { System.out.
		 * println("Your Personal Information and Your Address Section Last Name are same "
		 * ); } else { System.out.
		 * println("Your Personal Information and Your Address Section Last Name are not same"
		 * ); }
		 * 
		 * // Company Name WebElement companyName =
		 * driver.findElement(By.id("company")); sendValues(companyName, "clear",
		 * "ABC Automation Company");
		 * 
		 * // Address Line 1 WebElement addrLine1 =
		 * driver.findElement(By.id("address1")); sendValues(addrLine1, "clear",
		 * "First Lane");
		 * 
		 * // Address Line 2 WebElement addrLine2 =
		 * driver.findElement(By.id("address2")); sendValues(addrLine2, "clear",
		 * "Plot # 15");
		 * 
		 * // City WebElement city = driver.findElement(By.id("city")); sendValues(city,
		 * "clear", "New Jersey");
		 * 
		 * // Select State WebElement state = driver.findElement(By.id("id_state"));
		 * selectBy(state, "Index", "5");
		 * 
		 * // Postal Code WebElement postalCode = driver.findElement(By.id("postcode"));
		 * sendValues(postalCode, "clear", "74502");
		 * 
		 * // Country WebElement country = driver.findElement(By.id("id_country"));
		 * selectBy(country, "Value", "21");
		 * 
		 * // Additional Information WebElement additionalInfo =
		 * driver.findElement(By.id("other")); sendValues(additionalInfo, "clear",
		 * "Landmark : Opposite to City Park");
		 * 
		 * // Phone WebElement phone = driver.findElement(By.id("phone"));
		 * sendValues(phone, "clear", "2445845");
		 * 
		 * // Mobile Phone
		 * 
		 * WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
		 * sendValues(mobilePhone, "clear", "9558348758");
		 * 
		 * // Alias Address WebElement alias = driver.findElement(By.id("alias"));
		 * sendValues(alias, "clear", "My Address");
		 * 
		 * // Register Button
		 * 
		 * WebElement registerBtn = driver.findElement(By.id("submitAccount"));
		 * 
		 * // Registration Page Screenshot
		 * 
		 * takeScreenShot("Page 3", driver);
		 * 
		 * clickIsSelected(registerBtn);
		 * 
		 * // Resgistration COMPLETE
		 * 
		 * // Login Page Check
		 * 
		 * WebElement loginPageName =
		 * driver.findElement(By.xpath("//span[text() ='Automation Lastname']")); String
		 * loginPageNameChk = loginPageName.getText(); if
		 * (loginPageNameChk.contains("Automation Lastname")) {
		 * System.out.println("Login Page First Name and Last Name are Displayed"); }
		 * else {
		 * System.out.println("Login Page First Name and Last Name are not Displayed");
		 * } // Sign Out WebElement signOut =
		 * driver.findElement(By.xpath("//a[@title='Log me out']"));
		 * isDisplayed(signOut);
		 * 
		 * // Locate all the Menus
		 * 
		 * WebElement orderHistory =
		 * driver.findElement(By.xpath("//span[text() ='Order history and details']"));
		 * WebElement creditSlips =
		 * driver.findElement(By.xpath("//span[text() ='My credit slips']")); WebElement
		 * myAddress = driver.findElement(By.xpath("//span[text() ='My addresses']"));
		 * WebElement personalInfo =
		 * driver.findElement(By.xpath("//span[text() ='My personal information']"));
		 * WebElement wishLists =
		 * driver.findElement(By.xpath("//span[text() ='My wishlists']"));
		 * 
		 * // Check all the Menus are displayed
		 * 
		 * isDisplayed(orderHistory); isDisplayed(creditSlips); isDisplayed(myAddress);
		 * isDisplayed(personalInfo); isDisplayed(wishLists);
		 * 
		 * // Screenshot of Sign In Page
		 * 
		 * takeScreenShot("Page 4", driver);
		 * 
		 * // Women Menu Item Selection WebElement womenMenu1 =
		 * driver.findElement(By.xpath("//a[@title='Women']")); actionMethods(driver,
		 * womenMenu1, "mouse hover"); WebElement topsSubMenu =
		 * driver.findElement(By.xpath("//a[@title='Tops']")); actionMethods(driver,
		 * topsSubMenu, "click");
		 * 
		 * // Screenshot of the Tops Menu item
		 * 
		 * takeScreenShot("Page 5", driver);
		 * 
		 * // Scroll Down scrollUpDown(driver, "down");
		 * 
		 * // Product Selection WebElement productSelect = driver.findElement(By.
		 * xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
		 * actionMethods(driver, productSelect, "mouse hover"); actionMethods(driver,
		 * productSelect, "click");
		 * 
		 * // Locate the Quantity, Size and Color
		 * 
		 * WebElement quantity =
		 * driver.findElement(By.xpath("//i[@class='icon-plus']")); WebElement
		 * sizeSelect = driver.findElement(By.id("group_1")); WebElement color =
		 * driver.findElement(By.id("color_14"));
		 * 
		 * // Pass the Values
		 * 
		 * clickIsSelected(quantity, "check"); selectBy(sizeSelect, "value", "2");
		 * clickIsSelected(color);
		 * 
		 * // Add to Cart WebElement addToCart =
		 * driver.findElement(By.xpath("//span[text()='Add to cart']"));
		 * actionMethods(driver, addToCart, "click");
		 * 
		 * // Scroll by Pixel scrollUpDown(driver, 200, 200);
		 * 
		 * // Screenshot of Add To Cart Page takeScreenShot("Page 6", driver);
		 * 
		 * // Proceed to Check Out WebElement proceedCheckOut =
		 * driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]"));
		 * clickIsSelected(proceedCheckOut);
		 * 
		 * // Proceed to Check Out
		 * 
		 * WebElement proceedCheckOutBtn = driver .findElement(By.
		 * xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]"
		 * )); clickIsSelected(proceedCheckOutBtn);
		 * 
		 * // Scroll by Pixel scrollUpDown(driver, 200, 200);
		 * 
		 * // Take Screenshot takeScreenShot("Page 7", driver);
		 * 
		 * // Delivery Address - List WebElement addressList = driver.findElement(By.
		 * cssSelector("div>div>ul[class='address first_item item box']"));
		 * List<WebElement> addressListItems =
		 * addressList.findElements(By.tagName("li")); for (WebElement list1 :
		 * addressListItems) { System.out.println(list1.getText()); }
		 * 
		 * //Invoice Address List WebElement addressList1 = driver.findElement(By.
		 * cssSelector("div>ul[class='address last_item alternate_item box']"));
		 * List<WebElement> addressListItems1 =
		 * addressList1.findElements(By.tagName("li")); for (WebElement list2 :
		 * addressListItems1) { System.out.println(list2.getText()); }
		 * 
		 * // Address Proceed to Check Out
		 * 
		 * WebElement addressCheckOut = driver.findElement(By.name("processAddress"));
		 * clickIsSelected(addressCheckOut);
		 * 
		 * // Scroll by Pixel scrollUpDown(driver, 200, 200);
		 * 
		 * // Take Screenshot takeScreenShot("Page 8", driver);
		 * 
		 * // Shipping Proceed to Check Out WebElement agreeCheckBox =
		 * driver.findElement(By.id("cgv")); clickIsSelected(agreeCheckBox);
		 * 
		 * WebElement shippingCheckOut = driver.findElement(By.name("processCarrier"));
		 * clickIsSelected(shippingCheckOut);
		 * 
		 * // Scroll by Pixel scrollUpDown(driver, 200, 200);
		 * 
		 * // Take Screenshot takeScreenShot("Page 9", driver);
		 * 
		 * // Payments
		 * 
		 * WebElement payment =
		 * driver.findElement(By.xpath("//a[@title=\"Pay by bank wire\"]"));
		 * clickIsSelected(payment);
		 * 
		 * // Scroll by Pixel scrollUpDown(driver, 200, 200);
		 * 
		 * takeScreenShot("Page 10", driver);
		 * 
		 * // Confirm Payment
		 * 
		 * WebElement confirmPayment = driver .findElement(By.
		 * xpath("//button[@class=\"button btn btn-default button-medium\"]"));
		 * clickIsSelected(confirmPayment);
		 * 
		 * // Scroll by Pixel scrollUpDown(driver, 200, 200);
		 * 
		 * // Take ScreenShot takeScreenShot("Page 11", driver);
		 * 
		 * // Sign Out WebElement signOut1 =
		 * driver.findElement(By.xpath("//a[@title=\"Log me out\"]"));
		 * clickIsSelected(signOut1);
		 */

		// Quit
		Thread.sleep(5000);
		driver.quit();
	}
}
