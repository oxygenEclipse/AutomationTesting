import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer {
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "D:\\Banu\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://www.greenstechnologys.com/");
		driver.close();//driver.close() is not working
	}

}
