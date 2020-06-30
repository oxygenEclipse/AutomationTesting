package com.cucumber.manager;

import org.openqa.selenium.WebDriver;

import com.cucumber.pom.ApAddressPage;
import com.cucumber.pom.ApConfirmOrderPage;
import com.cucumber.pom.ApOrderPage;
import com.cucumber.pom.ApPaymentPage;
import com.cucumber.pom.ApRegistrationFormPage;
import com.cucumber.pom.ApSearchBoxOrder;
import com.cucumber.pom.ApShippingPage;
import com.cucumber.pom.ApSignInCreatePage;
import com.cucumber.pom.ApSignInPage;
import com.cucumber.pom.ApSignOutPage;
import com.cucumber.pom.ApSummaryPage;

public class PageObjectManager {
	private WebDriver driver;
	private ApSignInPage signInPage;
	private ApSignInCreatePage signInCreatePage;
	private ApSearchBoxOrder searchbox;
	private ApOrderPage orderPage;
	private ApSummaryPage summaryPage;
	private ApAddressPage addressPage;
	private ApShippingPage shippingPage;
	private ApPaymentPage paymentPage;
	private ApConfirmOrderPage confirmOrderPage;
	private ApSignOutPage signOutPage;
	private ApRegistrationFormPage registerDetails;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public ApSignInPage getSignInPage() {
		return (signInPage == null) ? signInPage = new ApSignInPage(driver) : signInPage;
	}

	public ApSignInCreatePage getSignInCreatePage() {
		return (signInCreatePage == null) ? signInCreatePage = new ApSignInCreatePage(driver) : signInCreatePage;
	}

	public ApSearchBoxOrder getSearchbox() {
		return (searchbox == null) ? searchbox = new ApSearchBoxOrder(driver) : searchbox;
	}

	public ApOrderPage getOrderPage() {
		return (orderPage == null) ? orderPage = new ApOrderPage(driver) : orderPage;
	}

	public ApSummaryPage getSummaryPage() {
		return (summaryPage == null) ? summaryPage = new ApSummaryPage(driver) : summaryPage;
	}

	public ApAddressPage getAddressPage() {
		return (addressPage == null) ? addressPage = new ApAddressPage(driver) : addressPage;
	}

	public ApShippingPage getShippingPage() {
		return (shippingPage == null) ? shippingPage = new ApShippingPage(driver) : shippingPage;
	}

	public ApPaymentPage getPaymentPage() {
		return (paymentPage == null) ? paymentPage = new ApPaymentPage(driver) : paymentPage;
	}

	public ApConfirmOrderPage getConfirmOrderPage() {
		return (confirmOrderPage == null) ? confirmOrderPage = new ApConfirmOrderPage(driver) : confirmOrderPage;
	}

	public ApSignOutPage getSignOutPage() {
		return (signOutPage == null) ? signOutPage = new ApSignOutPage(driver) : signOutPage;
	}

	public ApRegistrationFormPage getRegisterDetails() {
		return (registerDetails == null) ? registerDetails = new ApRegistrationFormPage(driver) : registerDetails;
	}

}
