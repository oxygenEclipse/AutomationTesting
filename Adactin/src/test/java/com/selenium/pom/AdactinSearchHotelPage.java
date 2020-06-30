package com.selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSearchHotelPage extends com.selenium.baseclass.BaseClass {

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement roomNos;

	@FindBy(id = "datepick_in")
	private WebElement checkInDate;

	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;

	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;

	@FindBy(id = "child_room")
	private WebElement childrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement searchHotel;

	@FindBy(id = "Reset")
	private WebElement resetHotelSearch;
	
	@FindBy(xpath="//a[text() = 'Booked Itinerary']")
	private WebElement bookedItinerary;
	
	@FindBy(xpath ="//td[contains(text(),'Search Hotel')]")
	private WebElement searchHotelHeader;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getResetHotelSearch() {
		return resetHotelSearch;
	}

	public AdactinSearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}

	public WebElement getChildrenPerRoom() {
		return childrenPerRoom;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getSearchHotelHeader() {
		return searchHotelHeader;
	}

}
