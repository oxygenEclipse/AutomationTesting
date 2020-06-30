package selenium.practicals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://demo.automationtesting.in/FileUpload.html");
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*driver.findElement(By.xpath("//input[@id='input-4' and @type='file']")).sendKeys("D:\\TestFileUpload.txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='input-4' and @type='file']")).sendKeys("D:\\TestFileUpload - Copy.txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='input-4' and @type='file']")).sendKeys("D:\\TestFileUpload - Copy (2).txt");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);*/
		
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("D:\\TestFileUpload.txt");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
		
	}

}
