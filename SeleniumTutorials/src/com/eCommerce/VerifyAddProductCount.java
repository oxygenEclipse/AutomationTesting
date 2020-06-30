package com.eCommerce;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAddProductCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Step 1: Goto http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/index.php");

		String errorText = "", cartErrorMsg = ""; // Step 2: Click on "MOBILE" menu
		driver.findElement(By.linkText("MOBILE")).click();

		// Step 3: In the list of all mobile, click on 'ADD TO CART' for Sony Xperia
		// mobile

		driver.findElement(By.cssSelector("a[title='Xperia'] + div.product-info > div.actions>button")).click();

		// Step 4: Change QTY value to 1000, click on 'ADD TO CART' for Sony Xperia
		// mobile

		WebElement qtyText = driver.findElement(By.cssSelector(".product-cart-actions >input"));
		qtyText.clear();
		qtyText.sendKeys("1000");
		driver.findElement(By.cssSelector(".product-cart-actions >input + button")).click();

		// Step 5: Verify the Error Message

		if (driver.findElement(By.cssSelector(".messages>.error-msg>ul>li>span")).isDisplayed()) {
			errorText = driver.findElement(By.cssSelector(".messages>.error-msg>ul>li>span")).getText();
		}
		assertEquals("Some of the products cannot be ordered in requested quantity.", errorText);

		// Step 6: Then click on "EMPTY CART" link in the footer of list of all mobiles

		driver.findElement(By.cssSelector(".button2.btn-empty")).click();

		// Step 7: Verify cart is empty

		if (driver.findElement(By.cssSelector(".cart-empty>p")).isDisplayed()) {
			cartErrorMsg = driver.findElement(By.cssSelector(".cart-empty>p")).getText();
		}
		assertEquals("You have no items in your shopping cart.", cartErrorMsg);
		driver.close();
	}
}
