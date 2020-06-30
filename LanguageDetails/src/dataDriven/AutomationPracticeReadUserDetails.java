package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPracticeReadUserDetails extends BaseClass {

	public static Map<String, String> getUser(File excelFile, Workbook wb, Sheet sh, int userNum) throws Exception {
		Map<String, String> userData = new HashMap<String, String>();
		String cellValue = null;
		int rowsCount = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Cell cell = sh.getRow(i).getCell(userNum);
			if (cell == null) {
				cell = sh.getRow(i).createCell(userNum);
			}
			if (cell.getCellType().equals(CellType.STRING)) {
				cellValue = cell.getStringCellValue();
			} else if (cell.getCellType().equals(CellType.NUMERIC)) {
				if (DateUtil.isCellDateFormatted(cell)) {
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					cellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					double doubleCellValue = cell.getNumericCellValue();
					long longCellValue = (long) doubleCellValue;
					cellValue = String.valueOf(longCellValue);
				}
			}
			userData.put(sh.getRow(i).getCell(0).getStringCellValue(), cellValue);
			cellValue = "";
		}
		return userData;
	}

	public static void updateUser(File excelFile, Workbook wb, Sheet sh, int userNum, Map<String, String> updateUser)
			throws Exception {
		int rowsCount = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsCount; i++) {
			Cell cell = sh.getRow(i).getCell(userNum);
			if (sh.getRow(i).getCell(0).getStringCellValue().equals("Order Reference Id")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Order Reference Id"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("Amount")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Amount"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("Account Owner")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Account Owner"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("Bank Name")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("Bank Name"));
			} else if (sh.getRow(i).getCell(0).getStringCellValue().equals("User Created")
					&& cell.getCellType().equals(CellType.BLANK)) {
				cell.setCellValue(updateUser.get("User Created"));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		File excelFile = new File("D:\\Automation Practice User Order Details.xlsx");
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		Sheet sh = wb.getSheet("TestUser");
		int userCount = sh.getRow(0).getPhysicalNumberOfCells();
		WebDriver driver = browserLaunch("chrome");
		driver.get("http://automationpractice.com/index.php");
		for (int i = 1; i <= userCount; i++) {
			Map<String, String> user = getUser(excelFile, wb, sh, i);
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

			// Click on Sign In Button
			clickIsSelected(signIn);

			// Check the Authentication Header
			WebElement authenticationHeader = driver.findElement(By.xpath("//h1[text()='Authentication']"));
			isDisplayed(authenticationHeader);

			// Create an Account Header
			WebElement createAccountHeader = driver.findElement(By.xpath("//h3[text()='Create an account']"));
			isDisplayed(createAccountHeader);

			// Already Registered Header
			WebElement alreadyRegisteredHeader = driver.findElement(By.xpath("//h3[text()='Already registered?']"));
			isDisplayed(alreadyRegisteredHeader);
			// Create an Account
			int emailFlag = 1;
			WebElement emailAddress = driver.findElement(By.id("email_create"));
			sendValues(emailAddress, "clear", user.get("Email"));
			String emailAddressAfterPass = emailAddress.getAttribute("value");
			if (emailAddressAfterPass.contains("@") && emailAddressAfterPass.contains(".com")) {
				System.out.println("Email Address is Valid");
			} else {
				emailFlag = 0;
				System.out.println("Email Address is Not Valid");
			}
			if (emailFlag == 0) {
				continue;
			}
			// Click on Create an Account Button
			WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
			clickIsSelected(createAccountBtn, "check"); // Button click and isSelected Check
			if (user.get("User Created").equals("Y")) {
			try {
				if (driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).isEnabled()) {
					System.out.println("User Account already Exists");
					continue;
				}
			} catch (NoSuchElementException e) {
				System.out.println(e);
			}
			}
			/*-------------------*/
			/* Registration Form */
			/*-------------------*/

			// Create an Account Header Check
			WebElement createAccountHeader1 = driver.findElement(By.xpath("//h1[text()='Create an account']"));
			isDisplayed(createAccountHeader1);

			// Create an Registration Form - START
			// Title
			List<WebElement> titleRadioBtns = driver
					.findElements(By.xpath("//label/div/span/input[@name ='id_gender']"));
			for (WebElement title : titleRadioBtns) {
				System.out.println(title.getText().trim());
				if (title.getText().trim().equals(user.get("Title"))) {
					clickIsSelected(title);
				}
			}

			// First Name
			WebElement firstName = driver.findElement(By.id("customer_firstname"));
			sendValues(firstName, "clear", user.get("First Name"));
			String firstNameStr = getAttributeValue(firstName, "value");

			// Last Name
			WebElement lastName = driver.findElement(By.id("customer_lastname"));
			sendValues(lastName, "clear", user.get("Last Name"));
			String lastNameStr = getAttributeValue(lastName, "value");

			// Email Address Check - if the Create Account Page email Address is populated
			// in Registration Form Page

			WebElement registeredEmail = driver.findElement(By.id("email"));
			String registeredEmailVal = registeredEmail.getAttribute("value");
			if (registeredEmailVal.equals(emailAddressAfterPass)) {
				System.out
						.println("Create an Account Page Email Address and Registeration Form Email Address are same");
			} else {
				System.out.println(
						"Create an Account Page Email Address and Registeration Form Email Address are not same");
			}

			// Password
			WebElement password = driver.findElement(By.id("passwd"));
			sendValues(password, "clear", user.get("Password"));

			// Date of Birth
			WebElement days = driver.findElement(By.id("days"));
			WebElement months = driver.findElement(By.id("months"));
			WebElement years = driver.findElement(By.id("years"));

			// Selecting the Values for the Date of Birth
			String[] dateParts = user.get("Date Of Birth").split("/");
			if (dateParts[1].startsWith("0"))
				dateParts[1] = dateParts[1].substring(1);

			selectBy(days, "Index", dateParts[0]);
			selectBy(months, "Value", dateParts[1]);
			selectBy(years, "Value", dateParts[2]);

			// Check Box - Receiving News Letter

			WebElement signUpNews = driver.findElement(By.id("newsletter"));
			WebElement otherNews = driver.findElement(By.id("optin"));
			clickIsSelected(signUpNews);
			clickIsSelected(otherNews);

			// Check Whether the first name and Last name are populated in Address Section

			WebElement addressFirstName = driver.findElement(By.id("firstname"));
			String addressFirstNameVal = addressFirstName.getAttribute("value");
			if (addressFirstNameVal.contains(firstNameStr)) {
				System.out.println("Your Personal Information and Your Address Section First Name are same ");
			} else {
				System.out.println("Your Personal Information and Your Address Section First Name are not same");
			}
			WebElement addressLastName = driver.findElement(By.id("lastname"));
			String addressLastNameVal = addressLastName.getAttribute("value");
			if (addressLastNameVal.contains(lastNameStr)) {
				System.out.println("Your Personal Information and Your Address Section Last Name are same ");
			} else {
				System.out.println("Your Personal Information and Your Address Section Last Name are not same");
			}

			// Company Name
			WebElement companyName = driver.findElement(By.id("company"));
			sendValues(companyName, "clear", user.get("Company"));

			// Address Line 1
			WebElement addrLine1 = driver.findElement(By.id("address1"));
			sendValues(addrLine1, "clear", user.get("Address"));

			// Address Line 2
			WebElement addrLine2 = driver.findElement(By.id("address2"));
			sendValues(addrLine2, "clear", user.get("Address (Line 2)"));

			// City
			WebElement city = driver.findElement(By.id("city"));
			sendValues(city, "clear", user.get("City"));

			// Select State
			WebElement state = driver.findElement(By.id("id_state"));
			selectBy(state, "Visible Text", user.get("State"));

			// Postal Code
			WebElement postalCode = driver.findElement(By.id("postcode"));
			sendValues(postalCode, "clear", user.get("Zip/Postal Code"));

			// Country
			WebElement country = driver.findElement(By.id("id_country"));
			selectBy(country, "Visible Text", user.get("Country"));

			// Additional Information
			WebElement additionalInfo = driver.findElement(By.id("other"));
			sendValues(additionalInfo, "clear", user.get("Additional Information"));

			// Phone
			WebElement phone = driver.findElement(By.id("phone"));
			sendValues(phone, "clear", user.get("Home Phone"));

			// Mobile Phone

			WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
			sendValues(mobilePhone, "clear", user.get("Mobile Phone"));

			// Alias Address
			WebElement alias = driver.findElement(By.id("alias"));
			sendValues(alias, "clear", user.get("Address Alias"));

			// Register Button

			WebElement registerBtn = driver.findElement(By.id("submitAccount"));
			clickIsSelected(registerBtn);
			user.replace("User Created", "Y");
			// Women Menu Item Selection
			WebElement womenMenu1 = driver.findElement(By.xpath("//a[@title='Women']"));
			actionMethods(driver, womenMenu1, "mouse hover");
			WebElement topsSubMenu = driver.findElement(By.xpath("//a[@title='Tops']"));
			actionMethods(driver, topsSubMenu, "click");
			WebElement productSelect = driver
					.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
			actionMethods(driver, productSelect, "mouse hover");
			actionMethods(driver, productSelect, "click");

			// Locate the Quantity, Size and Color

			WebElement quantity = driver.findElement(By.xpath("//i[@class='icon-plus']"));
			WebElement sizeSelect = driver.findElement(By.id("group_1"));
			WebElement color = driver.findElement(By.id("color_14"));

			// Pass the Values

			clickIsSelected(quantity, "check");
			selectBy(sizeSelect, "value", "2");
			clickIsSelected(color);

			// Add to Cart
			WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
			actionMethods(driver, addToCart, "click");

			// Proceed to Check Out
			WebElement proceedCheckOut = driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]"));
			clickIsSelected(proceedCheckOut);

			// Proceed to Check Out

			WebElement proceedCheckOutBtn = driver
					.findElement(By.xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]"));
			clickIsSelected(proceedCheckOutBtn);
			// Address Proceed to Check Out

			WebElement addressCheckOut = driver.findElement(By.name("processAddress"));
			clickIsSelected(addressCheckOut);
			// Shipping Proceed to Check Out
			WebElement agreeCheckBox = driver.findElement(By.id("cgv"));
			clickIsSelected(agreeCheckBox);

			WebElement shippingCheckOut = driver.findElement(By.name("processCarrier"));
			clickIsSelected(shippingCheckOut);

			// Payments

			WebElement payment = driver.findElement(By.xpath("//a[@title=\"Pay by bank wire\"]"));
			clickIsSelected(payment);

			WebElement confirmPayment = driver
					.findElement(By.xpath("//button[@class=\"button btn btn-default button-medium\"]"));
			clickIsSelected(confirmPayment);

			WebElement amount = driver.findElement(By.xpath("//span[@class='price']/strong"));
			WebElement accountOwner = driver.findElement(By.xpath("//strong[contains(text(),'Pradeep')]"));
			WebElement bankName = driver.findElement(By.xpath("//strong[contains(text(),'RTP')]"));
			WebElement orderId = driver.findElement(By.xpath("//div[@class='box']"));
			String orderID = null;
			for (String text : orderId.getText().split("-")) {
				if (text.contains("order reference")) {
					orderID = text.substring(46, 56);
				}
			}
			user.replace("Amount", amount.getText());
			user.replace("Account Owner", accountOwner.getText());
			user.replace("Bank Name", bankName.getText());
			user.replace("Order Reference Id", orderID);
			updateUser(excelFile, wb, sh, i, user);
			// Sign Out
			WebElement signOut1 = driver.findElement(By.xpath("//a[@title=\"Log me out\"]"));
			clickIsSelected(signOut1);
			driver.navigate().to("http://automationpractice.com/index.php");
		}
		FileOutputStream fout = new FileOutputStream(excelFile);
		wb.write(fout);
		wb.close();
		// Quit
		driver.quit();
	}
}
