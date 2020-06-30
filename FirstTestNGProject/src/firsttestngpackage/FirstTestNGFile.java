package firsttestngpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
  @Test(groups="login",dependsOnGroups="title")
  public void loginTest() {
	  System.out.println("Login Test");
	 // Assert.assertEquals("Test", "test");
  }
  @Test(groups="title")
  public void homePageTest() {
	  System.out.println("Home Page Test");
  }
  @Test(groups="title")
  public void searchPageTest() {
	  System.out.println("Search Page Test");
  }
  @Test(groups="login",invocationCount=3)
  public void checkPageTest() {
	  System.out.println("Check Page Test");
  }
}
