package com.opencart.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.functionallibrary.BaseClass;
import com.opencart.pom.OCBillingDetailsPage;
import com.opencart.pom.OCCheckOutPage;
import com.opencart.pom.OCDeliveryDetailsPage;
import com.opencart.pom.OCHomePage;
import com.opencart.pom.OCOrderConfirmationPage;
import com.opencart.pom.OCProductDetailPage;
import com.opencart.pom.OCSearchResultProductPage;
import com.opencart.pom.OCShoppingCartPage;

import org.junit.Assert;

public class OCSearchProductOrder extends BaseClass {
	public static void main(String[] args) throws Exception {
	WebDriver driver = browserLaunch("chrome", "http://opencart.abstracta.us/");
	OCHomePage homePage = new OCHomePage(driver);
	OCSearchResultProductPage searchResultProducPage = new OCSearchResultProductPage(driver);
	OCProductDetailPage productDetailPage = new OCProductDetailPage(driver);
	OCShoppingCartPage shoppingCartPage = new OCShoppingCartPage(driver);
	OCCheckOutPage checkOutPage = new OCCheckOutPage(driver);
	OCBillingDetailsPage billingDetailsPage = new OCBillingDetailsPage(driver);
	OCDeliveryDetailsPage deliveryDetailsPage = new OCDeliveryDetailsPage(driver);
	OCOrderConfirmationPage orderConfirmationPage = new OCOrderConfirmationPage(driver);
	passValue(homePage.getSearchBox(), "Apple Cinema 30");
	click(homePage.getSearchButton());
	Assert.assertEquals("Search - Apple Cinema 30", driver.getTitle());
	click(searchResultProducPage.getAppleProd());
	// Check whether the application navigated to Product Detail Page
			Assert.assertEquals("Apple Cinema 30", driver.getTitle());
			click(productDetailPage.getRadio());
			click(productDetailPage.getCheck());
			passValue(productDetailPage.getText(), "TestABC");
			selectBy(productDetailPage.getSelect(), "Value", "3");
			passValue(productDetailPage.getTextArea(), "TestABC Text Area");
			productDetailPage.fileUpload(driver);
			click(productDetailPage.getAddToCart());
			isDisplayed(productDetailPage.getSuccessAlert());
			click(homePage.getShoppingCart());
			Assert.assertEquals("Shopping Cart", driver.getTitle());
			click(shoppingCartPage.getCheckOut());

			// Warning bypass link
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
			
			click(checkOutPage.getGuest());
			click(checkOutPage.getContinueGuest());
			passValue(billingDetailsPage.getFirstName(), "Guest First Name");
			passValue(billingDetailsPage.getLastName(), "Guest Last Name");
			passValue(billingDetailsPage.getEmail(), "test123@abc.com");
			passValue(billingDetailsPage.getTelephone(), "7845863458");

			passValue(billingDetailsPage.getCompany(), "ABC");
			passValue(billingDetailsPage.getAddress1(), "AP 45, Maple Avenue");
			passValue(billingDetailsPage.getCity(), "London");
			passValue(billingDetailsPage.getPostcode(), "65478");
			selectBy(billingDetailsPage.getCountry(), "Value", "222");
			selectBy(billingDetailsPage.getState(), "Value", "3525");
			click(billingDetailsPage.getContinueGuest());
			passValue(deliveryDetailsPage.getComment(), "Test Comment");
			click(deliveryDetailsPage.getContinueShipping());
			click(deliveryDetailsPage.getAgree());
			click(deliveryDetailsPage.getContinuePayment());
			click(deliveryDetailsPage.getConfirmOrder());

			click(orderConfirmationPage.getContinueHomePage());
			Assert.assertEquals("Your Store", driver.getTitle());
			driver.quit();

	
	
	}
}
