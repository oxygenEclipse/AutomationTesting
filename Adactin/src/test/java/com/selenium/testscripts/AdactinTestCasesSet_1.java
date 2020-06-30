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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.pom.AdactinLoginPage;
import com.selenium.pom.AdactinLogoutPage;
import com.selenium.pom.AdactinSearchHotelPage;
import com.selenium.pom.AdactinSelectHotelPage;

public class AdactinTestCasesSet_1 extends com.selenium.baseclass.BaseClass {
	public static WebDriver driver;

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
	public void adactinHotelSearchLocationCheck() throws IOException {
		// TC-104 - To verify whether locations in Select Hotel page are displayed
		// according to the location selected in Search Hotel
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		Select selectByLocation = selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
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

		// Get the selected Hotel Location
		WebElement searchLocation = selectByLocation.getFirstSelectedOption();
		String searchLocationText = searchLocation.getText();

		// Screenshot of the output
		takeScreenShot("TC-104_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		String selectHotelLocation = getAttributeValue(selectHotelPage.getHotelLocationplace1(), "value");
		Assert.assertEquals(searchLocationText, selectHotelLocation);

		// Screenshot of the output
		takeScreenShot("TC-104_2", driver);
	}

	@Test
	public void adactinHotelCheckInOutDatesCheck() throws IOException {
		// TC-105 - To verify whether locations in Select Hotel page are displayed
		// according to the location selected in Search Hotel
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
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

		// Screenshot of the output
		takeScreenShot("TC-105_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		String arrivalDate = getAttributeValue(selectHotelPage.getArrivalDate(), "value");
		String departureDate = getAttributeValue(selectHotelPage.getDepartureDate(), "value");

		// Check for the Check-In Date and Check-Out Date
		Assert.assertEquals(checkInDateStr, arrivalDate);
		Assert.assertEquals(checkOutDateStr, departureDate);

		// Screenshot of the output
		takeScreenShot("TC-105_2", driver);
	}

	@Test
	public void adactinHotelSearchCheckLaterDates() throws IOException {
		// TC-102 - To verify whether the check-out date field accepts a later date than
		// checkin date.
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		selectBy(searchHotel.getRoomNos(), "value", "1");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now().plusDays(7);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().plusDays(5);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);
		selectBy(searchHotel.getAdultsPerRoom(), "value", "1");

		// Screenshot of the output
		takeScreenShot("TC-102", driver);
		clickIsSelected(searchHotel.getSearchHotel());

	}

	@Test
	public void adactinHotelSearchCheckBeforeDates() throws IOException {
		// TC-103 - To check if error is reported if check-out date field is in the past
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		selectBy(searchHotel.getRoomNos(), "value", "1");

		// To get CheckIn Date

		LocalDate checkInDate = LocalDate.now().minusDays(5);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String checkInDateStr = checkInDate.format(format);

		// To get CheckOut Date

		LocalDate checkOutDate = LocalDate.now().minusDays(3);
		String checkOutDateStr = checkOutDate.format(format);

		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);

		// Screenshot of the output
		takeScreenShot("TC-103", driver);

		clickIsSelected(searchHotel.getSearchHotel());

	}

	@Test
	public void adactinHotelNoOfRooms() throws IOException {
		// TC-106 - To verify whether no. of rooms entry in Select Hotel page is same as
		// the Number of rooms selected in search hotel page
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();

		// Pass the Test Data
		selectBy(searchHotel.getLocation(), "value", "Sydney");
		selectBy(searchHotel.getHotels(), "value", "Hotel Creek");
		selectBy(searchHotel.getRoomType(), "value", "Standard");
		Select selectByNoOfRooms = selectBy(searchHotel.getRoomNos(), "value", "3");

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
		WebElement searchNoOfRooms = selectByNoOfRooms.getFirstSelectedOption();
		String searchNoOfRoomsText = searchNoOfRooms.getText().substring(0, 1);

		// Screenshot of the output
		takeScreenShot("TC-106_1", driver);

		clickIsSelected(searchHotel.getSearchHotel());

		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();

		String noOfRooms = getAttributeValue(selectHotelPage.getNoOfRooms(), "value").substring(0, 1);

		// Check for the No: of Rooms in Search Page and Select Page
		Assert.assertEquals(searchNoOfRoomsText, noOfRooms);

		// Screenshot of the output
		takeScreenShot("TC-106_2", driver);
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
