package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriver {

	public static void main(String[] args) {

		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.name("q"));
		search.clear();
		search.sendKeys("Selenium Concepts");
		search.submit();
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
