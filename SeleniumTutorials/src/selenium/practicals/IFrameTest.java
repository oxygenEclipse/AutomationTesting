package selenium.practicals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame("SingleFrame");
        Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello!!");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello Hello!!");
		driver.close();
	}

}
