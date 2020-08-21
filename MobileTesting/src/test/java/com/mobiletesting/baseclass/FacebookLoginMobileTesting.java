package com.mobiletesting.baseclass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FacebookLoginMobileTesting extends BaseClass {
	public static final String AUTOMATE_USERNAME = "banumathisathish1";
	public static final String AUTOMATE_ACCESS_KEY = "usJq5yahjoyAvPpqvmMi";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "Android");
	    caps.setCapability("device", "Samsung Galaxy S8");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "7.0");
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("https://m.facebook.com/");
		driver.findElement(By.id("m_login_email")).sendKeys("banumathi@gmail.com");
		driver.findElement(By.id("m_login_password")).sendKeys("abc756");
		driver.findElement(By.name("login")).click();
		driver.quit();
	}

}
