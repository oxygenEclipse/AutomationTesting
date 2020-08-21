package com.mobiletesting.automationpracticepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiletesting.baseclass.BaseClass;

public class ApOrderPage extends BaseClass {

	@FindBy(xpath = "//a[@title='Women']")
	private WebElement womenMenu1;

	@FindBy(xpath = "//a[@title='Tops']")
	private WebElement topsSubMenu;

	@FindBy(xpath = "//a[@title='Evening Dresses']")
	private WebElement eveningDressSubMenu;

	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	private WebElement productSelect;

	@FindBy(xpath = "//img[@title='Printed Dress']")
	private WebElement productSelect2;

	@FindBy(xpath = "//span[text() ='Quick view']")
	private WebElement productQuickView;

	@FindBy(xpath = "//i[@class='icon-plus']")
	private WebElement quantity;
	
	@FindBy(id = "quantity_wanted")
	private WebElement quantityWanted;

	@FindBy(id = "group_1")
	private WebElement sizeSelect;

	@FindBy(id = "color_14")
	private WebElement color;

	@FindBy(id = "color_8")
	private WebElement whitecolor;

	@FindBy(id = "color_24")
	private WebElement pinkcolor;

	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedCheckOut;

	public WebElement getWomenMenu1() {
		return womenMenu1;
	}

	public WebElement getTopsSubMenu() {
		return topsSubMenu;
	}

	public WebElement getProductSelect() {
		return productSelect;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getSizeSelect() {
		return sizeSelect;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getProceedCheckOut() {
		return proceedCheckOut;
	}

	public WebElement getWhitecolor() {
		return whitecolor;
	}

	public WebElement getEveningDressSubMenu() {
		return eveningDressSubMenu;
	}

	public WebElement getProductSelect2() {
		return productSelect2;
	}

	public WebElement getProductQuickView() {
		return productQuickView;
	}

	public WebElement getPinkcolor() {
		return pinkcolor;
	}

	public ApOrderPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantityWanted() {
		return quantityWanted;
	}
}
