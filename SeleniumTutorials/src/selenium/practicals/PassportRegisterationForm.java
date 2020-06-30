package selenium.practicals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PassportRegisterationForm {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumTutorials\\Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://portal2.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction?request_locale=en");
		
		// Locating WebElements
		
		//WebElement location = driver.findElement(By.id("cpvLocation13"));
		WebElement cpvLocation = driver.findElement(By.id("cpvLocationPO"));
		WebElement locationList = driver.findElement(By.id("dcdrLocation"));
		Select locationDD = new Select(locationList);
		WebElement givenName = driver.findElement(By.id("givenName"));
		WebElement surName = driver.findElement(By.id("surname"));
		WebElement dob = driver.findElement(By.id("dob"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement emailLoginRadioBtn = driver.findElement(By.id("emailloginSameyes"));
		WebElement loginId = driver.findElement(By.id("loginId"));
		WebElement pwd = driver.findElement(By.id("pwd"));
		WebElement confirmPwd = driver.findElement(By.id("confirmPwd"));
		WebElement hintQues = driver.findElement(By.id("hintQues"));
		Select hintQuesSelect=new Select(hintQues);
		WebElement hintAns = driver.findElement(By.id("hintAns"));
		
		// Passing Test Values
		
		cpvLocation.click();
		locationDD.selectByValue("26");
		givenName.sendKeys("Test Name");
		surName.sendKeys("Test Surname");
		dob.sendKeys("23/02/2020");
		Thread.sleep(1000);
		email.sendKeys("abctest@gmail.com");
		emailLoginRadioBtn.click();
		loginId.sendKeys("login");
		pwd.sendKeys("pwdlogin1");
		confirmPwd.sendKeys("pwdlogin1");
		hintQuesSelect.selectByValue("Mother's Maiden Name");
		hintAns.sendKeys("Test abc");
		
		Thread.sleep(2000);
		List<WebElement> locationListAll = locationDD.getOptions();
		for (WebElement locationAll : locationListAll) {
			System.out.println(locationAll.getText());
		}
		driver.quit();
		
	}

}
