package com.Bank;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.eBank.baseclass.BaseClass;
import com.eBank.pom.LoginPage;
import com.eBank.pom.Logout;

public class NewTest extends BaseClass {
	public WebDriver driver;

	@BeforeTest
	public void browserSetUp() throws Exception {
		driver = browserLaunch("chrome", "http://www.demo.guru99.com/v4/");
	}

	@BeforeMethod
	public void login() {
		LoginPage lp = new LoginPage();
		sendValues(lp.getUserId(), "clear", "mngr254418");
		sendValues(lp.getUserPassword(), "clear", "gApUpev");
		clickIsSelected(lp.getLogin());
	}

	@Test
	public void verifyHomePageTitle() {
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = driver.getTitle();
		try {
			org.junit.Assert.assertEquals(expectedTitle, actualTitle);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void logout() {
		Logout logOut = new Logout();
        clickIsSelected(logOut.getLogout());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
