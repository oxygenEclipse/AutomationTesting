package com.eCommerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--disabele-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Step 1: Goto http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/index.php");
		// Switch to Frame to close
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='flow_close_btn_iframe']")));
	//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Primis Player Videos']")));
		System.out.println("Switched to Frame");
		Thread.sleep(3000);
		driver.findElement(By.id("closeBtn")).click();
		System.out.println("Frame Closed");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		System.out.println("Parent Window");
		// Step 2: Click on my Account Link
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
		// Step 3: Login in application using previously created credential
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
	}

}
