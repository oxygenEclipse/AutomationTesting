package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClass {
	public static WebDriver driver;
	public static final String FILE_PATH = "D:\\Banu\\testData.xlsx"; // File Path
	public static final String SHEET_NAME = "Data"; // Sheet name
	public static final String TABLE_NAME = "testData"; // Name of data table

	// Expected output
	public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	public static final String EXPECT_ERROR = "User or Password is not valid";

	// Browser Launch ,Window Maximization, Implicit Wait for 50 seconds

	public static WebDriver browserLaunch(String browserName, String url) throws Exception {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
			/*System.setProperty("webdriver.chrome.silentOutput", "true");
			java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);*/
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\Banu\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Banu\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Not a Valid Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}

	// Page Title
	public static String PageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Get the Current URL
	public static String currentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// Get URL
	public static WebDriver getURL(WebDriver driver, String Url) {
		driver.get(Url);
		return driver;
	}

	// Navigation Methods - Forward, Back, Refresh, Wait
	public static void navigateTo(WebDriver driver, String navigate) {
		if (navigate.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (navigate.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (navigate.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else {
			System.out.println("Method Not Supported");
		}
	}

	// Get text for a WebElement
	public static String getText(WebElement webElement) {
		return webElement.getText();
	}

	// Get Attribute Value for a WebElement
	public static String getAttributeValue(WebElement webElement, String attribute) {
		String attributeVal = webElement.getAttribute(attribute);
		return attributeVal;
	}

	// WebElement is Displayed
	public static boolean isDisplayed(WebElement webElement) {
		boolean displayed = webElement.isDisplayed();
		return displayed;
	}

	// WebElement isEnabled
	public static boolean isEnabled(WebElement webElement) {
		boolean enabled = webElement.isEnabled();
		return enabled;
	}

	// Click , WebElement isSelected
	public static boolean clickIsSelected(WebElement webElement, String check) {
		webElement.click();
		boolean selected = false;
		if (check.equalsIgnoreCase("check")) {
			selected = webElement.isSelected();
		}
		return selected;
	}

	// Click - Method Overloading

	public static void clickIsSelected(WebElement webElement) {
		webElement.click();
	}

	// Action class - Methods - Mouse Hover, Right click, Click, Double Click
	public static void actionMethods(WebDriver driver, WebElement webElement, String mouseClick) {
		Actions ac = new Actions(driver);
		if (mouseClick.equalsIgnoreCase("mouse hover")) {
			ac.moveToElement(webElement).build().perform();
		} else if (mouseClick.equalsIgnoreCase("click")) {
			ac.click(webElement).build().perform();
		} else if (mouseClick.equalsIgnoreCase("double click")) {
			ac.doubleClick(webElement).build().perform();
		} else if (mouseClick.equalsIgnoreCase("right click")) {
			ac.contextClick(webElement).build().perform();
		} else {
			System.out.println("Method Not Supported");
		}

	}

	// Action - Methods - Drag and Drop - Method Overloading

	public static void actionMethods(WebDriver driver, WebElement drag, WebElement drop) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(drag, drop).build().perform();
	}

	// Screenshot
	public static void takeScreenShot(String fileName, WebDriver driver) throws IOException {
		File des = new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, des);
	}

	// ScrollTo - Up/Down
	public static void scrollUpDown(WebDriver driver, String position) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (position.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		} else if (position.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollTo(0,0)");
		}
	}

	// Scroll By Pixel - Method Overloading

	public static void scrollUpDown(WebDriver driver, int xPixelVal, int yPixelVal) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + xPixelVal + "," + yPixelVal + ")");
	}

	// Scroll Into View - Method Overloading
	public static void scrollUpDown(WebDriver driver, WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
	}

	// Drop Down - Selection

	public static Select selectBy(WebElement webElement, String by, String value) {
		Select selectedDD = new Select(webElement);
		if (by.equalsIgnoreCase("Index")) {
			int indexValue = Integer.parseInt(value);
			selectedDD.selectByIndex(indexValue);
		} else if (by.equalsIgnoreCase("Value")) {
			selectedDD.selectByValue(value);
		} else if (by.equalsIgnoreCase("Visible Text")) {
			selectedDD.selectByVisibleText(value);
		}
		return selectedDD;

	}

	// Clear , SendKeys
	public static void sendValues(WebElement webElement, String clear, String value) {
		if (clear.equalsIgnoreCase("clear")) {
			webElement.clear();
			webElement.sendKeys(value);
		}
	}

	// SendKeys without clear - Method Overloading
	public static void sendValues(WebElement webElement, String value) {
		webElement.sendKeys(value);
	}

	// Clear without sendKey - Method Overloading
	public static void sendValues(String clear, WebElement webElement) {
		webElement.clear();
	}

	// Alerts - Simple Alert
	public static void alerts(WebElement webElement, String alertType, String alertStatus) {
		clickIsSelected(webElement);
		Alert alert = driver.switchTo().alert();
		if ((alertType.equalsIgnoreCase("simple alert") && alertStatus.equalsIgnoreCase("ok")
				|| (alertType.equalsIgnoreCase("confirm alert") && alertStatus.equalsIgnoreCase("ok")))) {
			alert.accept();
		} else if (alertType.equalsIgnoreCase("confirm alert") && alertStatus.equalsIgnoreCase("cancel")) {
			alert.dismiss();
		}
		driver.switchTo().defaultContent();
	}

	public static String[][] getDataFromExcel(String xlFilePath, String sheetName, String tableName) throws Exception {
		// Declare a 2 dimensions array to store all the test data read from
		// excel
		String[][] tabArray = null;

		// get the workbook file. Provide the path of excel file
		File excelFile = new File(xlFilePath);
		FileInputStream fileInput = new FileInputStream(excelFile);
		Workbook wb = new XSSFWorkbook(fileInput);
		// get the sheet name
		Sheet sheet = wb.getSheet(sheetName);
		int rowsCount, cellsCount;
		Row tableHeader = sheet.getRow(0);
		String tableName1 = tableHeader.getCell(0).getStringCellValue();
		int arrayColumnCount = tableHeader.getLastCellNum();
		int arrayRowCount = sheet.getLastRowNum();
		tabArray = new String[arrayRowCount][arrayColumnCount];
		if (tableName1.contains(tableName)) {
			rowsCount = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowsCount; i++) {
				Row rowData = sheet.getRow(i);
				cellsCount = rowData.getPhysicalNumberOfCells();
				for (int j = 1; j < cellsCount; j++) {
					Cell cellData = rowData.getCell(j);
					tabArray[i - 1][j - 1] = cellData.getStringCellValue();
				}
			}
		}
		wb.close();
		return (tabArray);
	}
}
