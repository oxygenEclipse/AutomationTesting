package selenium.practicals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitAnnotations {

	@BeforeClass
	public static void beforeClass()
	{
	
		System.out.println("Driver Initialisation");
	}
	
	@Before
	public void before() {
		// TODO Auto-generated method stub
		System.out.println("Login to application");
	}
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		System.out.println("Place order using search");
	}
	@Test
	public void test2() {
		// TODO Auto-generated method stub
		System.out.println("Place order using menu navigation");
	}
	@Test
	public void test3() {
		// TODO Auto-generated method stub
		System.out.println("Place order using quick view");
	}
	
	
	@After
	public void after() {
		// TODO Auto-generated method stub
		System.out.println("Logout application");
	}
	@AfterClass
	public static void afterClass() {
		// TODO Auto-generated method stub
		System.out.println("Driver quit");
	}
	
	
	
}
