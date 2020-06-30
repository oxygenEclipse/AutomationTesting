package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearTripTest {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.cleartrip.com/trains");
	
	// Locating WebElements for Train Search
	
	WebElement fromStation = driver.findElement(By.id("from_station"));
	WebElement toStation = driver.findElement(By.id("to_station"));
	WebElement trainClass = driver.findElement(By.id("trainClass"));
	WebElement departureDate = driver.findElement(By.id("dpt_date"));
	WebElement adultsCount = driver.findElement(By.id("train_adults"));
	WebElement childrenCount = driver.findElement(By.id("train_children"));
	WebElement maleSeniorsCount = driver.findElement(By.id("train_male_seniors"));
	WebElement femaleSeniorsCount = driver.findElement(By.id("train_female_seniors"));
	WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	
	//Locating WebElement to select the date
	
	//WebElement dateSelection = driver.findElement(By.xpath("//img[@title=\"Click to open calendar\"]"));
	//WebElement selectedDate = driver.findElement(By.xpath("//a[text()='21']"));
	
	//Passing Test Values
	
	fromStation.sendKeys("Salem");
	toStation.sendKeys("Chennai");
	trainClass.sendKeys("First Class (FC)");
	departureDate.clear();
	//departureDate.sendKeys("22/02/2020");
	
	/*dateSelection.click();
	Thread.sleep(1000);
	selectedDate.click();
	Thread.sleep(500);*/
	
	adultsCount.sendKeys("2");
	childrenCount.sendKeys("2");
	maleSeniorsCount.sendKeys("0");
	femaleSeniorsCount.sendKeys("2");
	Thread.sleep(2000);
	
	// Click on Search Button
	
	searchBtn.click();
}
}
