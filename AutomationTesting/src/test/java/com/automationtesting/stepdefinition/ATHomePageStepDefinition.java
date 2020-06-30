package com.automationtesting.stepdefinition;


import org.junit.Assert;

import com.automationtesting.enums.Context;
import com.automationtesting.functionallibrary.BaseClass;
import com.automationtesting.manager.PageObjectManager;
import com.automationtesting.manager.TestContext;
import com.automationtesting.pom.ATHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ATHomePageStepDefinition extends BaseClass {
	TestContext testContext;
	PageObjectManager pageObjectManager;
	ATHomePage atHomePage;

	public ATHomePageStepDefinition(TestContext tc) {
		this.testContext = tc;
		driver = testContext.getWebDriverManager().getDriver();
		atHomePage = testContext.getPageObjectManager().getAtHomePage();
	}

	@Given("^User open the browser and enters the automation testing URL$")
	public void user_open_the_browser_and_enters_the_automation_testing_URL() throws Throwable {
		getURL(driver, "http://practice.automationtesting.in/");
	}

	@When("^User clicks on Shop Menu$")
	public void user_clicks_on_Shop_Menu() throws Throwable {
		Assert.assertTrue(atHomePage.getShopLink().isDisplayed());
		atHomePage.getShopLink().click();
	}

	@Then("^User verifies whether the Home page has only (\\d+) sliders$")
	public void user_verifies_whether_the_Home_page_has_only_sliders(int silderNum) throws Throwable {
		Assert.assertTrue(atHomePage.verifyNumberOfSliders(silderNum));
	}

	@Then("^Check whether it is navigated to the Home page$")
	public void check_whether_it_is_navigated_to_the_Home_page() throws Throwable {
		Assert.assertEquals("Automation Practice Site", PageTitle(driver));
	}

	@Then("^User verifies whether the Home page has only (\\d+) arrivals$")
	public void user_verifies_whether_the_Home_page_has_only_arrivals(int arrivalNum) throws Throwable {
		Assert.assertTrue(atHomePage.verifyNumberOfSliders(arrivalNum));
	}

	@When("^User clicks on the image in Arrivals$")
	public void user_clicks_on_the_image_in_Arrivals() throws Throwable {
		    testContext.scenarioContext.setContext(Context.ARRIVAL_PRODUCT_NAME_1, atHomePage.getArrivalListName().get(0).getText());
			atHomePage.getArrivalList().get(0).click();
	}

	@When("^User quits the application$")
	public void user_quits_the_application() throws Throwable {
		driver.close();
	}
}
