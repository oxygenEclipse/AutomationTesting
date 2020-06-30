package selenium.practicals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreensTechText {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	/*	driver.get("http://www.greenstechnologys.com");

		// Locating WebElement
		WebElement overview = driver.findElement(By.xpath("//div[@class=\"box\"]/div"));
		String overviewText = overview.getAttribute("innerText");
		String overviewText1 = overview.getAttribute("textContent");
		System.out.println("Text Content : " + overviewText1);
		System.out.println("Inner Text : " + overviewText);

		WebElement paragraph3 = driver.findElement(
				By.xpath("(//p[@style=\"text-align:justify; font-size:18px;\"])[3]"));
		String paraText = paragraph3.getText();
		String paraText1 = paragraph3.getAttribute("innerText");
		String colorValue = paragraph3.getCssValue("color");
		String bgColorValue = paragraph3.getCssValue("background-color");
		String ffValue = paragraph3.getCssValue("font-family");
		String fontSizeValue = paragraph3.getCssValue("font-size");
		System.out.println("Inner Text :" + paraText1);
		
		System.out.println(paraText);
		System.out.println(colorValue);
		System.out.println(bgColorValue);
		System.out.println(ffValue);
		System.out.println(fontSizeValue);
		
		String paragraph2 = driver.findElement(By.xpath("(//p[@style=\"text-align:justify; font-size:18px;\"])[2]")).getAttribute("innerText");
		String paragraph1 = driver.findElement(By.xpath("(//p[@style=\"text-align:justify; font-size:18px;\"])[1]")).getAttribute("innerText");
		
		System.out.println(paragraph1);
		System.out.println(paragraph2);
		
		String omrAddress = driver.findElement(By.xpath("(//div[@class=\"trainer-info\"]/p)[2]")).getAttribute("innerText");
		System.out.println(omrAddress);*/
		driver.get("https://www.demoblaze.com/");
		String text = driver.findElement(By.xpath("(//div[@class='caption'])[3]")).getText();
		System.out.println(text);
		driver.quit();
	}
}
