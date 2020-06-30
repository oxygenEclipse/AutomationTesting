package com.adactin.stepdefinition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.adactin.functionallibrary.BaseClass;
import com.adactin.pom.AdactinBookHotelPage;
import com.adactin.pom.AdactinLoginPage;
import com.adactin.pom.AdactinSearchHotelPage;
import com.adactin.pom.AdactinSelectHotelPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver;
	public String searchLocationText;
	public String checkInDateStr = "", checkOutDateStr = "";
	public String searchNoOfRoomsText, searchRoomTypeText, searchHotelText;

	@Given("^User launches the browser and hit the Adactin application$")
	public void user_launches_the_browser_and_hit_the_Adactin_application() throws Throwable {
		driver = browserLaunch("chrome");
		driver.get("http://adactin.com/HotelApp/index.php");
	}

	@Then("^User verifies whether the Home Page is displayed$")
	public void user_verifies_whether_the_Home_Page_is_displayed() throws Throwable {
		AdactinLoginPage loginPage = new AdactinLoginPage();
		Assert.assertTrue(isDisplayed(loginPage.getLogo()));
		Assert.assertTrue(isDisplayed(loginPage.getUserName()));
		Assert.assertTrue(isDisplayed(loginPage.getPassword()));
		Assert.assertTrue(isDisplayed(loginPage.getLoginButton()));
	}

	@When("^User enters the \"([^\"]*)\" as username and \"([^\"]*)\" as password$")
	public void user_enters_the_as_username_and_as_password(String arg1, String arg2) throws Throwable {
		AdactinLoginPage loginPage = new AdactinLoginPage();
		sendValues(loginPage.getUserName(), "clear", "banusathish23");
		sendValues(loginPage.getPassword(), "clear", "1234abc");
	}

	@When("^User clicks on the Login button in the Home Page$")
	public void user_clicks_on_the_Login_button_in_the_Home_Page() throws Throwable {
		AdactinLoginPage loginPage = new AdactinLoginPage();
		clickIsSelected(loginPage.getLoginButton());
	}

	@Then("^User verifies whether Login is successful$")
	public void user_verifies_whether_Login_is_successful() throws Throwable {
		Assert.assertEquals(PageTitle(driver), "AdactIn.com - Search Hotel");
	}

	@When("^User selects location as \"([^\"]*)\"$")
	public void user_selects_location_as(String location) throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		Select selectByLocation = selectBy(searchHotel.getLocation(), "value", location);
		WebElement searchLocation = selectByLocation.getFirstSelectedOption();
		searchLocationText = searchLocation.getText();
	}

	@When("^User selects hotel as \"([^\"]*)\"$")
	public void user_selects_hotel_as(String hotelName) throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		Select selectByHotel = selectBy(searchHotel.getHotels(), "value", hotelName);
		// Get the selected Hotel Name
		WebElement searchHotelName = selectByHotel.getFirstSelectedOption();
		searchHotelText = searchHotelName.getText();
	}

	@When("^User selects room type as \"([^\"]*)\"$")
	public void user_selects_room_type_as(String roomType) throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		Select selectByRoomType = selectBy(searchHotel.getRoomType(), "value", roomType);
		// Get the selected Room Type
		WebElement searchRoomType = selectByRoomType.getFirstSelectedOption();
		searchRoomTypeText = searchRoomType.getText();
	}

	@When("^User selects no-of-rooms as \"([^\"]*)\"$")
	public void user_selects_no_of_rooms_as(String roomNos) throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		Select selectByNoOfRooms = selectBy(searchHotel.getRoomNos(), "value", roomNos);
		// Get the selected No of Rooms
		WebElement searchNoOfRooms = selectByNoOfRooms.getFirstSelectedOption();
		searchNoOfRoomsText = searchNoOfRooms.getText().substring(0, 1);
	}

	@When("^User enters \"([^\"]*)\" later than \"([^\"]*)\"$")
	public void user_enters_later_than(String checkInDateInput, String checkOutDateInput) throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		if (checkInDateInput.substring(0, 8).equalsIgnoreCase("today + ")) {
			int plusDays1 = Integer.parseInt(checkInDateInput.substring(8, 9));
			LocalDate checkInDate = LocalDate.now().plusDays(plusDays1);
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkInDateStr = checkInDate.format(format1);
		}
		if (checkOutDateInput.substring(0, 8).equalsIgnoreCase("today + ")) {
			int plusDays2 = Integer.parseInt(checkOutDateInput.substring(8, 9));
			LocalDate checkOutDate = LocalDate.now().plusDays(plusDays2);
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkOutDateStr = checkOutDate.format(format2);
		}
		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);
	}

	@When("^User clicks on the search button$")
	public void user_clicks_on_the_search_button() throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		clickIsSelected(searchHotel.getSearchHotel());
	}

	@Then("^User verifies that system gives an error saying check-in-date should not be later than check-out-date$")
	public void user_verifies_that_system_gives_an_error_saying_check_in_date_should_not_be_later_than_check_out_date()
			throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		Assert.assertTrue(isDisplayed(searchHotel.getCheckInMsg()));
		Assert.assertTrue(isDisplayed(searchHotel.getCheckOutMsg()));
		Assert.assertEquals(searchHotel.getCheckInMsg().getText(), "Check-In Date shall be before than Check-Out Date");
		Assert.assertEquals(searchHotel.getCheckOutMsg().getText(), "Check-Out Date shall be after than Check-In Date");
	}

	@When("^User enters \"([^\"]*)\" with before date and \"([^\"]*)\" with before date$")
	public void user_enters_with_before_date_and_with_before_date(String checkInDateInput, String checkOutDateInput)
			throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		if (checkInDateInput.substring(0, 8).equalsIgnoreCase("today - ")) {
			int minusDays1 = Integer.parseInt(checkInDateInput.substring(8, 9));
			LocalDate checkInDate = LocalDate.now().minusDays(minusDays1);
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkInDateStr = checkInDate.format(format1);
		}
		if (checkOutDateInput.substring(0, 8).equalsIgnoreCase("today - ")) {
			int minusDays2 = Integer.parseInt(checkOutDateInput.substring(8, 9));
			LocalDate checkOutDate = LocalDate.now().minusDays(minusDays2);
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkOutDateStr = checkOutDate.format(format2);
		}
		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);
	}

	@Then("^User verifies that system that application throws error message$")
	public void user_verifies_that_system_that_application_throws_error_message() throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		Assert.assertTrue(isDisplayed(searchHotel.getCheckInMsg()));
		Assert.assertEquals(searchHotel.getCheckInMsg().getText(), "Enter Valid dates");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String checkInDateInput, String checkOutDateInput) throws Throwable {
		AdactinSearchHotelPage searchHotel = new AdactinSearchHotelPage();
		if (checkInDateInput.equalsIgnoreCase("today")) {
			LocalDate checkInDate = LocalDate.now();
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkInDateStr = checkInDate.format(format1);
		}
		if (checkOutDateInput.substring(0, 8).equalsIgnoreCase("today + ")) {
			int plusDays2 = Integer.parseInt(checkOutDateInput.substring(8, 9));
			LocalDate checkOutDate = LocalDate.now().plusDays(plusDays2);
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkOutDateStr = checkOutDate.format(format2);
		}
		sendValues(searchHotel.getCheckInDate(), "clear", checkInDateStr);
		sendValues(searchHotel.getCheckOutDate(), "clear", checkOutDateStr);
	}

	@Then("^User verifies Location displayed in Select Hotel Page should be the same as location selected in Search Hotel Page$")
	public void user_verifies_Location_displayed_in_Select_Hotel_Page_should_be_the_same_as_location_selected_in_Search_Hotel_Page()
			throws Throwable {
		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();
		String selectHotelLocation = getAttributeValue(selectHotelPage.getHotelLocationplace1(), "value");
		Assert.assertEquals(searchLocationText, selectHotelLocation);
	}

	@When("^User clicks on search hotel link$")
	public void user_clicks_on_search_hotel_link() throws Throwable {
		AdactinSearchHotelPage searchHotelPage = new AdactinSearchHotelPage();
		clickIsSelected(searchHotelPage.getSearchHotelLink());
	}

	@Then("^User verifies that check-in date and check-out date are the same as selected in Search Hotel$")
	public void user_verifies_that_check_in_date_and_check_out_date_are_the_same_as_selected_in_Search_Hotel()
			throws Throwable {
		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();
		String arrivalDate = getAttributeValue(selectHotelPage.getArrivalDate(), "value");
		String departureDate = getAttributeValue(selectHotelPage.getDepartureDate(), "value");

		// Check for the Check-In Date and Check-Out Date
		Assert.assertEquals(checkInDateStr, arrivalDate);
		Assert.assertEquals(checkOutDateStr, departureDate);
	}

	@Then("^User verifies No-of-rooms should be displayed and match with number of rooms in Search Hotel page$")
	public void user_verifies_No_of_rooms_should_be_displayed_and_match_with_number_of_rooms_in_Search_Hotel_page()
			throws Throwable {
		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();
		String noOfRooms = getAttributeValue(selectHotelPage.getNoOfRooms(), "value").substring(0, 1);
		// Check for the No: of Rooms in Search Page and Select Page
		Assert.assertEquals(searchNoOfRoomsText, noOfRooms);
	}

	@Then("^User verifies room type should be displayed and match with room type in Search Hotel page$")
	public void user_verifies_room_type_should_be_displayed_and_match_with_room_type_in_Search_Hotel_page()
			throws Throwable {
		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();
		String roomType = getAttributeValue(selectHotelPage.getRoomType(), "value");
		// Check for the Room Type in Search Page and Select Page
		Assert.assertEquals(searchRoomTypeText, roomType);
	}

	@When("^User selects the \"([^\"]*)\" displayed in Select Page$")
	public void user_selects_the_displayed_in_Select_Page(String arg1) throws Throwable {
		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();
		Assert.assertEquals(searchHotelText, selectHotelPage.getHotelName());
		clickIsSelected(selectHotelPage.getSelectedHotel());
	}

	@When("^User clicks on the continue button in Select Page$")
	public void user_clicks_on_the_continue_button_in_Select_Page() throws Throwable {
		AdactinSelectHotelPage selectHotelPage = new AdactinSelectHotelPage();
		clickIsSelected(selectHotelPage.getContinueBtn());
	}

	@Then("^User verifies whether total-price \\(excl\\. GST\\) is calculated as per formula$")
	public void user_verifies_whether_total_price_excl_GST_is_calculated_as_per_formula() throws Throwable {
		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();
		// Calculation to Find the Total Price
		Integer noOfDays = Integer.parseInt(getAttributeValue(bookHotel.getHotelNoOfDays(), "value").substring(0, 1));
		Integer noOfRooms = Integer.parseInt(getAttributeValue(bookHotel.getHotelNoOfRooms(), "value").substring(0, 1));
		Float pricePerNight = Float
				.parseFloat(getAttributeValue(bookHotel.getHotelPricePerNight(), "value").substring(6));
		Float totalPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelTotalPrice(), "value").substring(6));
		Float actualTotalPrice = noOfDays * noOfRooms * pricePerNight;
		Assert.assertEquals(totalPrice, actualTotalPrice);
	}

	@Then("^User verifies whether total-price is calculated as \\(price-pernight\\* no-ofrooms\\* no-of-days \\+ (\\d+)% GST”\\)$")
	public void user_verifies_whether_total_price_is_calculated_as_price_pernight_no_ofrooms_no_of_days_GST(int arg1)
			throws Throwable {
		AdactinBookHotelPage bookHotel = new AdactinBookHotelPage();

		// Calculation to Find the Final Price

		Integer noOfDays = Integer.parseInt(getAttributeValue(bookHotel.getHotelNoOfDays(), "value").substring(0, 1));
		Integer noOfRooms = Integer.parseInt(getAttributeValue(bookHotel.getHotelNoOfRooms(), "value").substring(0, 1));
		Float pricePerNight = Float
				.parseFloat(getAttributeValue(bookHotel.getHotelPricePerNight(), "value").substring(6));
		Float finalPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelFinalPrice(), "value").substring(6));
		Float gstPrice = Float.parseFloat(getAttributeValue(bookHotel.getHotelGSTPrice(), "value").substring(6));
		Float actualTotalPrice = noOfDays * noOfRooms * pricePerNight;
		Float calculatedGst = (actualTotalPrice * 10) / 100;
		Float actualFinalPrice = (noOfDays * noOfRooms * pricePerNight) + calculatedGst;
		Assert.assertEquals(calculatedGst, gstPrice);
	}
}
