package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest extends BaseClass{
	public static void main(String[] args) throws Exception  {
		/*System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();*/
		WebDriver driver = browserLaunch("chrome");	
		driver.get("https://www.facebook.com/");
		
		//Locating WebElements Email,Password and Login Button
		
		WebElement emailAddress = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		//Passing Test Values
		
		emailAddress.sendKeys("itsbanumathig@gmail.com");
		password.sendKeys("vis1234ba$$");
		
		String emailString = emailAddress.getAttribute("value");
		String passwordString = password.getAttribute("value");
		
		Thread.sleep(2000);
		
		System.out.println(emailString);
		System.out.println(passwordString);
		
		//Click Login Button
		loginBtn.click();
		
		//Quit
		driver.quit();
		
		
		
	}
	
}
