package com.opencart.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCHomePage {
	public OCHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".fa.fa-user")
	private WebElement cssMyAccount;

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement register;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement login;

	@FindBy(xpath = "//span[text()= 'Shopping Cart']")
	private WebElement shoppingCart;

	@FindBy(xpath = "//span[text()= 'Checkout']")
	private WebElement checkOut;

	@FindBy(xpath = "//span[contains(text(),'Wish List')]")
	private WebElement wishList;

	@FindBy(xpath = "//a[text() = 'Apple Cinema 30\"']")
	private WebElement appleProd;

	@FindBy(xpath = "//input[@type='text' and @name = 'search']")
	private WebElement searchBox;

	@FindBy(css = ".btn.btn-default.btn-lg")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getWishList() {
		return wishList;
	}

	public WebElement getAppleProd() {
		return appleProd;
	}

	public WebElement getCssMyAccount() {
		return cssMyAccount;
	}

}
