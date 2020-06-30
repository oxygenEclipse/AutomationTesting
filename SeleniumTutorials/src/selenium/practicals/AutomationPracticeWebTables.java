package selenium.practicals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutomationPracticeWebTables extends BaseClass {
	public static void main(String[] args) throws Exception {
		driver = browserLaunch("chrome");
		driver.get("https://demoqa.com/automation-practice-table/");
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < tableRows.size(); i++) {
			List<WebElement> tableDatas = tableRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < tableDatas.size(); j++) {
				String country = driver
						.findElement(By
								.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + (i + 1) + "]/td[" + (j + 1) + "]"))
						.getText();
				if (country.equalsIgnoreCase("China")) {
					System.out.println(driver
							.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + (i + 1) + "]/td[5]"))
							.getText());
				}
			}
		}

		// Print last 2 rows of the table
		for (int i = tableRows.size() - 2; i < tableRows.size(); i++) {
			System.out.println(tableRows.get(i).getText());
		}

		// Print first 2 rows of the table
		for (int i = 0; i < 2; i++) {
			System.out.println(tableRows.get(i).getText());
		}
	}
}
