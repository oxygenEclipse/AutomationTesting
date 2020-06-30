package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class RedBusLogin extends BaseClass {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws Exception {
		driver = browserLaunch("chrome", "https://www.redbus.in/");
	}
	@Test
	public void redbusLogin() {
		driver.findElement(By.id("sign-in-icon-down")).click();
		driver.findElement(By.id("signInLink")).click();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
