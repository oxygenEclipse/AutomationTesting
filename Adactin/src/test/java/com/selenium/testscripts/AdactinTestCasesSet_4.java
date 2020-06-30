package com.selenium.testscripts;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.selenium.baseclass.BaseClass;
import com.selenium.pom.AdactinBookHotelPage;
import com.selenium.pom.AdactinBookingConfirmPage;
import com.selenium.pom.AdactinLoginPage;
import com.selenium.pom.AdactinLogoutPage;
import com.selenium.pom.AdactinMyItineraryPage;
import com.selenium.pom.AdactinSearchHotelPage;
import com.selenium.pom.AdactinSelectHotelPage;

public class AdactinTestCasesSet_4 extends BaseClass {

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
	public void adactinBookItineraryAndBookingCheck() throws IOException {
		// TC-116 - To check whether the booked itinerary reflects the correct
		// information in line with the booking.

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
		String arrivalDate = getAttributeValue(searchHotel.getCheckInDate(), "value");
		String departureDate = getAttributeValue(searchHotel.getCheckOutDate(), "value");

		// Screenshot of the output
		takeScreenShot("TC-116_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-116_2", driver);

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

		List<String> bookingInfo = new ArrayList<String>();
		bookingInfo.add(getAttributeValue(bookHotel.getHotelName(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelLocation(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelNoOfRooms(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getCustomerFirstName(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getCustomerLastName(), "value"));
		bookingInfo.add(arrivalDate);
		bookingInfo.add(departureDate);
		bookingInfo.add(getAttributeValue(bookHotel.getHotelNoOfDays(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelRoomType(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelPricePerNight(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelFinalPrice(), "value"));

		// Screenshot of the output
		takeScreenShot("TC-116_3", driver);

		clickIsSelected(bookHotel.getBookNowBtn());

		AdactinBookingConfirmPage confirmPage = new AdactinBookingConfirmPage();
		String customerOrderId = getAttributeValue(confirmPage.getCustomerOrderNo(), "value");
		bookingInfo.add(0, customerOrderId);

		clickIsSelected(confirmPage.getMyItinerary());

		AdactinMyItineraryPage myItineraryPage = new AdactinMyItineraryPage();

		sendValues(myItineraryPage.getOrderIdSearch(), "clear", customerOrderId);
		clickIsSelected(myItineraryPage.getOrderIdSearchBtn());

		List<WebElement> searchOrderResults = myItineraryPage.getSearchOrderResults();
		List<String> myItineraryOrder = new ArrayList<String>();
		for (WebElement order : searchOrderResults) {
			myItineraryOrder.add(getAttributeValue(order, "value"));
		}

		// Need to change the Total Rooms, No: Of Days and Final Price similar to
		// Booking Information.
		bookingInfo.removeAll(myItineraryOrder);
		Assert.assertTrue(bookingInfo.isEmpty());
	}

	@Test
	public void adactinSearchOrderIdCheck() throws IOException {
		// TC-117 - To check whether “search order id” query is working and displaying
		// the relevant details.

		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		clickIsSelected(searchHotel.getBookedItinerary());

		// My Itinerary Page

		AdactinMyItineraryPage myItineraryPage = new AdactinMyItineraryPage();

		sendValues(myItineraryPage.getOrderIdSearch(), "clear", "I0STCP5VB8");

		String expectedOrderId = getAttributeValue(myItineraryPage.getOrderIdSearch(), "value");
		clickIsSelected(myItineraryPage.getOrderIdSearchBtn());

		List<WebElement> searchOrderResults = myItineraryPage.getSearchOrderResults();
		String actualOrderId = null;

		for (WebElement orders : searchOrderResults) {

			if (getAttributeValue(orders, "name").startsWith("order_id_")) {
				actualOrderId = getAttributeValue(orders, "value");
			}
		}
		Assert.assertEquals(expectedOrderId, actualOrderId);

		// Screenshot of the output
		takeScreenShot("TC-117_1", driver);
	}

	@Test
	public void adactinOrderNumberDetailsCheck() throws IOException {
		// TC-118 - Verify that all the details of newly generated order number in
		// booked itinerary page are correct and match with data during booking.

		
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
		String arrivalDate = getAttributeValue(searchHotel.getCheckInDate(), "value");
		String departureDate = getAttributeValue(searchHotel.getCheckOutDate(), "value");

		// Screenshot of the output
		takeScreenShot("TC-118_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-118_2", driver);

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

		List<String> bookingInfo = new ArrayList<String>();
		bookingInfo.add(getAttributeValue(bookHotel.getHotelName(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelLocation(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelNoOfRooms(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getCustomerFirstName(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getCustomerLastName(), "value"));
		bookingInfo.add(arrivalDate);
		bookingInfo.add(departureDate);
		bookingInfo.add(getAttributeValue(bookHotel.getHotelNoOfDays(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelRoomType(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelPricePerNight(), "value"));
		bookingInfo.add(getAttributeValue(bookHotel.getHotelFinalPrice(), "value"));

		// Screenshot of the output
		takeScreenShot("TC-118_3", driver);

		clickIsSelected(bookHotel.getBookNowBtn());

		AdactinBookingConfirmPage confirmPage = new AdactinBookingConfirmPage();
		String customerOrderId = getAttributeValue(confirmPage.getCustomerOrderNo(), "value");
		bookingInfo.add(0, customerOrderId);

		clickIsSelected(confirmPage.getBookItineraryLink());

		AdactinMyItineraryPage myItineraryPage = new AdactinMyItineraryPage();

		sendValues(myItineraryPage.getOrderIdSearch(), "clear", customerOrderId);
		clickIsSelected(myItineraryPage.getOrderIdSearchBtn());

		List<WebElement> searchOrderResults = myItineraryPage.getSearchOrderResults();
		List<String> myItineraryOrder = new ArrayList<String>();
		for (WebElement order : searchOrderResults) {
			myItineraryOrder.add(getAttributeValue(order, "value"));
		}

		// Need to change the Total Rooms, No: Of Days and Final Price similar to
		// Booking Information.
		bookingInfo.removeAll(myItineraryOrder);
		Assert.assertTrue(bookingInfo.isEmpty());


		// Screenshot of the output
		takeScreenShot("TC-118_4", driver);

	}

	@Test
	public void adactinHotelCancelOrderCheck() throws IOException {
		// TC-119 - To verify that the order gets cancelled after click on Cancel order
		// number link

		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		clickIsSelected(searchHotel.getBookedItinerary());

		// My Itinerary Page

		AdactinMyItineraryPage myItineraryPage = new AdactinMyItineraryPage();

		sendValues(myItineraryPage.getOrderIdSearch(), "clear", "83XD1E4WF0");

		String expectedOrderId = getAttributeValue(myItineraryPage.getOrderIdSearch(), "value");
		clickIsSelected(myItineraryPage.getOrderIdSearchBtn());

		// Screenshot of the output
		takeScreenShot("TC-119_1", driver);

		List<WebElement> searchOrderResults = myItineraryPage.getSearchOrderResults();

		for (WebElement orders : searchOrderResults) {
			if (getAttributeValue(orders, "name").startsWith("ids")) {
				clickIsSelected(orders);
			}
		}

		// Screenshot of the output
		takeScreenShot("TC-119_2", driver);

		// clickIsSelected(myItineraryPage.getSelectCancel());
		alerts(myItineraryPage.getSelectCancel(), "confirm alert", "ok");

		// Search again to check whether the order is removed.

		sendValues(myItineraryPage.getOrderIdSearch(), "clear", expectedOrderId);
		clickIsSelected(myItineraryPage.getOrderIdSearchBtn());
		List<WebElement> searchOrderAfterCancel = myItineraryPage.getSearchOrderResults();
		Assert.assertTrue(searchOrderAfterCancel.isEmpty());

		// Screenshot of the output
		takeScreenShot("TC-118_3", driver);

	}

	@Test
	public void adactinHotelPageTitleCheck() throws IOException {
		// TC-120 - To Verify Title of every Page reflects what the page objective
		// is.For example Title of Search Hotel page should have “Search Hotel”

		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		String expectedSearchPageTitle = PageTitle(driver);

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
		takeScreenShot("TC-120_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		String selectHotelPageTitle = PageTitle(driver);

		clickIsSelected(selectHotelPage.getSelectedHotel());

		clickIsSelected(selectHotelPage.getContinueBtn());

		// Screenshot of the output
		takeScreenShot("TC-120_2", driver);

		// Enter the Booking Details and click on Book Now Button

		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();

		String bookHotelPageTitle = PageTitle(driver);

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

		// Screenshot of the output
		takeScreenShot("TC-120_3", driver);

		clickIsSelected(bookHotel.getBookNowBtn());

		AdactinBookingConfirmPage confirmPage = new AdactinBookingConfirmPage();

		String confirmPageTitle = PageTitle(driver);
		clickIsSelected(confirmPage.getMyItinerary());

		String myItineraryPageTitle = PageTitle(driver);

		Assert.assertEquals(expectedSearchPageTitle, "AdactIn.com - Search Hotel");
		Assert.assertEquals(selectHotelPageTitle, "AdactIn.com - Select Hotel");
		Assert.assertEquals(bookHotelPageTitle, "AdactIn.com - Book A Hotel");
		Assert.assertEquals(confirmPageTitle, "AdactIn.com - Book A Hotel");
		Assert.assertEquals(myItineraryPageTitle, "AdactIn.com - Select Hotel");

		// Screenshot of the output
		takeScreenShot("TC-120_4", driver);
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
