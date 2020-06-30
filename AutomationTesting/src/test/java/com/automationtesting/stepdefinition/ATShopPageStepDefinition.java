package com.automationtesting.stepdefinition;

import com.automationtesting.manager.PageObjectManager;
import com.automationtesting.manager.TestContext;
import com.automationtesting.pom.ATShopPage;

import cucumber.api.java.en.When;
import org.junit.Assert;

public class ATShopPageStepDefinition {
	TestContext testContext;
	PageObjectManager pageObjectManager;
	ATShopPage atShopPage;
	
	public ATShopPageStepDefinition(TestContext tc) {
		this.testContext = tc;
		atShopPage = testContext.getPageObjectManager().getAtShopPage();
	}
	@When("^User clicks on Home menu button$")
	public void user_clicks_on_Home_menu_button() throws Throwable {
		Assert.assertTrue(atShopPage.getHomeLink().isDisplayed());
		atShopPage.getHomeLink().click();
	}
	

}
