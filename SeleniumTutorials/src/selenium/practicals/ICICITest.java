package selenium.practicals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICICITest {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	/*driver.get("https://infinity.icicibank.com/corp/Login.jsp");
	WebElement username = driver.findElement(By.name("DUMMY1"));
	username.sendKeys("abc@123.com");
	//WebElement pass = driver.findElement(By.name("AuthenticationFG.ACCESS_CODE"));
	//pass.sendKeys("abc@123");
	driver.close();*/
	
}
}
