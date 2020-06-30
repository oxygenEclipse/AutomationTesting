package selenium.practicals;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipKartMenuDisplay {

	public static void main(String[] args) throws InterruptedException {
		String menuNameStr = "", subMenuItemLC = "", productCost = "";
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement closeButton = driver.findElement(By.xpath("//div[@class=\"_3Njdz7\"]/button"));
		closeButton.click();
	//	List<WebElement> menuItems = driver.findElements(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']"));
		WebElement menu = driver.findElement(By.xpath("(//span[@class='_1QZ6fC _3Lgyp8'])[1]"));
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
	//	for (WebElement menu : menuItems) {
			ac.moveToElement(menu).build().perform();
			menuNameStr = menu.getText();
			System.out.println(menuNameStr);
			ac.click(menu).build().perform();
			List<WebElement> subMenuItem = driver.findElements(By.xpath("//li[@class='_1KCOnI _2BfSTw _1h5QLb _3ZgIXy']/a[(text()!='') and (contains(@href,'" + menuNameStr + "'))]"));
			System.out.println(subMenuItem.size());
			for (WebElement subMenu : subMenuItem) {
				System.out.println(subMenu.getText().trim());
				if(driver.findElement(By.xpath(".//../following-sibling::li[@class='_1KCOnI _3ZgIXy']/a/span")).isDisplayed()) {
					System.out.println("Only SubMenu");
				}
				else {
					System.out.println("Has Child : " +driver.findElement(By.xpath(".//../following-sibling::li[@class='_1KCOnI _3ZgIXy']/a")).getText());
				}
			}
			}
		//}
	}
