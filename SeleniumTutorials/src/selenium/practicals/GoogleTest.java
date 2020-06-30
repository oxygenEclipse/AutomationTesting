package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "D:\\Banu\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys("GreensTechnology");
		driver.quit();
		
	}

}
