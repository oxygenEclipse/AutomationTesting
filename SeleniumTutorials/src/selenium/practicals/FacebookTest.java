package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//WebElement username = driver.findElement(By.id("email"));
		WebElement usernameCss = driver.findElement(By.cssSelector("input[id=email]"));
		usernameCss.sendKeys("itsbanumathig@gmail.com");
	}

}
