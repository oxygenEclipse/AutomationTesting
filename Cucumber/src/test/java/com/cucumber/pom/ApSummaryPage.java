package com.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.funtionallibrary.BaseClass;

public class ApSummaryPage extends BaseClass {

	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[2]/p/a")
	private WebElement summaryPageProductName;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	private WebElement proceedCheckOutBtn;

	@FindBy(xpath = "(//span[@class=\"price\"])[3]")
	private WebElement productUnitPrice;

	@FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
	private WebElement productQuantity;

	@FindBy(xpath = "(//span[@class=\"price\"])[4]")
	private WebElement productTotal;

	public WebElement getProceedCheckOutBtn() {
		return proceedCheckOutBtn;
	}

	public WebElement getProductUnitPrice() {
		return productUnitPrice;
	}

	public WebElement getProductQuantity() {
		return productQuantity;
	}

	public WebElement getProductTotal() {
		return productTotal;
	}

	public ApSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSummaryPageProductName() {
		return summaryPageProductName;
	}

}
