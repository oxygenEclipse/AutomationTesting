package com.adactin.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.functionallibrary.BaseClass;

public class AdactinBookHotelPage extends BaseClass {

	@FindBy(id = "hotel_name_dis")
	private WebElement hotelName;

	@FindBy(id = "location_dis")
	private WebElement hotelLocation;

	@FindBy(id = "room_type_dis")
	private WebElement hotelRoomType;

	@FindBy(id = "room_num_dis")
	private WebElement hotelNoOfRooms;

	@FindBy(id = "total_days_dis")
	private WebElement hotelNoOfDays;

	@FindBy(id = "price_night_dis")
	private WebElement hotelPricePerNight;

	@FindBy(id = "total_price_dis")
	private WebElement hotelTotalPrice;

	@FindBy(id = "gst_dis")
	private WebElement hotelGSTPrice;

	@FindBy(id = "final_price_dis")
	private WebElement hotelFinalPrice;

	@FindBy(id = "first_name")
	private WebElement customerFirstName;

	@FindBy(id = "last_name")
	private WebElement customerLastName;

	@FindBy(id = "address")
	private WebElement customerAddress;

	@FindBy(id = "cc_num")
	private WebElement customerCCNo;

	@FindBy(id = "cc_type")
	private WebElement customerCCType;

	@FindBy(id = "cc_exp_month")
	private WebElement customerCCExpiryMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement customerCCExpiryYear;

	@FindBy(id = "cc_cvv")
	private WebElement customerCCcvv;

	@FindBy(id = "book_now")
	private WebElement bookNowBtn;

	@FindBy(id = "cancel")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//td[contains(text(),'Book A Hotel')]")
	private WebElement bookHotelHeader;

	public WebElement getHotelName() {
		return hotelName;
	}

	public WebElement getHotelLocation() {
		return hotelLocation;
	}

	public WebElement getHotelRoomType() {
		return hotelRoomType;
	}

	public WebElement getHotelNoOfRooms() {
		return hotelNoOfRooms;
	}

	public WebElement getHotelNoOfDays() {
		return hotelNoOfDays;
	}

	public WebElement getHotelPricePerNight() {
		return hotelPricePerNight;
	}

	public WebElement getHotelTotalPrice() {
		return hotelTotalPrice;
	}

	public WebElement getHotelGSTPrice() {
		return hotelGSTPrice;
	}

	public WebElement getHotelFinalPrice() {
		return hotelFinalPrice;
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

	public WebElement getCustomerCCNo() {
		return customerCCNo;
	}

	public WebElement getCustomerCCType() {
		return customerCCType;
	}

	public WebElement getCustomerCCExpiryMonth() {
		return customerCCExpiryMonth;
	}

	public WebElement getCustomerCCExpiryYear() {
		return customerCCExpiryYear;
	}

	public WebElement getCustomerCCcvv() {
		return customerCCcvv;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public AdactinBookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBookHotelHeader() {
		return bookHotelHeader;
	}

}
