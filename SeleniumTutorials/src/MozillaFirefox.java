import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaFirefox {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "D:\\Banu\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	//capabilities.setCapability("marionette", true);
	WebDriver driver = new FirefoxDriver();
	driver.navigate().to("http://www.greenstechnologys.com/");
	
}
}
