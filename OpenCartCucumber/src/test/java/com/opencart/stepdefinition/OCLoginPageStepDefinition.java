package com.opencart.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.opencart.functionallibrary.BaseClass;
import com.opencart.pom.OCAccountPage;
import com.opencart.pom.OCHomePage;
import com.opencart.pom.OCLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class OCLoginPageStepDefinition extends BaseClass {
	public WebDriver driver;
	
	
	
	boolean loginVerify;

	@Given("User launches the Open Cart Application")
	public void user_launches_the_Open_Cart_Application() throws Exception {
		driver = browserLaunch("chrome", "http://opencart.abstracta.us/");
	}
	
	@Then("Verify the application launches successfully")
	public void verify_the_application_launches_successfully() {
		Assert.assertEquals("Your Store", driver.getTitle());	    
	}
	@When("User clicks on My Account Login link")
	public void user_clicks_on_My_Account_Login_link() {
		OCHomePage homePage = new OCHomePage(driver);
		click(homePage.getCssMyAccount());
		click(homePage.getLogin());	    
	}
	@Then("User verifies whether Login Page is displayed")
	public void user_verifies_whether_Login_Page_is_displayed() {
		OCLoginPage loginPage = new OCLoginPage(driver);
		Assert.assertEquals("Account Login", driver.getTitle());
		Assert.assertTrue(isDisplayed(loginPage.getReturningCustomerLabel()));
		Assert.assertTrue(isDisplayed(loginPage.getReturningCustomerText()));
		Assert.assertTrue(isDisplayed(loginPage.getForgetLink()));	    
	}
	@When("User enters {string} and {string} and clicks login button")
	public void user_enters_and_and_clicks_login_button(String userName, String password) {
		OCLoginPage loginPage = new OCLoginPage(driver);
		loginVerify = loginPage.loginVerify(userName, password);	    
	}
	@Then("User verifies whether the user is logged in successfully")
	public void user_verifies_whether_the_user_is_logged_in_successfully() {
		Assert.assertFalse(loginVerify);	    
	}
	@When("User clicks on logout link in the account page")
	public void user_clicks_on_logout_link_in_the_account_page() {
		OCAccountPage accountPage = new OCAccountPage(driver);
		click(accountPage.getLogout());
		Assert.assertTrue(isDisplayed(accountPage.getAccountLogoutMsg()));	    
	}
	@Then("Verify user successfully logs out of the application")
	public void verify_user_successfully_logs_out_of_the_application() {
		OCAccountPage accountPage = new OCAccountPage(driver);
		click(accountPage.getLogoutContinue());	    
	}
	
	@Then("User verifies whether login error message is displayed in the header")
	public void user_verifies_whether_login_error_message_is_displayed_in_the_header() {
		OCLoginPage loginPage = new OCLoginPage(driver);
		Assert.assertTrue(loginVerify);
		Assert.assertEquals(" Warning: No match for E-Mail Address and/or Password.", loginPage.getAlertWarningMsg(loginPage.getAlertWarning()));
	}
	@Then("User quits the application")
	public void user_quits_the_application() {
		driver.quit();
	    
	}
}
