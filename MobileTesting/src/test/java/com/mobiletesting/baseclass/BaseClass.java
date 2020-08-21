package com.mobiletesting.baseclass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static final String AUTOMATE_USERNAME = "banumathisathish1";
	public static final String AUTOMATE_ACCESS_KEY = "usJq5yahjoyAvPpqvmMi";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	// Browser Launch ,Window Maximization, Implicit Wait for 50 seconds

	public static WebDriver browserLaunch(String browserName) throws Exception {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32_83\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("browserstack_mobile_web")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browserName", "Android");
		    caps.setCapability("device", "Samsung Galaxy S8");
		    caps.setCapability("realMobile", "true");
		    caps.setCapability("os_version", "7.0");
		    driver = new RemoteWebDriver(new URL(URL), caps);
		}
			else {
			throw new Exception("Not a Valid Browser Name");
		}
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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

}
