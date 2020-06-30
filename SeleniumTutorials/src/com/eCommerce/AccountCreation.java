package com.eCommerce;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountCreation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Step 1: Goto http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/index.php");
		// Step 2: Click on my Account Link
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
		// Step 3: Click Create Account link and fill New User Information except Email
		// Id
		driver.findElement(By.cssSelector("#header-account>.links>ul>li>a[title='Register'")).click();
		// Fill Registration Details
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Test Account23");
		driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
		driver.findElement(By.cssSelector("#lastname")).sendKeys("ABC45");
		driver.findElement(By.cssSelector("#email_address")).sendKeys("banumathi231445@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("abc@123");
		driver.findElement(By.cssSelector("#confirmation")).sendKeys("abc@123");
		driver.findElement(By.cssSelector("#is_subscribed")).click();
		// Step 4: Click Register
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		// Step 5: Verify Registration is done
		String registerationMsg = driver.findElement(By.cssSelector(".messages>.success-msg>ul>li>span")).getText();
		assertEquals("Thank you for registering with Main Website Store.", registerationMsg);
		// Step 6: Go to TV menu
		driver.findElement(By.cssSelector(".level0 +.level0 >a")).click();
		// Step 7: Add product in your wish list
		driver.findElement(By.cssSelector("a[title='LG LCD'] + .product-info .link-wishlist")).click();
		// Step 8: Click Share WishList
		driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();
		// Step 9: In next page enter Email and a message and click Share WishList
		driver.findElement(By.id("email_address")).sendKeys("banumathi2314@gamil.com");
		driver.findElement(By.id("message")).sendKeys("Check Out My WishList");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		// Step 10:
		String shareMsg = driver.findElement(By.cssSelector(".success-msg>ul>li>span")).getText();
		assertEquals("Your Wishlist has been shared.", shareMsg);
		driver.close();
	}

}
