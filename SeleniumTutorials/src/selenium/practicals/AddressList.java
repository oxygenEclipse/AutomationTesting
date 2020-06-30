package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressList extends BaseClass {
	public static void main(String[] args) throws Exception {
		WebDriver driver = browserLaunch("chrome");
		driver.get("http://automationpractice.com/index.php");
		
		WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		clickIsSelected(signIn);
		
		WebElement emailId = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("passwd"));
		WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
		sendValues(emailId,"clear","automation@abc.com");
		sendValues(password,"clear","1234abc");
		clickIsSelected(submitLogin);
		driver.navigate().to("http://automationpractice.com/index.php?controller=order&step=1");
		
		
	}

}
