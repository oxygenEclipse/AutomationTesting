package com.mobiletesting.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AmazonBrowserStack {

	public static String userName = "banumathisathish1";
	public static String accessKey = "usJq5yahjoyAvPpqvmMi";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");
		caps.setCapability("project", "Amazon Project");
		caps.setCapability("build", "Amazon First Build");
		caps.setCapability("name", "App Automate Test");
		caps.setCapability("app", "bs://de462adf69f68a0fcb79b0ab88e920e724802c3c");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//android.widget.ImageView[1])[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
		
		Thread.sleep(5000);

		/* Write your Custom code here */

		driver.quit();

	}

}
