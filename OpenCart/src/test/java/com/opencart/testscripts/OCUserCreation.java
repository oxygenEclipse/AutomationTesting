package com.opencart.testscripts;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.opencart.functionallibrary.BaseClass;
import com.opencart.pom.OCAccountPage;
import com.opencart.pom.OCRegisterUserPage;

public class OCUserCreation extends BaseClass {
	public static void main(String[] args) throws Exception {
		WebDriver driver = browserLaunch("chrome", "http://opencart.abstracta.us/");
		OCRegisterUserPage registerUserPage = new OCRegisterUserPage(driver);
		OCAccountPage accountPage = new OCAccountPage(driver);
		click(registerUserPage.getMyAccount());
		click(registerUserPage.getRegister());
		Assert.assertEquals("Register Account", driver.getTitle());
		passValue(registerUserPage.getFirstName(), "TestABC");
		passValue(registerUserPage.getLastName(), "TestXYX");
		passValue(registerUserPage.getEmail(), "test94@abc.com");
		passValue(registerUserPage.getTelephone(), "845726585");
		passValue(registerUserPage.getFax(), "845726584");
		passValue(registerUserPage.getCompany(), "ABC Company");
		passValue(registerUserPage.getAddress1(), "Ap 56 Orange County");
		passValue(registerUserPage.getAddress2(), "Street Lane");
		passValue(registerUserPage.getCity(), "London");
		passValue(registerUserPage.getPostcode(), "65458");
		selectBy(registerUserPage.getCountry(), "value", "222");
		selectBy(registerUserPage.getState(), "value", "3525");
		passValue(registerUserPage.getPassword(), "test904");
		passValue(registerUserPage.getConfirmPassword(), "test904");
		click(registerUserPage.getNewsletter());
		click(registerUserPage.getAgree());
		click(registerUserPage.getContinueRegistration());
		isDisplayed(registerUserPage.getAccountSuccessMsg());
		Assert.assertEquals("Your Account Has Been Created!", driver.getTitle());
		click(registerUserPage.getContinueAccountPage());
		click(accountPage.getLogout());
		isDisplayed(accountPage.getAccountLogoutMsg());
		Assert.assertEquals("Account Logout", driver.getTitle());
		click(accountPage.getLogoutContinue());
		driver.quit();

	}
}
