package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusSignUpTest {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.redbus.in/");
	
	//Locating WebElements for Signup
	
	WebElement signInIcon = driver.findElement(By.id("sign-in-icon-down"));
	WebElement signInLink = driver.findElement(By.xpath("//li[@id = 'signInLink']"));
	
	//Clicking the SignIn Link
	
	signInIcon.click();
	Thread.sleep(2000);
	signInLink.click();
	
	//Quit the Application
	
	driver.quit();
}
}
