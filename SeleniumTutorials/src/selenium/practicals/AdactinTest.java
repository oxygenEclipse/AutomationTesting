package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdactinTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.adactin.com/HotelApp/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("abc@123.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("@1234");
		Thread.sleep(2000);
		driver.quit();
	}

}
