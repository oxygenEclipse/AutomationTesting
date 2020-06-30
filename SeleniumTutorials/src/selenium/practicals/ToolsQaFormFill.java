package selenium.practicals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQaFormFill {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		// Locating the WebElements

		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement genderRadioBtn = driver.findElement(By.xpath("//input[@type='radio' and @value='Female']"));
		//WebElement experienceRadioBtn = driver
			//	.findElement(By.xpath("//input[@type='radio' and @value='6' and @id='exp-5']"));
		WebElement datepickerText = driver.findElement(By.id("datepicker"));
		List<WebElement> professionCheckBox = driver
				.findElements(By.xpath("//input[@type='checkbox' and @name='profession']"));

		// Passing Test Values

		firstName.sendKeys("Banumathi");
		lastName.sendKeys("Sathish Kumar");
		if (genderRadioBtn.isDisplayed()) {
			System.out.println("Gender Radio Button is Displayed");
			genderRadioBtn.click();
			boolean selected = genderRadioBtn.isSelected();
			System.out.println(selected);
		}
	/*	if (experienceRadioBtn.isDisplayed()) {
			System.out.println("Experience Radio Button is Displayed");
			experienceRadioBtn.click();
			boolean selected = experienceRadioBtn.isSelected();
			System.out.println(selected);
		}*/
		datepickerText.sendKeys("23/02/2020");
		for (WebElement professionClick : professionCheckBox) {
			professionClick.click();

		}

	}

}
