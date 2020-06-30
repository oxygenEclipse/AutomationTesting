package com.openCart;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenCartHomePageOrder {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://opencart.abstracta.us/");
		driver.manage().deleteAllCookies();
		// Select the Home Page Product - Apple Cinema 30"

		try {
			WebElement product = driver.findElement(By.xpath("//a[text() = 'Apple Cinema 30\"']"));
			product.click();
		} catch (ElementNotVisibleException e) {
			System.out.println("Product Not Available");
		}

		// Check whether the application navigated to Product Detail Page
		Assert.assertEquals("Apple Cinema 30", driver.getTitle());

		// Enter the Available Options Section
		driver.findElement(By.xpath("//input[@type = 'radio' and @name = 'option[218]']")).click();
		driver.findElement(By.xpath("//input[@type = 'checkbox' and @name='option[223][]']")).click();
		driver.findElement(By.id("input-option208")).sendKeys("TestABC");
		WebElement selectInput = driver.findElement(By.id("input-option217"));
		Select options = new Select(selectInput);
		options.selectByValue("3");
		driver.findElement(By.id("input-option209")).sendKeys("TestABC Text Area");
		//driver.findElement(By.id("button-upload222")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('input-option222').setAttribute('value','D:\\TestFileUpload.txt')");
		//driver.findElement(By.id("input-option222")).sendKeys("D:\\TestFileUpload.txt");
		
		/*Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();*/
		driver.findElement(By.id("button-cart")).click(); // Add To Cart

		// Successfully Added to the Cart
		Thread.sleep(3000);
		WebElement successAlert = driver.findElement(By.cssSelector(".alert.alert-success"));
		Assert.assertTrue(successAlert.isDisplayed());

		// click on shopping cart link

		driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();
		Assert.assertEquals("Shopping Cart", driver.getTitle());

		// click on Checkout button

		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		
		// Warning bypass link
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();

		// select 'Guest' in checkout Page

		driver.findElement(By.xpath("//input[@value='guest']")).click();
		driver.findElement(By.id("button-account")).click();

		Thread.sleep(3000);
		// Enter the billing details
		driver.findElement(By.xpath("//input[@type='text' and @name = 'firstname']")).sendKeys("Guest First Name");
		driver.findElement(By.xpath("//input[@type='text' and @name = 'lastname']")).sendKeys("Guest Last Name");
		driver.findElement(By.xpath("//input[@type='text' and @id = 'input-payment-email']")).sendKeys("test123@abc.com");
		driver.findElement(By.xpath("//input[@type='text' and @name = 'telephone']")).sendKeys("7845863458");

		// Enter address details
		driver.findElement(By.xpath("//input[@type='text' and @name = 'company']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@type='text' and @name = 'address_1']")).sendKeys("AP 45, Maple Avenue");
		driver.findElement(By.xpath("//input[@type='text' and @name = 'city']")).sendKeys("London");
		driver.findElement(By.xpath("//input[@type='text' and @name = 'postcode']")).sendKeys("65478");
		WebElement countrySelect = driver.findElement(By.id("input-payment-country"));
		Select countryDD = new Select(countrySelect);
		countryDD.selectByValue("222");
		WebElement stateSelect = driver.findElement(By.id("input-payment-zone"));
		Select stateDD = new Select(stateSelect);
		stateDD.selectByValue("3525");
		driver.findElement(By.id("button-guest")).click();

		Thread.sleep(3000);
		// Enter the delivery details
		driver.findElement(By.xpath("//textarea[@name = 'comment']")).sendKeys("Test Comment");
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(3000);

		// Enter Payment Method

		driver.findElement(By.xpath("//input[@name = 'agree']")).click();
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(3000);

		// Enter Confirm Order

		Thread.sleep(3000);
		driver.findElement(By.id("button-confirm")).click();

		// Check Order Confirmation

		System.out.println("Page Title After Order Confirmation : " + driver.getTitle());
		//Assert.assertEquals("Your order has been placed!", driver.getTitle());

		driver.findElement(By.xpath("//a[text()='Continue']")).click();

		// Home Page display

		Assert.assertEquals("Your Store", driver.getTitle());
		
		driver.quit();

	}

}
