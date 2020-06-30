package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class FacebookLogin extends BaseClass {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws Exception {
		driver = browserLaunch("chrome", "https://www.facebook.com/");
	}
  @Test
  public void faceBookLoginTest() {
	  driver.findElement(By.id("email")).sendKeys("itsbanumathig@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("*****");
	  driver.findElement(By.xpath("//input[@value='Log In' and @type='submit']")).click();
	  driver.findElement(By.cssSelector("#userNavigationLabel")).click();
	  driver.findElement(By.xpath("//span[text()='Log Out']")).click();
	  }
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
}
