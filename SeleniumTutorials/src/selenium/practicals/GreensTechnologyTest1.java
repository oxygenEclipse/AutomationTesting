package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreensTechnologyTest1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.greenstechnologys.com/");
		WebElement contactUs = driver.findElement(By.xpath("//a[@href='contact.php']"));
		contactUs.click();
		Thread.sleep(2000);

		// Locating WebElements

		WebElement name = driver.findElement(By.id("InputName"));
		WebElement email = driver.findElement(By.id("InputEmail1"));
		WebElement subject = driver.findElement(By.id("InputSubject"));
		WebElement courses = driver.findElement(By.xpath("//select[@name='courses']"));
		WebElement branch = driver.findElement(By.xpath("//select[@name='branch']"));
		WebElement time = driver.findElement(By.xpath("//select[@name='time']"));
		WebElement msg = driver.findElement(By.xpath("//textarea[@class='form-control input-message']"));
		WebElement submitBtn = driver.findElement(By.id("submit"));

		// Passing Test Values

		name.sendKeys("Banumathi");
		email.sendKeys("itsbanumathi@gmail.com");
		subject.sendKeys("9962059660");
		courses.sendKeys("Selenium");
		branch.sendKeys("OMR");
		time.sendKeys("In a Month");
		msg.sendKeys("Enquiry on Selenium Software Testing");

		Thread.sleep(2000);
		
		// Click on Submit Button
		
		submitBtn.click();
		
		Thread.sleep(2000);
		
		// quit the Application
		
		driver.quit();

	}
}
