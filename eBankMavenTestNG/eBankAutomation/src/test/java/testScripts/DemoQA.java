package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class DemoQA extends BaseClass {
	WebDriver driver;

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = browserLaunch("chrome", "https://demoqa.com/automation-practice-form/");
	}*/

	@DataProvider(name="data")
	public String[][] testData() {
		//instead of String we can use Object[][] to accept any data type.
		//return new Object[][] {{"test@abc.com",1234},{"test1@abc.com",1254}};
		return new String[][] {{"test@abc.com","password1"},{"test1@abc.com","password2"}};
	}
	@Test(dataProvider="data")
	public void registrationForm(String userName, String password) {
		System.out.println(userName);
		System.out.println(password);
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void tearDown() {
	//	driver.close();
	}

}
