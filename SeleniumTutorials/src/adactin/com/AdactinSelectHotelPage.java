package adactin.com;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import automation.practice.BaseClass;

public class AdactinSelectHotelPage extends BaseClass {

	@FindBys({ @FindBy(xpath = "//input[@value='Melbourne']") })
	private List<WebElement> hotelLocations;

	@FindBy(id = "location_0")
	private WebElement hotelLocationplace1;
	
	@FindBy(id="arr_date_0")
	private WebElement arrivalDate;
	
	@FindBy(id="dep_date_0")
	private WebElement departureDate;

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
}
