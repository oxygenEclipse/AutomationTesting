package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class ParallelBrowserLaunch extends BaseClass {
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeTest(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Banu\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Banu\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("https://www.google.com");
	}
	@Test
	public void launchBrowser() throws Exception {
		driver.findElement(By.name("q")).sendKeys("TestNG");
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
