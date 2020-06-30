import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Banu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("http://www.amazon.in");
        driver.get("http://www.amazon.in");
        
        //search text box in the HomePage
     /*   WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Kids Shoes");
        WebElement go = driver.findElement(By.xpath("//input[@type='submit']"));
        go.click();*/
        
        // Returns link in HomePage
     /*   WebElement returns = driver.findElement(By.xpath("//span[text()='Returns']"));
        returns.click();*/
        
        // Click on Today's Deals Menu
      /*  WebElement todaysDeals = driver.findElement(By.xpath("//a[contains(text(),'Deals')]"));
        todaysDeals.click();*/
        //Click on Hello Sign in
        WebElement helloSignIn = driver.findElement(By.xpath("//span[contains(text(),'Hello')]"));
       // helloSignIn.click();
        Actions ac = new Actions(driver);
       ac.moveToElement(helloSignIn).build().perform();
        WebElement createList = driver.findElement(By.xpath("//span[text()='Create a List']"));
        ac.moveToElement(createList).build().perform();
       // ac.click(signIn).build().perform();
       // signIn.click();
       // driver.close();
}
}