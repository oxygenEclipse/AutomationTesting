package com.automationtesting.stepdefinition;

import org.junit.Assert;

import com.automationtesting.enums.Context;
import com.automationtesting.functionallibrary.BaseClass;
import com.automationtesting.manager.PageObjectManager;
import com.automationtesting.manager.TestContext;
import com.automationtesting.pom.ATAddToBasketPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ATAddToBasketStepDefinition extends BaseClass {
	TestContext testContext;
	PageObjectManager pageObjectManager;
	ATAddToBasketPage atAddToBasketPage;

	public ATAddToBasketStepDefinition(TestContext tc) {
		this.testContext = tc;
		driver = testContext.getWebDriverManager().getDriver();
		atAddToBasketPage = testContext.getPageObjectManager().getAtAddToBasketPage();
	}

	@Then("^User should navigate to the page where user can Add to his basket$")
	public void user_should_navigate_to_the_page_where_user_can_Add_to_his_basket() throws Throwable {
		Assert.assertEquals(testContext.getScenarioContext().getContext(Context.ARRIVAL_PRODUCT_NAME_1)
				+ " – Automation Practice Site", PageTitle(driver));
	}

	@When("^User clicks on Description tab$")
	public void user_clicks_on_Description_tab() throws Throwable {
		atAddToBasketPage.getDescription().click();
	}

	@Then("^User verifies the description displayed is same as the book clicked$")
	public void user_verifies_the_description_displayed_is_same_as_the_book_clicked() throws Throwable {
	Assert.assertFalse(atAddToBasketPage.getProductDescription().getAttribute("innerText")!=null);
	}

}
