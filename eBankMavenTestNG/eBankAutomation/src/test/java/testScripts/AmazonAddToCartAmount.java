package testScripts;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import baseClass.BrandTestData;

public class AmazonAddToCartAmount extends BaseClass {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		driver = browserLaunch("chrome", "https://www.amazon.in/");
	}

	@DataProvider(name = "BrandNameSearchData")
	public String[] brandNameSearchData() throws IOException {
		String brandName[] = BrandTestData.getBrandName("D:\\AmazonAddToCartValidation.xlsx");
		return (brandName);
	}

	@Test(dataProvider = "BrandNameSearchData")
	public void addToCart(String brandName) throws IOException {
		System.out.println("Brand Name From Data Provider : " + brandName);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName + " phones"); // search box
		driver.findElement(By.xpath("//input[@value='Go']")).click(); // enter search
		String parentId = driver.getWindowHandle();
		driver.findElements(By.cssSelector(".a-link-normal.a-text-normal>span")).get(0).click();
		// New Tab is opened
		Set<String> processId = driver.getWindowHandles();
		for (String id : processId) {
			if (id != parentId)
				driver.switchTo().window(id);
		}
		String prodName = driver.findElement(By.id("productTitle")).getText().trim(); // get the product name
		String prodCost = driver.findElement(By.id("priceblock_ourprice")).getText().trim(); // get the product cost
		driver.findElement(By.id("add-to-cart-button")).click(); // click on add to cart button
		String cartAmt = driver.findElement(By.cssSelector(".a-color-price.hlb-price.a-inline-block.a-text-bold"))
				.getText().substring(1).replace(",", "");
		// get the cart amount
		driver.close();
		driver.switchTo().window(parentId);
		driver.navigate().refresh();
		if (Float.parseFloat(cartAmt) >= 200000.00) {
			// if cart amount is greater than 2 lakh then go to cart and remove the last
			// item
			String pid = driver.getWindowHandle();
			driver.findElement(By.id("nav-cart-count")).click();
			Set<String> cpid = driver.getWindowHandles();
			for (String id : cpid) {
				if (id != pid)
					driver.switchTo().window(id);
			} // remove the product from the cart
			driver.findElements(By.xpath("//input[@value='Delete']")).get(0).click();
			driver.close();
			driver.switchTo().window(pid);
			driver.navigate().refresh();
		} else
			BrandTestData.updateBrandDetails("D:\\AmazonAddToCartValidation.xlsx", brandName, prodName, prodCost,
					cartAmt);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();;
	}
}
