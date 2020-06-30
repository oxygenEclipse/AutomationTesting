package selenium.practicals;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartMenuMouseOver {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement closeButton = driver.findElement(By.xpath("//div[@class=\"_3Njdz7\"]/button"));
		closeButton.click();
		/*
		 * Scanner userInput = new Scanner(System.in);
		 * System.out.println("Enter the Menu Name"); String menuName =
		 * userInput.nextLine(); System.out.println("Enter the Sub Menu Item"); String
		 * subMenuName = userInput.nextLine(); WebElement menuItem = driver
		 * .findElement(By.
		 * xpath("//span[@class='_1QZ6fC _3Lgyp8' and (contains(text(),'" + menuName +
		 * "'))]")); Actions ac = new Actions(driver); Thread.sleep(2000);
		 * ac.moveToElement(menuItem).build().perform();; WebElement subMenuItem =
		 * driver.findElement(By.
		 * xpath("//ul[@class=\"_2OZ78M _1fj2FQ\"]/li/ul/li/a[text() = '" + subMenuName
		 * + "' and (contains(@href,'" + menuName + "'))]"));
		 * ac.click(subMenuItem).build().perform(); userInput.close();
		 */

		// driver.quit();
		String menuNameStr = "", subMenuItemLC = "", productCost = "";
		List<WebElement> menuItems = driver.findElements(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']"));
		Actions ac = new Actions(driver);
		Thread.sleep(2000);
		for (WebElement menu : menuItems) {
			ac.moveToElement(menu).build().perform();
			menuNameStr = menu.getText();
			System.out.println(menuNameStr);
			ac.click(menu).build().perform();
			List<WebElement> subMenuItem = driver.findElements(
					By.xpath("//ul[@class='_2OZ78M _1fj2FQ']/li/ul/li/a[contains(@href,'" + menuNameStr + "')]/span"));
			int subMenuCount = subMenuItem.size();
			for (int i = 1; i < subMenuCount; i++) {
				WebElement subMenuItemStr = driver
						.findElement(By.xpath("(//ul[@class='_2OZ78M _1fj2FQ']/li/ul/li/a[contains(@href,'"
								+ menuNameStr + "')]/span/..)[" + i + "]"));
				subMenuItemLC = subMenuItemStr.getAttribute("title");
				System.out.println(subMenuItemLC);
				if(subMenuItemStr.findElement(By.xpath("./../following-sibling::li/a/span")).isDisplayed()) {
					ac.click(subMenuItemStr).build().perform();
				}
				else {
				WebElement product = driver
						.findElement(By.xpath("((//ul[@class='_2OZ78M _1fj2FQ']/li/ul/li/a[contains(@href,'"
								+ menuNameStr + "')]/span/..)[" + i + "]/../following-sibling::li/a)[1]"));
				System.out.println("Product : " + product.getText());
				// WebElement product = driver.findElement(By.xpath("(//ul[@class='_2OZ78M
				// _1fj2FQ']/li/ul/li/a[contains(@href,'"
				// + subMenuItemLC + "') and (@title!='" + subMenuItemStr + "')])[1]"));
				// ac.moveToElement(product).build().perform();
				// System.out.println(product.getText());
				ac.click(product).build().perform();
				}
				Thread.sleep(3000);
				// productCost =
				// driver.findElement(By.cssSelector("._1vC4OE._2rQ-NK")).getText();
				// System.out.println(productCost);
				driver.navigate().back();
				ac.moveToElement(menu).build().perform();
				ac.click(menu).build().perform();
			}
		}
		driver.close();
	}
}
