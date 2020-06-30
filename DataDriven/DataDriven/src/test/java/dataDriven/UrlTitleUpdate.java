package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlTitleUpdate {

	public static String getPageTitle(String url) {
		String pageTitle = null;
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		driver.get(url);
		pageTitle = driver.getTitle();
		driver.quit();
		return pageTitle;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\Url_Title - Copy.xlsx");
		FileInputStream fin = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet s = wb.getSheet("UrlTitle");
		String url = null, pageTitle = null;
		int rowsCount = s.getPhysicalNumberOfRows();
		for (int i = 1; i < rowsCount; i++) {
			Row row = s.getRow(i);
			url = row.getCell(0).getStringCellValue();
			pageTitle = getPageTitle(url);
			Cell cell = row.getCell(1);
			if ((cell != null) && (!cell.getStringCellValue().equals(pageTitle))) {
				cell.setCellValue(pageTitle);
			} else if (cell == null) {
				cell = row.createCell(1);
				cell.setCellValue(pageTitle);
			}
		}
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		wb.close();
	}
}
