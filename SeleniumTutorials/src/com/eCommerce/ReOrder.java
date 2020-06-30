package com.eCommerce;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReOrder {

	public static void main(String[] args) throws InterruptedException {
		String orderNumber = "100011601";
		float price = 0, totalPrice = 0;
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Step 1: Goto http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/index.php");
		// Step 2: Click on my Account Link
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
		// Step 3: Login in application using previously created credential
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
		driver.findElement(By.id("email")).sendKeys("banumathi231445@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc@123");
		driver.findElement(By.id("send2")).click();
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='my-orders-table']/tbody/tr"));
		for (int i = 1; i < allRows.size(); i++) {
			WebElement orderColumn = driver
					.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr[" + i + "]/td[1]"));
			if (orderColumn.getText().equals(orderNumber)) {
				driver.findElement(By
						.xpath("//table[@id='my-orders-table']/tbody/tr[" + i + "]/td[6]/span/a[text()='Reorder']"))
						.click();
				WebElement qty = driver.findElement(By.xpath("//input[@title='Qty']"));
				qty.click();
				qty.clear();
				qty.sendKeys("10");
				Actions ac = new Actions(driver);
				WebElement updateBtn = driver.findElement(By.cssSelector(".button.btn-update"));
				ac.click(updateBtn);
				// Step 6: Enter Shipping Information
				Select regionDD = new Select(driver.findElement(By.id("region_id")));
				regionDD.selectByVisibleText("New York");
				driver.findElement(By.id("postcode")).sendKeys("542896");
				// Step 7: Click Estimate
				driver.findElement(By.xpath("//button[@title='Estimate']")).click();
				// Step 8: Verify Shipping Cost generated
				if (driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).isDisplayed()) {
					System.out.println("Shipping cost is generated");
				}
				// Step 9: Select Shipping cost, Update Total
				driver.findElement(By.id("s_method_flatrate_flatrate")).click();
				driver.findElement(By.xpath("//button[@title='Update Total']")).click();
				// Step 10: Verify Shipping Cost is added to total
				List<WebElement> priceList = driver
						.findElements(By.cssSelector("#shopping-cart-totals-table>tbody>tr>td>span.price"));
				for (WebElement prices : priceList) {
					price = Float.parseFloat(prices.getText().replace("$", "").replace(",", ""));
					totalPrice = totalPrice + price;
				}
				System.out.println("Total Price : " + totalPrice);
				Float totalPriceFinal = Float.parseFloat(
						driver.findElement(By.cssSelector("#shopping-cart-totals-table>tfoot>tr>td>strong>span.price"))
								.getText().replace("$", "").replace(",", ""));
				assertEquals(totalPriceFinal, totalPrice, 0.0f);
				// Step 11: Click PROCEED TO CHECKOUT
				driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
				// Step 12: Click on 'Continue'
				driver.findElement(By.cssSelector("#billing-buttons-container>button")).click();
				// Step 14 : In shipping method, click continue
				driver.findElement(By.cssSelector("#shipping-method-buttons-container>.button")).click();
				// Step 15: Payment Information select 'Check/Money Order' radio button. Click
				// Continue
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				driver.findElement(By.id("p_method_checkmo")).click();
				driver.findElement(By.cssSelector("#payment-buttons-container>.button")).click();

				// Step 16: Click 'PLACE ORDER' button
				driver.findElement(By.xpath("//button[@title='Place Order']")).click();
				// Step 17: Verify Order is generated. Note the order number
				String reOrderNumber = driver.findElement(By.cssSelector(".main>.col-main>p>a")).getText();
				if (!reOrderNumber.isEmpty()) {
					System.out.println("Order is placed .Generated Order# : " + reOrderNumber);
				}
				// Step 18: Click on my Account Link
				driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
			 // Step 19: Click on Logout
				driver.findElement(By.xpath("//a[@title='Log Out']")).click();
				// Step 20: Close the browser window
				driver.close();
			}
		}
	}

}
