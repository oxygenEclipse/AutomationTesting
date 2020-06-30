package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CrossBrowserTestMethod {
	WebDriver driver;

	@Test
	public void chromeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver : " + driver);
		driver.get("https://www.google.com");
		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Testing");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void firefoxBrowser() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\Banu\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Driver : " + driver);
		driver.get("https://www.google.com");
		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Testing");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(enabled = false)
	public void firefoxBrowserFaceBook() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\Banu\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Driver : " + driver);
		driver.get("https://www.facebook.com/");
		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.name("email")).sendKeys("Testing");
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(enabled = false)
	public void chromeBrowserFaceBook() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver : " + driver);
		driver.get("https://www.facebook.com/");
		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.name("email")).sendKeys("Testing");
		Thread.sleep(3000);
		driver.quit();
	}

}
