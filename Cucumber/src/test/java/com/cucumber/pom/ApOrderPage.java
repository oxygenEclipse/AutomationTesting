package com.cucumber.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApOrderPage extends BaseClass {

	@FindBy(xpath = "//a[@title='Women']")
	private WebElement womenMenu1;

	@FindBy(xpath = "//a[@title='Tops']")
	private WebElement topsSubMenu;

	@FindBy(xpath = "//a[@title='Evening Dresses']")
	private WebElement eveningDressSubMenu;

	@FindBy(xpath = "//a[@title='Blouses']")
	private WebElement blouses;

	public WebElement getBlouses() {
		return blouses;
	}

	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	private WebElement productSelect;

	@FindBy(xpath = "//img[@title='Printed Dress']")
	private WebElement productSelect2;

	@FindBy(how = How.CSS, using = "img[title='Printed Dress']")
	private WebElement productSelect3;

	@FindBy(xpath = "//a[contains(text(),'Blouse') and @title='Blouse']")
	private WebElement productBlouse;

	@FindBy(xpath = "//div[@class='product-image-container']/a/span")
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

	@FindBy(xpath = "//span[@id='layer_cart_product_title']")
	private WebElement productNameDisplay;

	@FindBy(xpath = "//h1[@itemprop=\"name\"]")
	private WebElement dynamicProductName;

	@FindBy(xpath = "//ul[@id=\"color_to_pick_list\"]/li/a")
	private List<WebElement> dynamicProductColor;

	@FindBy(xpath = "//h1[@itemprop='name']")
	private WebElement quickViewProductName;

	@FindBy(xpath = "//ul[@class=\"product_list grid row\"]/li/div[@class=\"product-container\"]/div/div/a/img")
	private List<WebElement> productList;

	@FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
	private WebElement productRange;

	@FindBy(id = "layered_price_range")
	private WebElement productPriceRange;

	@FindBy(xpath = "//span[@itemprop='price']")
	private WebElement productPrice;

	@FindBy(xpath = "//img[@title='Blouse']")
	private WebElement blouseMouseOver;

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

	public ApOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantityWanted() {
		return quantityWanted;
	}

	public WebElement getProductBlouse() {
		return productBlouse;
	}

	public WebElement getProductNameDisplay() {
		return productNameDisplay;
	}

	public WebElement getDynamicProductName() {
		return dynamicProductName;
	}

	public List<WebElement> getDynamicProductColor() {
		return dynamicProductColor;
	}

	public WebElement getQuickViewProductName() {
		return quickViewProductName;
	}

	public List<WebElement> getProductList() {
		return productList;
	}

	public WebElement getProductRange() {
		return productRange;
	}

	public WebElement getProductPriceRange() {
		return productPriceRange;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getBlouseMouseOver() {
		return blouseMouseOver;
	}

	public WebElement getProductSelect3() {
		return productSelect3;
	}
}
