package com.Bank;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {

	public static void main(String[] args) throws IOException {
		int version=0;
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Step 1: Go to http://www.demo.guru99.com/V4/
		driver.get("http://www.demo.guru99.com/V4/");
		// Step 2: Enter valid Userid
		driver.findElement(By.name("uid")).sendKeys("mngr254418");
		// Step 3: Enter valid Password
		driver.findElement(By.name("password")).sendKeys("gApUpev");
		// Step 4: Click Login
		driver.findElement(By.name("btnLogin")).click();
		// Successful Login Screenshot
		version = version + 1;
		File des = new File(System.getProperty("user.dir") + "\\Screenshots\\" + version + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, des);
		// Step 5: Verify the Output
		assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
		driver.close();
	}

}
