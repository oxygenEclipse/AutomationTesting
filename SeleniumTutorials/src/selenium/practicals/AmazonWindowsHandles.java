package selenium.practicals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonWindowsHandles {
 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone X",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")).click();
		Thread.sleep(5000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String pid : windowHandles) {
			driver.switchTo().window(pid);
			if (driver.getTitle().contains("Apple iPhone")) {
				 driver.findElement(By.id("add-to-cart-button")).click();
				 driver.findElement(By.id("hlb-ptc-btn-native")).click();
				 driver.close();
			}
		}
		Set<String> remainingWindowHandles = driver.getWindowHandles();
		for (String pId : remainingWindowHandles) {
			driver.switchTo().window(pId);
			driver.close();
		}
}
}
