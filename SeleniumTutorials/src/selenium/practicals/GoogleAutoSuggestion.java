package selenium.practicals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoSuggestion {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		//Locate the WebElement Search
		
		WebElement searchText = driver.findElement(By.name("q"));
		
		//Send the Search Text
		
		searchText.sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement> searchAutoSuggestionList = driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
		System.out.println(searchAutoSuggestionList.size());
		for(WebElement searchOptions:searchAutoSuggestionList) {
			System.out.println(searchOptions.getText());
		}
		
		
	}

}
