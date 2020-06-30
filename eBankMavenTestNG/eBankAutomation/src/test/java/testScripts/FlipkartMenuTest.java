package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class FlipkartMenuTest extends BaseClass {
	@BeforeTest
	public void browserSetUp() throws Exception {
		driver = browserLaunch("chrome", "https://www.flipkart.com/");
		driver.findElement(By.xpath("//div[@class=\"_3Njdz7\"]/button")).click();
	}

	@Test
	public void flipKartMenu() throws InterruptedException {
		String menuNameStr = "", subMenuItemStr = "", subMenuItemLC = "", productCost = "";
		List<WebElement> menuItems = driver.findElements(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']"));
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
		for (WebElement menu : menuItems) {
			ac.moveToElement(menu).build().perform();
			menuNameStr = menu.getText();
			List<WebElement> subMenuItem = driver.findElements(
					By.xpath("//ul[@class='_2OZ78M _1fj2FQ']/li/ul/li/a[contains(@href,'" + menuNameStr + "')]/span"));
			for (WebElement subMenu : subMenuItem) {
				subMenuItemStr = subMenu.getText();
				subMenuItemLC = subMenuItemStr.toLowerCase();
				driver.findElement(By.xpath("(//ul[@class='_2OZ78M _1fj2FQ']/li/ul/li/a[contains(@href,'"
						+ subMenuItemLC + "') and (@title!='" + subMenuItemStr + "')])[1]")).click();
				productCost = driver.findElement(By.xpath("(//div[@class='_1vC4OE _2rQ-NK'])[1]")).getText();
				System.out.println(productCost);
				driver.navigate().back();
			}

		}
	}

@AfterTest
public void tearDown() {
	driver.close();
}
}