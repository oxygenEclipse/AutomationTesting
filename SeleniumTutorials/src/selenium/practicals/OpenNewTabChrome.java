package selenium.practicals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTabChrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//using Link in Parent Window
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//a[text()='Gmail']")).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
		driver.quit();

		//using JavascriptExecutor to open New Blank Tab
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('https://www.google.com/','_blank');");
		driver.quit();
		
	}

}
