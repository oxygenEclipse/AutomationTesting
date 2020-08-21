package selenium.practicals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(js.executeScript("return document.readyState").toString().equals("complete"))
			System.out.println("Page is loaded");
		else
			System.out.println("Page is not loaded");
	}

}
