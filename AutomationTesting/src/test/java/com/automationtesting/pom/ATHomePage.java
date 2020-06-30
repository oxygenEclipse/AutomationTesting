package com.automationtesting.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATHomePage {

	public ATHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Shop']")
	private WebElement shopLink;

	@FindBy(css = "div.nextend-arrow-next>img[alt='Arrow']")
	private WebElement nextArrow;

	@FindBy(css = ".n2-ss-slide-background-image")
	private List<WebElement> images;

	@FindBy(css="ul.products>li")
	private List<WebElement> arrivalList;
	
	@FindBy(css="ul.products>li>a>h3")
	private List<WebElement> arrivalListName;
	
	public List<WebElement> getArrivalListName() {
		return arrivalListName;
	}

	public List<WebElement> getArrivalList() {
		return arrivalList;
	}

	public WebElement getShopLink() {
		return shopLink;
	}

	public WebElement getNextArrow() {
		return nextArrow;
	}

	public List<WebElement> getImages() {
		return images;
	}

	public boolean verifyNumberOfSliders(int num) {
		List<WebElement> slideImages = getImages();
		return (slideImages.size() == num) ? true : false;
	}
	
	public boolean verifyNumberOfArrivals(int num) {
		List<WebElement> arrivalImages = getArrivalList();
		return (arrivalImages.size() == num) ? true : false;
	}

}
