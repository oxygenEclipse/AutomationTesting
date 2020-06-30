package com.cucumber.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.enums.Context;
import com.cucumber.funtionallibrary.BaseClass;
import com.cucumber.manager.PageObjectManager;
import com.cucumber.manager.TestContext;
import com.cucumber.pom.ApSignInPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApSignInPageStepDefinition extends BaseClass {
	public WebDriver driver;
	TestContext testContext;
	PageObjectManager pageObjectManager;
	ApSignInPage signInPage;
	

	public ApSignInPageStepDefinition(TestContext tc) {
		this.testContext = tc;
		driver = testContext.getWebDriverManager().getDriver();
		signInPage = testContext.getPageObjectManager().getSignInPage();
	}

	@Given("^User launches the browser and hit the Automation Practice application$")
	public void user_launches_the_browser_and_hit_the_Automation_Practice_application() throws Throwable {
		getURL(driver, "http://automationpractice.com/index.php");
	}

	@When("^User clicks on the Sign In in the Home Page$")
	public void user_clicks_on_the_Sign_In_in_the_Home_Page() throws Throwable {
		Assert.assertTrue(signInPage.getSignIn().isDisplayed());
		clickIsSelected(signInPage.getSignIn());
	}
	@Then("^User verifies the user name is displayed on header on successful registration$")
	public void user_verifies_the_user_name_is_displayed_on_header_on_successful_registration() throws Throwable {
		Assert.assertEquals(getText(signInPage.getUserName()), (String)testContext.scenarioContext.getContext(Context.FIRST_NAME) + " " + (String)testContext.scenarioContext.getContext(Context.LAST_NAME));
	}
}
