package selenium.practicals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDealWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.name("keyword")).sendKeys("iphone 7", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//p[contains(text(),'Apple iPhone 7')])[1]")).click();
		Thread.sleep(5000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for (String pid : windowHandles) {
			System.out.println(pid);
			driver.switchTo().window(pid);
			if (driver.getTitle().contains("iPhone 7")) {
				String rupeeSymbol = driver.findElement(By.xpath("//span[@class='pdp-final-price']")).getText();
				System.out.println(rupeeSymbol);
				driver.findElement(By.xpath("//span[text() = 'add to cart']")).click();
				driver.close();
			}
		}
		driver.quit();
	}
}
