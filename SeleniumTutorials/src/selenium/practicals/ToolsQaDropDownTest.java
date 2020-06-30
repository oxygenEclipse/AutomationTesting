package selenium.practicals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToolsQaDropDownTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		WebElement seleniumCommands = driver.findElement(By.id("selenium_commands"));
		Select seleniumCommandDD = new Select(seleniumCommands);

		// Print all the Options in Selenium Commands

		List<WebElement> listOfCommands = seleniumCommandDD.getOptions();
		for (WebElement commandsList : listOfCommands) {
			System.out.println(commandsList.getText());
		}

		// Print the even options in Selenium Commands

		System.out.println("\nEven Options in Selenium Commands");
		for (int i = 0; i < listOfCommands.size(); i++) {
			if ((i + 1) % 2 == 0) {
				WebElement ddString = listOfCommands.get(i);
				System.out.println(ddString.getText());
			}
		}

		// Print the odd options in Selenium Commands

		System.out.println("\nOdd Options in Selenium Commands");
		for (int i = 0; i < listOfCommands.size(); i++) {
			if ((i + 1) % 2 != 0) {
				WebElement ddString = listOfCommands.get(i);
				System.out.println(ddString.getText());
			}
		}

		// Print all the Option in Continents Multi-select DD

		WebElement continentsMultiSelect = driver.findElement(By.id("continentsmultiple"));
		Select continentMultiDD = new Select(continentsMultiSelect);
		boolean IsmultipleDD = continentMultiDD.isMultiple();
		if(IsmultipleDD) {
			List<WebElement> multipleListDD = continentMultiDD.getOptions();
			System.out.println("\nMutilple Select Options");
			for (WebElement x : multipleListDD) {
				System.out.println(x.getText());
			}
		}

	}

}
