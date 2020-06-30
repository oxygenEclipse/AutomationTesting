package com.opencart.testscripts;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.opencart.functionallibrary.BaseClass;
import com.opencart.pom.OCAccountPage;
import com.opencart.pom.OCHomePage;
import com.opencart.pom.OCLoginPage;

public class OCLoginVerification extends BaseClass {

	public static void main(String[] args) throws Exception {
		WebDriver driver = browserLaunch("chrome", "http://opencart.abstracta.us/");
		OCHomePage homePage = new OCHomePage(driver);
		OCLoginPage loginPage = new OCLoginPage(driver);
		OCAccountPage accountPage = new OCAccountPage(driver);
		click(homePage.getCssMyAccount());
		click(homePage.getLogin());

		// Warning bypass link
		/*
		 * driver.findElement(By.id("details-button")).click();
		 * driver.findElement(By.id("proceed-link")).click();
		 */

		Assert.assertEquals("Account Login", driver.getTitle());
		Assert.assertTrue(isDisplayed(loginPage.getReturningCustomerLabel()));
		Assert.assertTrue(isDisplayed(loginPage.getReturningCustomerText()));
		Assert.assertTrue(isDisplayed(loginPage.getForgetLink()));
		boolean loginVerify = loginPage.loginVerify("test94@abc.com", "test904");
		if (!loginVerify) {
			System.out.println("Login Successful");
			click(accountPage.getLogout());
			Assert.assertTrue(isDisplayed(accountPage.getAccountLogoutMsg()));
			click(accountPage.getLogoutContinue());
		} else {
			System.out.println("Login Unsuccessful");
			Assert.assertEquals(" Warning: No match for E-Mail Address and/or Password.", loginPage.getAlertWarningMsg(loginPage.getAlertWarning()));
		}
		driver.quit();
	}

}
