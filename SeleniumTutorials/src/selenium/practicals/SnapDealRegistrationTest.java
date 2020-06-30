package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDealRegistrationTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		signIn.click();
		Thread.sleep(2000);
		
		WebElement newUserRegister = driver.findElement(By.xpath("//span[@class='newUserRegister']"));
		newUserRegister.click();
		
		WebElement mobileNumber = driver.findElement(By.id("userName"));
		mobileNumber.clear();
		mobileNumber.sendKeys("9962059660");
		
		WebElement continueBtn = driver.findElement(By.id("checkUser"));
		continueBtn.click();
		
		
		
		
	}

}
