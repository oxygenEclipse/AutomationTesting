package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwiggyTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		//driver.navigate().to("https://www.swiggy.com/");
		WebElement location = driver.findElement(By.id("location"));
		location.sendKeys("Anna Nagar, Chennai");
		WebElement findFood = driver.findElement(By.xpath("//span[text()='FIND FOOD']"));
		findFood.click();
		//Actions ac = new Actions(driver);
		//ac.click(findFood).build().perform();
		
		
	}

}
