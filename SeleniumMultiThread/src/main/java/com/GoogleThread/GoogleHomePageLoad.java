package com.GoogleThread;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BaseClass.BaseClass;

public class GoogleHomePageLoad extends BaseClass{
 
	public void googleSearch() {
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("naveen automationlabs");
		driver.findElement(By.name("q")).submit();
		List<WebElement> lists = driver.findElements(By.xpath("//h3"));
		for (WebElement webElement : lists) {
			System.out.println(webElement.getText());
		}
	}
}
