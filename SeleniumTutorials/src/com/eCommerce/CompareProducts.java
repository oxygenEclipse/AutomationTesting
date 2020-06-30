package com.eCommerce;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareProducts {

	public static void main(String[] args) throws IOException, InterruptedException {
		int version = 0;
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Step 1: Goto http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/index.php");
		// Step 2: Click on "MOBILE" menu
		driver.findElement(By.linkText("MOBILE")).click();
		// Step 3: In mobile products list, click on 'Add To Compare' for 2 mobiles
		String compareMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
		String compareMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
		driver.findElement(By.cssSelector("a[title='Xperia'] + .product-info >.actions>ul>li>.link-compare")).click();
		driver.findElement(By.cssSelector("a[title='IPhone'] + .product-info >.actions>ul>li>.link-compare")).click();
		String pid = driver.getWindowHandle(); 
		System.out.println("Parent Process Id : " + pid);
		// Step 4: Click on 'COMPARE' button
		driver.findElement(By.cssSelector(".block-content>.actions>.button>span>span")).click();
		Set<String> childPid = driver.getWindowHandles();
		for (String cpid : childPid) {
			System.out.println("Child Process Id : " + cpid);
			if(!cpid.equals(pid)) {
				driver.switchTo().window(cpid);
			}
			
		}
		// Step 5: Verify the pop-up window and check that the products are reflected in
		// it
		
		String productName1 = driver.findElement(By.cssSelector("a[title = 'Sony Xperia'] + h2>a")).getText();
		String productName2 = driver.findElement(By.cssSelector("a[title = 'IPhone'] + h2>a")).getText();
		System.out.println(productName1);
		System.out.println(productName2);
		Thread.sleep(3000);
		// Compare Mobile one
		try {
			assertEquals(compareMobile2, productName1);
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		// Compare Mobile Two
		try {
			assertEquals(compareMobile1, productName2);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// Successful Login Screenshot
		version = version + 1;
		File des = new File(
				System.getProperty("user.dir") + "\\Screenshots\\eCommerceCompareProducts" + version + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, des);
		// Step 5: Close the popup window
		driver.findElement(By.cssSelector(".buttons-set>.button>span>span")).click();
		driver.switchTo().window(pid);
		Thread.sleep(3000);
		driver.close();
	}

}
