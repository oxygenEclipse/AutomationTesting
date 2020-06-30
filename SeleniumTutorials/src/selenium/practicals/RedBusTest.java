package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RedBusTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.redbus.in/");
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.id("src"));
		WebElement to = driver.findElement(By.id("dest"));
		from.sendKeys("Chennai");
		to.sendKeys("Salem");
		
		
	}

}
