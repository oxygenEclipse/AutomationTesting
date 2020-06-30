package firsttestngpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTest {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "D:\\Banu\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test(priority = 3)
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1,groups="title")
	public void verifyMenuTitle() {
		String expectedMenuTitle = "Menu";
		Assert.assertEquals("Test", expectedMenuTitle);
	}

	@Test(groups="title")
	public void verifyTitle() {
		String title = "Title";
		Assert.assertEquals("title", title);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}