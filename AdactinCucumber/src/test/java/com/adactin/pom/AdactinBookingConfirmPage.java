package com.adactin.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.functionallibrary.BaseClass;

public class AdactinBookingConfirmPage extends BaseClass {

	@FindBy(id="hotel_name")
	private WebElement confirmedHotelName;
	
	@FindBy(id="location")
	private WebElement confirmedHotelLocation;
	
	@FindBy(id="room_type")
	private WebElement confirmedHotelRoomType;
	
	@FindBy(id="arrival_date")
	private WebElement confirmedArrivalDate;
	
	@FindBy(id="departure_text")
	private WebElement confirmedDepartureDate;
	
	@FindBy(id="total_rooms")
	private WebElement confirmedTotalRooms;
	
	@FindBy(id="adults_room")
	private WebElement confirmedAdultRooms;
	
	@FindBy(id="children_room")
	private WebElement confirmedChildrenRooms;
	
	@FindBy(id="price_night")
	private WebElement confirmedPricePerNight;
	
	@FindBy(id="total_price")
	private WebElement confirmedTotalPrice;
	
	@FindBy(id="gst")
	private WebElement confirmedGST;
	
	@FindBy(id="final_price")
	private WebElement confirmedFinalPrice;
	
	@FindBy(id="first_name")
	private WebElement customerFirstName;
	
	@FindBy(id="last_name")
	private WebElement customerLastName;
	
	@FindBy(id="address")
	private WebElement customerAddress;
	
	@FindBy(id="order_no")
	private WebElement customerOrderNo;
	
	@FindBy(id="search_hotel")
	private WebElement searchHotel;
	
	@FindBy(id="my_itinerary")
	private WebElement myItinerary;
	
	@FindBy(id="logout")
	private WebElement logout;
	
	@FindBy(xpath = "//td[contains(text(),'Booking Confirmation')]")
	private WebElement bookingConfirmationHeader;
	
	@FindBy(xpath="//a[contains(text(),'Booked Itinerary')]")
	private WebElement bookItineraryLink;

	public WebElement getConfirmedHotelName() {
		return confirmedHotelName;
	}

	public WebElement getConfirmedHotelLocation() {
		return confirmedHotelLocation;
	}

	public WebElement getConfirmedHotelRoomType() {
		return confirmedHotelRoomType;
	}

	public WebElement getConfirmedArrivalDate() {
		return confirmedArrivalDate;
	}

	public WebElement getConfirmedDepartureDate() {
		return confirmedDepartureDate;
	}

	public WebElement getConfirmedTotalRooms() {
		return confirmedTotalRooms;
	}

	public WebElement getConfirmedAdultRooms() {
		return confirmedAdultRooms;
	}

	public WebElement getConfirmedChildrenRooms() {
		return confirmedChildrenRooms;
	}

	public WebElement getConfirmedPricePerNight() {
		return confirmedPricePerNight;
	}

	public WebElement getConfirmedTotalPrice() {
		return confirmedTotalPrice;
	}

	public WebElement getConfirmedGST() {
		return confirmedGST;
	}

	public WebElement getConfirmedFinalPrice() {
		return confirmedFinalPrice;
	}

	public WebElement getCustomerFirstName() {
		return customerFirstName;
	}

	public WebElement getCustomerLastName() {
		return customerLastName;
	}

	public WebElement getCustomerAddress() {
		return customerAddress;
	}

	public WebElement getCustomerOrderNo() {
		return customerOrderNo;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getMyItinerary() {
		return myItinerary;
	}

	public WebElement getLogout() {
		return logout;
	}

	public AdactinBookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBookingConfirmationHeader() {
		return bookingConfirmationHeader;
	}

	public WebElement getBookItineraryLink() {
		return bookItineraryLink;
	}
}
