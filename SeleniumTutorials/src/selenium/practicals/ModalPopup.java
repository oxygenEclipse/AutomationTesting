package selenium.practicals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Modals.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	/*	driver.findElement(By.xpath("//a[@href='#myModalMulti' and text()='Launch modal']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[@href='#myModal2' and text()='Launch modal']")).click();
		WebElement close = driver.findElement(By.xpath(".//a[@class='btn' and text()='Close']"));
		Actions ac = new Actions(driver);
		Thread.sleep(3000);
		ac.moveToElement(close).build().perform();		
		ac.click(close);
		Thread.sleep(3000);*/
		driver.findElement(By.xpath("//a[@href='#myModal']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//div[@class='modal-body']/button[@class='btn btn-default']")).click();
		Thread.sleep(3000);
		driver.close();
		
	}

}
