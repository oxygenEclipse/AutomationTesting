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

import com.selenium.baseclass.BaseClass;
import com.selenium.pom.AdactinBookHotelPage;
import com.selenium.pom.AdactinBookingConfirmPage;
import com.selenium.pom.AdactinLoginPage;
import com.selenium.pom.AdactinLogoutPage;
import com.selenium.pom.AdactinSearchHotelPage;
import com.selenium.pom.AdactinSelectHotelPage;

public class AdactinTestCasesSet_3 extends BaseClass {
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
	public void adactinHotelFinalBilledPrice() throws IOException {
		// TC-112 - To check correct Final billed price is Total Price + 10% Total price
		// in Book a Hotel page

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
		takeScreenShot("TC-112_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-112_2", driver);

		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();

		// Calculation to Find the Final Price

		Float finalPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelFinalPrice(), "value").substring(6));

		Float totalPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelTotalPrice(), "value").substring(6));

		Float actualFinalPrice = totalPrice + (totalPrice * 10) / 100;

		Assert.assertEquals(finalPrice, actualFinalPrice);

		// Screenshot of the output
		takeScreenShot("TC-112_3", driver);

	}

	@Test
	public void adactinBookHotelPageCheck() throws IOException {
		// TC-113 - To verify whether the data displayed is same as the selected data in
		// Book hotel page

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
		takeScreenShot("TC-113_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		// Select a Hotel

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		// Screenshot of the output
		takeScreenShot("TC-113_2", driver);

		String hotelName = getAttributeValue(selectHotelPage.getHotelName(), "value");
		String hotelLocation = getAttributeValue(selectHotelPage.getHotelLocationplace1(), "value");
		String noOfRooms = getAttributeValue(selectHotelPage.getNoOfRooms(), "value");
		String roomType = getAttributeValue(selectHotelPage.getRoomType(), "value");

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Enter the Details and Book Now.
		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();
		Assert.assertEquals(hotelName, getAttributeValue(bookHotel.getHotelName(), "value"));
		Assert.assertEquals(hotelLocation, getAttributeValue(bookHotel.getHotelLocation(), "value"));
		Assert.assertEquals(noOfRooms, getAttributeValue(bookHotel.getHotelNoOfRooms(), "value"));
		Assert.assertEquals(roomType, getAttributeValue(bookHotel.getHotelRoomType(), "value"));
		// Screenshot of the output
		takeScreenShot("TC-113_3", driver);
	}

	@Test
	public void adactinOrderNumberCheck() throws IOException {
		// TC-114 - Verify Order number is generated in booking confirmation page

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
		takeScreenShot("TC-114_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-114_2", driver);

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

		clickIsSelected(bookHotel.getBookNowBtn());

		AdactinBookingConfirmPage confirmPage = new AdactinBookingConfirmPage();

		Assert.assertNotNull(getAttributeValue(confirmPage.getCustomerOrderNo(), "value"));

		// Screenshot of the output
		takeScreenShot("TC-114_3", driver);
	}

	@Test
	public void adactinBookItineraryCheck() throws IOException {
		// TC-115 - To verify whether the booked itinerary details are not editable.

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
		takeScreenShot("TC-115_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-115_2", driver);

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

		clickIsSelected(bookHotel.getBookNowBtn());

		AdactinBookingConfirmPage confirmPage = new AdactinBookingConfirmPage();

		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedHotelName(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedHotelLocation(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedTotalRooms(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedHotelRoomType(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedArrivalDate(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedDepartureDate(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedTotalRooms(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedAdultRooms(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedChildrenRooms(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedPricePerNight(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedTotalPrice(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedGST(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getConfirmedFinalPrice(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getCustomerFirstName(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getCustomerLastName(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getCustomerAddress(), "disabled").equals("true"));
		Assert.assertTrue(getAttributeValue(confirmPage.getCustomerOrderNo(), "disabled").equals("true"));
		// Screenshot of the output
		takeScreenShot("TC-115_3", driver);
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
