package com.eCommerce;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileItemSort {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("Home Page Title : " + title);
		WebElement homePage = driver
				.findElement(By.xpath("//div[@class=\"page-title\"]/h2[contains(text(),'This is demo site for ')]"));
		WebElement mobileLink = driver.findElement(By.xpath("//a[@class=\"level0 \" and text() = 'Mobile']"));
		String homePageText = homePage.getText().trim().toUpperCase();
		Assert.assertEquals("THIS IS DEMO SITE FOR", homePageText);
		mobileLink.click();
		String mobilePageTitle = driver.getTitle().toUpperCase();
		Assert.assertEquals("MOBILE", mobilePageTitle);
		List<WebElement> productListBeforeSort = driver.findElements(
				By.xpath("//ul[@class=\"products-grid products-grid--max-4-col first last odd\"]/li/div/h2/a"));
		LinkedList<String> prodListBeforeSort = new LinkedList<String>();
		for (WebElement prods : productListBeforeSort) {
			prodListBeforeSort.add(prods.getText());
		}
		WebElement sortBySelect = driver.findElement(By.xpath("(//div[@class=\"sort-by\"]/child::select)[1]"));
		Select sortByDD = new Select(sortBySelect);
		sortByDD.selectByIndex(1);
		WebElement setOrder = driver.findElement(By.xpath("//a[@title=\"Set Descending Direction\"]"));
		setOrder.click();
		List<WebElement> productListAfterSort = driver.findElements(
				By.xpath("//ul[@class=\"products-grid products-grid--max-4-col first last odd\"]/li/div/h2/a"));
		LinkedList<String> productList = new LinkedList<String>();
		for (WebElement products : productListAfterSort) {
			productList.add(products.getText());
		}
		System.out.println(productList);
		boolean checkOrder = checkAlphabaticalOrder(productList);
		if (checkOrder == true) {
			System.out.println("Product Names before sorting : " + prodListBeforeSort);
			System.out.println("Product Names are sorted by Names : " + productList);
		}
		else {
			System.out.println("Product Names before sorting : " + prodListBeforeSort);
			System.out.println("Product Names are not sorted by Names : " + productList);
		}
		driver.close();
	}
	// Function to check whether the product is sorted or not
	public static boolean checkAlphabaticalOrder(List<String> products) {

		String previousProdName = "";
		for (String currentProdName : products) {
			if (currentProdName.compareTo(previousProdName) < 0) {
				return true;
			}
			previousProdName = currentProdName;
		}
		return false;
	}

}
