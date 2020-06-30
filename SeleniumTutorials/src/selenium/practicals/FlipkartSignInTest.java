package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSignInTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		//Locating WebElements
		
		WebElement signUp = driver.findElement(By.xpath("//a[@href=\"/account/login?signup=true\"]"));
		//click on SignUp
		signUp.click();
		
		//Locating SignUp WebElements
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@type='text' and @class='_2zrpKA _1dBPDZ']"));
		WebElement continueBtn = driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]"));
		
		//Passing Test Values
		mobileNumber.sendKeys("9962059660");
		Thread.sleep(2000);
		//click on Continue Button
		continueBtn.click();
	}

}
