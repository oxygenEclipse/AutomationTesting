package com.eCommerce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GenerateOrderPDF {

	public static void main(String[] args) throws InterruptedException, AWTException {
		String orderNumber = "100011601";
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		String fileDownloadPath = "D:\\Banu";
		Map<String, Object> prefsMap = new HashMap<String, Object>();
		prefsMap.put("profile.default_content_settings.popups", 0);
		prefsMap.put("download.default_directory", fileDownloadPath);

		option.setExperimentalOption("prefs", prefsMap);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, option);
		option.addArguments("--test-type");
		option.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Step 1: Goto http://live.demoguru99.com
		driver.get("http://live.demoguru99.com/index.php");
		// Step 2: Click on my Account Link
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
		// Step 3: Login in application using previously created credential
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
		driver.findElement(By.id("email")).sendKeys("banumathi231445@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc@123");
		driver.findElement(By.id("send2")).click();
		// Step 4: Click on MY ORDERS
		driver.findElement(By.xpath("//a[text()='My Orders']")).click();
		// Step 5: List of Orders
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='my-orders-table']/tbody/tr"));
		for (int i = 1; i < allRows.size(); i++) {
			WebElement orderColumn = driver
					.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr[" + i + "]/td[1]"));
			String orderStatus = driver
					.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr[" + i + "]/td[5]")).getText();
			if (orderColumn.getText().equals(orderNumber) && orderStatus.equals("Pending")) {
				driver.findElement(By
						.xpath("//table[@id='my-orders-table']/tbody/tr[" + i + "]/td[6]/span/a[text()='View Order']"))
						.click();
				String pid = driver.getWindowHandle();
				driver.findElement(By.cssSelector(".link-print")).click();
				Set<String> childPids = driver.getWindowHandles();
				System.out.println(childPids);
				// for (String cPid : childPids) {
				// if(!cPid.equals(pid)) {
				// driver.switchTo().window(cPid);
				// driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
				if (!childPids.isEmpty()) {
					driver.switchTo().window(driver.getWindowHandles().toArray()[childPids.size() - 1].toString());
					System.out.println("Switched to Print Window");
					System.out.println("Print Popup : " + driver.getTitle());
				}
				Thread.sleep(3000);
				System.out.println("Thread Wait");
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				driver.close();
				driver.switchTo().window(pid);
				driver.close();
				
				
			//	System.out.println(driver.findElement(By.xpath("//*[@id='sidebar']")).isDisplayed());
		//		driver.findElement(By.className("cancel-button")).click();
			//	WebElement destination = driver.findElement(By.xpath(".//select[@class='md-select']"));
			//	Thread.sleep(3000);
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// WebElement destination = (WebElement) js.executeScript(
				// "return
				// document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar').shadowRoot.querySelector('print-preview-destination-settings').root.querySelector('print-preview-destination-select').root.querySelector('select.md-select');");
			//	Select destDD = new Select(destination);
				//destDD.selectByValue("Save as PDF/local/");
				//Thread.sleep(3000);
			//	driver.findElement(By.xpath(".//cr-button[@class='action-button']")).click();
				// driver.findElement(By.cssSelector(".action-button")).click();
			//	System.out.println("cancel print dialog box");
				//driver.close();
				// }
				// }
			}
		}

	}

}
