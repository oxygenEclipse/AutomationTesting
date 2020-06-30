package com.cucumber.stepdefinition;

import org.junit.Assert;

import com.cucumber.funtionallibrary.BaseClass;
import com.cucumber.manager.PageObjectManager;
import com.cucumber.manager.TestContext;
import com.cucumber.pom.ApSignInCreatePage;

import cucumber.api.java.en.Then;

public class ApSignInCreatePageStepDefinition extends BaseClass {
	TestContext testContext;
	PageObjectManager pageObjectManager;
	ApSignInCreatePage signInCreatePage;

	public ApSignInCreatePageStepDefinition(TestContext tc) {
		this.testContext = tc;
		signInCreatePage = testContext.getPageObjectManager().getSignInCreatePage();
	}

	@Then("^User verifies whether the SignIn Page is displayed$")
	public void user_verifies_whether_the_SignIn_Page_is_displayed() throws Throwable {
		Assert.assertTrue(isDisplayed(signInCreatePage.getAuthenticationHeader()));
		isDisplayed(signInCreatePage.getAlreadyRegisteredHeader());
		isDisplayed(signInCreatePage.getCreateAccountHeader());
		isDisplayed(signInCreatePage.getEmailAddress());
		isDisplayed(signInCreatePage.getCreateAccountBtn());
		Assert.assertEquals("Login - My Store", PageTitle(testContext.getWebDriverManager().getDriver()));
	}

	@Then("^User enters the \"([^\"]*)\" to create an account$")
	public void user_enters_the_to_create_an_account(String emailAddr) throws Throwable {
		sendValues(signInCreatePage.getEmailAddress(), emailAddr);
	}

	@Then("^User clicks on create an account button$")
	public void user_clicks_on_create_an_account_button() throws Throwable {
		clickIsSelected(signInCreatePage.getCreateAccountBtn());
	}

	@Then("^User verifies User Registration Page is displayed$")
	public void user_verifies_User_Registration_Page_is_displayed() throws Throwable {
		Assert.assertTrue(isDisplayed(signInCreatePage.getCreateAccountHeader()));
	}
}
