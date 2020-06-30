package com.selenium.testscripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.baseclass.BaseClass;
import com.selenium.pom.AdactinBookHotelPage;
import com.selenium.pom.AdactinBookingConfirmPage;
import com.selenium.pom.AdactinLoginPage;
import com.selenium.pom.AdactinLogoutPage;
import com.selenium.pom.AdactinSearchHotelPage;
import com.selenium.pom.AdactinSelectHotelPage;

public class AdactinTestCasesSet_2 extends BaseClass {

	@BeforeClass
	public static void driverInitialization() throws Exception {
		driver = browserLaunch("chrome");
		driver.get("http://adactin.com/HotelApp/index.php");
	}

	@Before
	public void adactinLogin() {
		AdactinLoginPage loginPage = new AdactinLoginPage();
		sendValues(loginPage.getUserName(), "clear", "banusathish23");
		sendValues(loginPage.getPassword(), "clear", "1234abc");
		clickIsSelected(loginPage.getLoginButton());
	}

	@Test
	public void adactinHotelRoomType() throws IOException {
		// TC-107 - To verify whether Room Type in Select Hotel page is same as Room
		// type selected in search hotel page
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		Select selectByRoomType = selectBy(searchHotel.getRoomType(), "value", "Deluxe");
		selectBy(searchHotel.getRoomNos(), "value", "1");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().plusDays(1);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);

		// Get the selected No of Rooms
		WebElement searchRoomType = selectByRoomType.getFirstSelectedOption();
		String searchRoomTypeText = searchRoomType.getText();

		// Screenshot of the output
		takeScreenShot("TC-107_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		String roomType = getAttributeValue(selectHotelPage.getRoomType(), "value");

		// Check for the Room Type in Search Page and Select Page
		Assert.assertEquals(searchRoomTypeText, roomType);

		// Screenshot of the output
		takeScreenShot("TC-107_2", driver);
	}

	@Test
	public void adactinHotelTotalPrice() throws IOException {
		// TC-108 - To verify whether the total price (excl.GST) is calculated as “price
		// per night * no. of nights* no of rooms”.
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		selectBy(searchHotel.getRoomNos(), "value", "2");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().plusDays(1);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);

		// Screenshot of the output
		takeScreenShot("TC-108_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		// Calculation to Find the Total Price

		Integer noOfDays = Integer.parseInt(getAttributeValue(selectHotelPage.getNoOfDays(), "value").substring(0, 1));
		Integer noOfRooms = Integer
				.parseInt(getAttributeValue(selectHotelPage.getNoOfRooms(), "value").substring(0, 1));
		Float pricePerNight = Float
				.parseFloat(getAttributeValue(selectHotelPage.getPricePerNight(), "value").substring(6));
		Float totalPrice = Float.parseFloat(getAttributeValue(selectHotelPage.getTotalPrice(), "value").substring(6));

		Float actualTotalPrice = noOfDays * noOfRooms * pricePerNight;

		Assert.assertEquals(totalPrice, actualTotalPrice);

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-108_2", driver);
	}

	@Test
	public void adactinHotelBookDetailLogout() throws IOException {
		// TC-109 - To verify when pressed, logout button logs out from the application.

		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		selectBy(searchHotel.getRoomNos(), "value", "2");
		selectBy(searchHotel.getAdultsPerRoom(), "value", "1");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().plusDays(1);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);

		String adultNoOfRooms = getText(searchHotel.getAdultsPerRoom());
		String childrenNoOfRooms = getText(searchHotel.getChildrenPerRoom());

		// Screenshot of the output
		takeScreenShot("TC-109_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel()); // Select the Radio Button

		String departureDate = getAttributeValue(selectHotelPage.getDepartureDate(), "value");
		String arrivalDate = getAttributeValue(selectHotelPage.getArrivalDate(), "value");

		// Screenshot of the output
		takeScreenShot("TC-109_2", driver);

		clickIsSelected(selectHotelPage.getContinueBtn()); // Click on Continue Button

		// Enter the Booking Details and click on Book Now Button

		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();

		// Pass Test Values

		sendValues(bookHotel.getCustomerFirstName(), "clear", "Rita");
		sendValues(bookHotel.getCustomerLastName(), "clear", "Kumari");
		sendValues(bookHotel.getCustomerAddress(), "clear", "Ap 456, First Street, Orange Lane, Australia 34564");
		sendValues(bookHotel.getCustomerCCNo(), "clear", "4586248796425846");

		// Select the Card Type

		selectBy(bookHotel.getCustomerCCType(), "value", "OTHR");
		selectBy(bookHotel.getCustomerCCExpiryMonth(), "Visible Text", "December");
		selectBy(bookHotel.getCustomerCCExpiryYear(), "value", "2022");

		sendValues(bookHotel.getCustomerCCcvv(), "clear", "875");

		// Store all the Booking Information in Strings to check Later

		String hotelName = getAttributeValue(bookHotel.getHotelName(), "value");
		String hotelLocation = getAttributeValue(bookHotel.getHotelLocation(), "value");
		String noOfRooms = getAttributeValue(bookHotel.getHotelNoOfRooms(), "value");
		// String noOfDays = getAttributeValue(bookHotel.getHotelNoOfDays(), "value");
		String roomType = getAttributeValue(bookHotel.getHotelRoomType(), "value");
		String pricePerNight = getAttributeValue(bookHotel.getHotelPricePerNight(), "value");
		String totalPrice = getAttributeValue(bookHotel.getHotelTotalPrice(), "value");
		String gstPrice = getAttributeValue(bookHotel.getHotelGSTPrice(), "value");
		String totalFinalPrice = getAttributeValue(bookHotel.getHotelFinalPrice(), "value");
		String firstName = getAttributeValue(bookHotel.getCustomerFirstName(), "value");
		String lastName = getAttributeValue(bookHotel.getCustomerLastName(), "value");
		String address = getAttributeValue(bookHotel.getCustomerAddress(), "value");
		// String ccNo = getAttributeValue(bookHotel.getCustomerCCNo(), "value");
		// String ccType = getText(bookHotel.getCustomerCCType());
		// String ccExpiryMonth = getText(bookHotel.getCustomerCCExpiryMonth());
		// String ccExpiryYear = getText(bookHotel.getCustomerCCExpiryYear());
		// String ccCvv = getAttributeValue(bookHotel.getCustomerCCcvv(), "value");

		// Screenshot of the output
		takeScreenShot("TC-109_3", driver);

		clickIsSelected(bookHotel.getBookNowBtn());

		// Booking Confirmation Page - Check - No: Of Days is missing in Confirmation
		// Page

		AdactinBookingConfirmPage confirmPage = new AdactinBookingConfirmPage();

		Assert.assertEquals(hotelName, getAttributeValue(confirmPage.getConfirmedHotelName(), "value"));
		Assert.assertEquals(hotelLocation, getAttributeValue(confirmPage.getConfirmedHotelLocation(), "value"));
		Assert.assertEquals(noOfRooms, getAttributeValue(confirmPage.getConfirmedTotalRooms(), "value"));
		Assert.assertEquals(roomType, getAttributeValue(confirmPage.getConfirmedHotelRoomType(), "value"));
		Assert.assertEquals(arrivalDate, getAttributeValue(confirmPage.getConfirmedArrivalDate(), "value"));
		Assert.assertEquals(departureDate, getAttributeValue(confirmPage.getConfirmedDepartureDate(), "value"));
		Assert.assertEquals(noOfRooms, getAttributeValue(confirmPage.getConfirmedTotalRooms(), "value"));
		Assert.assertEquals(adultNoOfRooms, getAttributeValue(confirmPage.getConfirmedAdultRooms(), "value"));
		Assert.assertEquals(childrenNoOfRooms, getAttributeValue(confirmPage.getConfirmedChildrenRooms(), "value"));
		Assert.assertEquals(pricePerNight, getAttributeValue(confirmPage.getConfirmedPricePerNight(), "value"));
		Assert.assertEquals(totalPrice, getAttributeValue(confirmPage.getConfirmedTotalPrice(), "value"));
		Assert.assertEquals(gstPrice, getAttributeValue(confirmPage.getConfirmedGST(), "value"));
		Assert.assertEquals(totalFinalPrice, getAttributeValue(confirmPage.getConfirmedFinalPrice(), "value"));
		Assert.assertEquals(firstName, getAttributeValue(confirmPage.getCustomerFirstName(), "value"));
		Assert.assertEquals(lastName, getAttributeValue(confirmPage.getCustomerLastName(), "value"));
		Assert.assertEquals(address, getAttributeValue(confirmPage.getCustomerAddress(), "value"));
		

		// Screenshot of the output
		takeScreenShot("TC-109_4", driver);
		// Click on Logout Button

		clickIsSelected(confirmPage.getLogout());

	}

	@Test
	public void adactinBookAHotelTotalPrice() throws IOException {
		// TC-110 - To check correct total price is being calculated as “price per
		// night*no of days*no of rooms in Book a hotel page

		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Melbourne");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		selectBy(searchHotel.getRoomNos(), "value", "2");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().plusDays(1);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);

		// Screenshot of the output
		takeScreenShot("TC-110_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-110_2", driver);

		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();

		// Calculation to Find the Final Price

		Integer noOfDays = Integer.parseInt(getAttributeValue(bookHotel.getHotelNoOfDays(), "value").substring(0, 1));
		Integer noOfRooms = Integer.parseInt(getAttributeValue(bookHotel.getHotelNoOfRooms(), "value").substring(0, 1));
		Float pricePerNight = Float
				.parseFloat(getAttributeValue(bookHotel.getHotelPricePerNight(), "value").substring(6));
		Float finalPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelFinalPrice(), "value").substring(6));

	//	Float totalPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelTotalPrice(), "value").substring(6));

		Float gstPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelGSTPrice(), "value").substring(6));

		Float actualTotalPrice = noOfDays * noOfRooms * pricePerNight;

		Float calculatedGst = (actualTotalPrice * 10) / 100;

		Float actualFinalPrice = (noOfDays * noOfRooms * pricePerNight) + calculatedGst;

		//Assert.assertEquals(totalPrice, actualTotalPrice);
		Assert.assertEquals(calculatedGst, gstPrice);
		Assert.assertEquals(finalPrice, actualFinalPrice);

		// Screenshot of the output
		takeScreenShot("TC-110_3", driver);
	}

	@Test
	public void adactinHotelSelectAndBookDetailCheck() throws IOException {
		// TC-111 - To check Hotel name, Location, room type, Total Day, price per night
		// are same in Booking confirmation page as they were selected in previous
		// screen
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		selectBy(searchHotel.getRoomNos(), "value", "2");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().plusDays(1);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);

		// Screenshot of the output
		takeScreenShot("TC-111_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());
		
         String hotelName = getAttributeValue(selectHotelPage.getHotelName(), "value");
         String hotelLocation = getAttributeValue(selectHotelPage.getHotelLocationplace1(),"value");
         String pricePerNight = getAttributeValue(selectHotelPage.getPricePerNight(),"value");
         
		// Screenshot of the output
		takeScreenShot("TC-111_2", driver);
		clickIsSelected(selectHotelPage.getContinueBtn());

		// Enter the Booking Details and click on Book Now Button

		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();
		Assert.assertEquals(hotelName, getAttributeValue(bookHotel.getHotelName(), "value"));
		Assert.assertEquals(hotelLocation, getAttributeValue(bookHotel.getHotelLocation(), "value"));
		Assert.assertEquals(pricePerNight, getAttributeValue(bookHotel.getHotelPricePerNight(), "value"));
		// Screenshot of the output
		takeScreenShot("TC-111_3", driver);
	}

	@After
	public void adactinLogout() {
		AdactinLogoutPage logoutPage = new AdactinLogoutPage();
		clickIsSelected(logoutPage.getLogout());
		clickIsSelected(logoutPage.getLoginAgain());
	}

	@AfterClass
	public static void driverQuit() {
		driver.quit();
	}
}
