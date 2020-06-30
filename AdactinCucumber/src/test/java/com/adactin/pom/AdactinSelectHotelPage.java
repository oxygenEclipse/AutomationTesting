package com.adactin.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.adactin.functionallibrary.BaseClass;

public class AdactinSelectHotelPage extends BaseClass {

	@FindBys({ @FindBy(xpath = "//input[@value='Melbourne']") })
	private List<WebElement> hotelLocations;

	@FindBy(id = "location_0")
	private WebElement hotelLocationplace1;
	
	@FindBy(id="hotel_name_0")
	private WebElement hotelName;

	@FindBy(id = "arr_date_0")
	private WebElement arrivalDate;

	@FindBy(id = "dep_date_0")
	private WebElement departureDate;

	@FindBy(id = "no_days_0")
	private WebElement noOfDays;

	@FindBy(id = "rooms_0")
	private WebElement noOfRooms;

	@FindBy(id = "room_type_0")
	private WebElement roomType;

	@FindBy(id = "radiobutton_0")
	private WebElement selectedHotel;

	@FindBy(id = "price_night_0")
	private WebElement pricePerNight;

	@FindBy(id = "total_price_0")
	private WebElement totalPrice;

	@FindBy(id = "continue")
	private WebElement continueBtn;
	
	@FindBy(xpath="//td[contains(text(),'Select Hotel')]")
	private WebElement selectHotelHeader;

	public List<WebElement> getHotelLocations() {
		return hotelLocations;
	}

	public WebElement getHotelLocationplace1() {
		return hotelLocationplace1;
	}

	public AdactinSelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getArrivalDate() {
		return arrivalDate;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public WebElement getNoOfDays() {
		return noOfDays;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getSelectedHotel() {
		return selectedHotel;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getPricePerNight() {
		return pricePerNight;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getHotelName() {
		return hotelName;
	}

	public WebElement getSelectHotelHeader() {
		return selectHotelHeader;
	}
}
