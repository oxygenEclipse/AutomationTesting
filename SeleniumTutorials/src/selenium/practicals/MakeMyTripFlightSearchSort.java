package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripFlightSearchSort {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		WebElement fromCity = driver.findElement(By.id("fromCity"));
		WebElement toCity = driver.findElement(By.id("toCity"));
		WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
		fromCity.click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("Chennai");
        toCity.click();
        WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
        to.sendKeys("Delhi");
        WebElement departure = driver.findElement(By.id("departure"));
        departure.click();
        WebElement date = driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--selected']"));
        date.click();
        search.click();
	}

}
