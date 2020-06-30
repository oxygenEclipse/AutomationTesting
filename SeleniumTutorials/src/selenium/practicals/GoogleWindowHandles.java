package selenium.practicals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleWindowHandles {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Actions ac = new Actions(driver);
		Robot rc = new Robot();
		System.out.println(driver.getTitle());
		WebElement googleSearchText = driver.findElement(By.name("q"));
		WebElement gmail = driver.findElement(By.xpath("//a[text()='Gmail']"));
		WebElement images = driver.findElement(By.xpath("//a[text()='Images']"));
		ac.contextClick(gmail).build().perform();
		rc.keyPress(KeyEvent.VK_DOWN);
		rc.keyRelease(KeyEvent.VK_DOWN);
		rc.keyPress(KeyEvent.VK_DOWN);
		rc.keyRelease(KeyEvent.VK_DOWN);
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);

		ac.contextClick(images).build().perform();
		rc.keyPress(KeyEvent.VK_DOWN);
		rc.keyRelease(KeyEvent.VK_DOWN);
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);

		googleSearchText.sendKeys("Samsung Latest Mobile Phones 2020");
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for (String pid : windowHandles) {
			System.out.println(pid);
			driver.switchTo().window(pid);
			if (driver.getTitle().equalsIgnoreCase("Gmail - Email from Google")) {
				System.out.println("Third - Gmail");
				driver.findElement(By.xpath("(//a[ contains(text(), 'Sign in')])[2]")).click();
				Thread.sleep(15000);
				driver.switchTo().window(pid);
				driver.close();
			} else if (driver.getTitle().equalsIgnoreCase("Google Images")) {
				driver.findElement(By.name("q")).sendKeys("Samsung latest mobile phones");
				System.out.println("Second - Google Images");
				rc.keyPress(KeyEvent.VK_ENTER);
				rc.keyRelease(KeyEvent.VK_ENTER);
				driver.findElement(By.xpath("(//span[contains(text(),'Samsung Galaxy M31')])[1]")).click();
				Thread.sleep(15000);
				driver.switchTo().window(pid);
				driver.close();
			} else /* if(driver.getTitle().equalsIgnoreCase("Google")) */ {
				System.out.println("First  - Google");
				driver.findElement(By.xpath("(//span[contains(text(),'Samsung Galaxy S20')])[1]")).click();
				Thread.sleep(15000);
				driver.switchTo().window(pid);
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
