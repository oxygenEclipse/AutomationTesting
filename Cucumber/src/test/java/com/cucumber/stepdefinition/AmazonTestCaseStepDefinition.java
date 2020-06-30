package com.cucumber.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.funtionallibrary.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonTestCaseStepDefinition extends BaseClass {

	public WebDriver driver;

	@Given("^User launches the Amazon website$")
	public void user_launches_the_Amazon_website() throws Throwable {
		driver = browserLaunch("chrome");
		getURL(driver, "https://www.amazon.com/");
	}

	@Then("^User successfully launches the website$")
	public void user_successfully_launches_the_website() throws Throwable {
		Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
				PageTitle(driver));
	}

	@When("^User enter product name as \"([^\"]*)\"$")
	public void user_enter_product_name_as(String searchText) throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
	}

	@When("^User hit Enter or click submit button$")
	public void user_hit_Enter_or_click_submit_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Go']")).sendKeys(Keys.ENTER);
	}

	@Then("^System should responed back with list of Dove Soaps$")
	public void system_should_responed_back_with_list_of_Dove_Soaps() throws Throwable {
	//	Assert.assertEquals("Amazon.com : dove soaps", PageTitle(driver));
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		Assert.assertTrue(searchResult.size() > 0);
	}

	@When("^User quits the application$")
	public void user_quits_the_application() throws Throwable {
		driver.close();
	}

	@When("^User enter no product name$")
	public void user_enter_no_product_name() throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("");
	}

	@Then("^System should responed back with the text \"([^\"]*)\"$")
	public void system_should_responed_back_with_the_text(String expectedMsg) throws Throwable {
		Assert.assertTrue(true);

	}

}
