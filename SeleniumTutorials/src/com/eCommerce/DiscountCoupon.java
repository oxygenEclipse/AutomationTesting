package com.eCommerce;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiscountCoupon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php");
		driver.findElement(By.linkText("MOBILE")).click();
		driver.findElement(By.cssSelector("a[title='IPhone'] + .product-info >.actions>button")).click();
		driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
		driver.findElement(By.xpath("//button[@title='Apply']")).click();
		// Calculate the discount total price
		float totalPrice = Float.parseFloat(driver.findElement(By.cssSelector(".product-cart-total>.cart-price>span"))
				.getText().replace("$", "").replace(",", ""));
		float discountPrice = Float.parseFloat(
				driver.findElement(By.cssSelector("#shopping-cart-totals-table>tbody>tr:last-of-type>td>span.price"))
						.getText().replace("$", "").replace(",", "").replace("-", ""));
		float discountCost = (totalPrice * 5) / 100;
		try {
			assertEquals(discountCost, discountPrice, 0.0f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		float totalPriceFinal = Float.parseFloat(
				driver.findElement(By.cssSelector("#shopping-cart-totals-table>tfoot>tr>td>strong>span.price"))
						.getText().replace("$", "").replace(",", ""));
		float calculatedTotalPrice = totalPrice - discountCost;
		try {
			assertEquals(totalPriceFinal, calculatedTotalPrice, 0.0f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
