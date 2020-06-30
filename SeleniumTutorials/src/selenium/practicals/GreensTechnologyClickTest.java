package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreensTechnologyClickTest {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://greenstech.in/selenium-course-content.html");
	
	//Locating WebElements
//	WebElement CTSQnslink = driver.findElement(By.xpath("//a[@href='http://greenstech.in/interview-questions/cts.pdf#toolbar=0']"));
	
	//Click on the link CTS Interview Questions
//	CTSQnslink.click();
	
	WebElement coreJavaMaterial = driver.findElement(By.xpath("//a[@href=\"http://traininginchennai.in/core%20java%20material.pdf\"]"));
	coreJavaMaterial.click();
	Thread.sleep(2000);
	
	//Close the application
	driver.quit();
}
}
