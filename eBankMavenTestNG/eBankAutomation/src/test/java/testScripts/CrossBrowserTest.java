package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void launchBrowser(String browserName) throws InterruptedException {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Banu\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Banu\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("https://www.google.com");
		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Testing");
		Thread.sleep(3000);
		driver.quit();
	}

}
