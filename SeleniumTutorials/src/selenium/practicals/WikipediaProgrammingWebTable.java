package selenium.practicals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaProgrammingWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Programming_languages_used_in_most_popular_websites");
		Thread.sleep(10000);
		List<WebElement> tables = driver.findElements(By.tagName("table"));
		WebElement table = tables.get(0);
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trows = tbody.findElements(By.tagName("tr"));
		List<String> tdataValue = new ArrayList<String>();
		for (WebElement trow : trows) {
			List<WebElement> tdatas = trow.findElements(By.tagName("td"));
			tdataValue.add(tdatas.get(0).getText());
		}
		Collections.sort(tdataValue);
		List<WebElement> trows1 = tbody.findElements(By.tagName("tr"));
		for (WebElement trows2 : trows1) {
			List<WebElement> tdatas = trows2.findElements(By.tagName("td"));
			for (int i = 0; i < tdatas.size(); i++) {
				if (tdataValue.contains(tdatas.get(0).getText())) {
					WebElement tdata = tdatas.get(i);
					System.out.print(tdata.getText() + "\t\t");
				}
			}
			System.out.println("");
		}

		driver.quit();
	}
}