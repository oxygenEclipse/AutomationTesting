package selenium.practicals;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FlipkartSignInTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://naukri.com");
		System.out.println(driver.getWindowHandles());
		String pid = driver.getWindowHandle();
		System.out.println("parent id : " + pid);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String cid : windowHandles) {
			if(!cid.equals(pid)) {
				driver.switchTo().window(cid);
				driver.close();
			}
		}
		//driver.get("https://www.flipkart.com/");
		// Locating WebElements

		/*
		 * WebElement signUp =
		 * driver.findElement(By.xpath("//a[@href=\"/account/login?signup=true\"]"));
		 * //click on SignUp signUp.click();
		 * 
		 * //Locating SignUp WebElements WebElement mobileNumber =
		 * driver.findElement(By.
		 * xpath("//input[@type='text' and @class='_2zrpKA _1dBPDZ']")); WebElement
		 * continueBtn =
		 * driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]"));
		 * 
		 * //Passing Test Values mobileNumber.sendKeys("9962059660");
		 * Thread.sleep(2000); //click on Continue Button continueBtn.click();
		 */
	}

}
