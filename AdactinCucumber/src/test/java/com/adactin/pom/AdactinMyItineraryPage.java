package com.adactin.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.functionallibrary.BaseClass;


public class AdactinMyItineraryPage extends BaseClass {

	@FindBy(id = "order_id_text")
	private WebElement orderIdSearch;

	@FindBy(id = "search_hotel_id")
	private WebElement orderIdSearchBtn;

	@FindBy(xpath = "//table[@cellpadding=\"5\"]/tbody/tr[2]/td/input")
	private List<WebElement> searchOrderResults;
	
	@FindBy(name="cancelall")
	private WebElement selectCancel;
	
	@FindBy(xpath = "//td[contains(text(),'Booked Itinerary')]")
	private WebElement myItineraryHeader;

	public WebElement getOrderIdSearch() {
		return orderIdSearch;
	}

	public WebElement getOrderIdSearchBtn() {
		return orderIdSearchBtn;
	}

	public List<WebElement> getSearchOrderResults() {
		return searchOrderResults;
	}

	public AdactinMyItineraryPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectCancel() {
		return selectCancel;
	}

	public WebElement getMyItineraryHeader() {
		return myItineraryHeader;
	}

}
