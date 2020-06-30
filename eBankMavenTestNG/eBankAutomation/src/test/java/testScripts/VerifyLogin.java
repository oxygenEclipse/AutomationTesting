package testScripts;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pom.LoginPage;
import pom.LogoutPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyLogin extends BaseClass {
	@BeforeTest
	public void browserSetUp() throws Exception {
		driver = browserLaunch("chrome", "http://www.demo.guru99.com/v4/");
	}

	@Test
	public void verifyLogin() throws Exception {
		// Read test data from excel file
		// Method getDataFromExcel is defined in class Util
		String[][] testData = getDataFromExcel(FILE_PATH, SHEET_NAME, TABLE_NAME);
		String username, password;
		String actualTitle;
		String actualBoxtitle;
		for (int i = 0; i < testData.length; i++) {
			username = testData[i][0];
			password = testData[i][1];
			LoginPage lp = new LoginPage();
			sendValues(lp.getUserId(), "clear", username);
			sendValues(lp.getUserPassword(), "clear", password);
			clickIsSelected(lp.getLogin());
			try {
				Alert alert = driver.switchTo().alert();
				actualBoxtitle = alert.getText();
				alert.accept();
				if (actualBoxtitle.contains(EXPECT_ERROR)) {
					System.out.println("Test case SS[" + i + "]: Passed");
				} else {
					System.out.println("Test case SS[" + i + "]: Failed");
				}
			} catch (NoAlertPresentException e) {
				actualTitle = driver.getTitle();
				// On Successful login compare Actual Page Title with Expected Title
				if (actualTitle.contains(EXPECT_TITLE)) {
					System.out.println("Test case SS[" + i + "]: Passed");
					LogoutPage logoutPage = new LogoutPage();
					alerts(logoutPage.getLogout(),"simple alert","ok");
				} else {
					System.out.println("Test case SS[" + i + "]: Failed");
				}
			}
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
