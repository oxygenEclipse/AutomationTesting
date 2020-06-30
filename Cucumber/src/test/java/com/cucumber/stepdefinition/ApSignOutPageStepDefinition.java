package com.cucumber.stepdefinition;

import org.junit.Assert;

import com.cucumber.funtionallibrary.BaseClass;
import com.cucumber.manager.PageObjectManager;
import com.cucumber.manager.TestContext;
import com.cucumber.pom.ApSignOutPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApSignOutPageStepDefinition extends BaseClass {

	TestContext testContext;
	PageObjectManager pageObjectManager;
	ApSignOutPage signOutPage;
	public ApSignOutPageStepDefinition(TestContext tc) {
		this.testContext = tc;
		signOutPage = testContext.getPageObjectManager().getSignOutPage();
	}
	
	@When("^User clicks on logout button$")
	public void user_clicks_on_logout_button() throws Throwable {
		clickIsSelected(signOutPage.getSignOut1());
	}
	@Then("^User verifies if the user is logout of the application$")
	public void user_verifies_if_the_user_is_logout_of_the_application() throws Throwable {
		Assert.assertTrue(isDisplayed(signOutPage.getSignInPage()));
	}
	@When("^User closes the browser$")
	public void user_closes_the_browser() throws Throwable {
		testContext.getWebDriverManager().getDriver().close();
	}
}
