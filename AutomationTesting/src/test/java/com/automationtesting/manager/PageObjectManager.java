package com.automationtesting.manager;

import org.openqa.selenium.WebDriver;

import com.automationtesting.pom.ATAddToBasketPage;
import com.automationtesting.pom.ATHomePage;
import com.automationtesting.pom.ATShopPage;

public class PageObjectManager {
	private WebDriver driver;
	private ATHomePage atHomePage;
	private ATShopPage atShopPage;
	private ATAddToBasketPage atAddToBasketPage;

	public ATAddToBasketPage getAtAddToBasketPage() {
		return (atAddToBasketPage == null) ? atAddToBasketPage = new ATAddToBasketPage(driver) : atAddToBasketPage;
	}

	public ATHomePage getAtHomePage() {
		return (atHomePage == null) ? atHomePage = new ATHomePage(driver) : atHomePage;
	}

	public ATShopPage getAtShopPage() {
		return (atShopPage == null) ? atShopPage = new ATShopPage(driver) : atShopPage;
	}

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
}
