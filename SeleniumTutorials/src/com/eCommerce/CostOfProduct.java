package com.eCommerce;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CostOfProduct {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("MOBILE")).click();
		String XPeriaPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
		 driver.findElement(By.id("product-collection-image-1")).click();
		 String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();
		 try {
		        assertEquals(XPeriaPrice, detailPrice); 
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      }
		 driver.close();
	}
}
