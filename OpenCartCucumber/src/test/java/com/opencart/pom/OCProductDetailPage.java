package com.opencart.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OCProductDetailPage {

	public OCProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type = 'radio' and @name = 'option[218]']")
	private WebElement radio;

	@FindBy(xpath = "//input[@type = 'checkbox' and @name='option[223][]']")
	private WebElement check;

	@FindBy(id = "input-option208")
	private WebElement text;

	@FindBy(id = "input-option217")
	private WebElement select;

	@FindBy(id = "input-option209")
	private WebElement textArea;

	@FindBy(id = "input-option222")
	private WebElement fileUpload;

	@FindBy(id = "button-cart")
	private WebElement addToCart;
	
	@FindBy(css = ".alert.alert-success")
	private WebElement successAlert;

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getCheck() {
		return check;
	}

	public WebElement getText() {
		return text;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getTextArea() {
		return textArea;
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getSuccessAlert() {
		return successAlert;
	}
	public void fileUpload(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('input-option222').setAttribute('value','D:\\TestFileUpload.txt')");
	}
}
