
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DriverScript {
	
	@BeforeTest
	public void setUp()
	{
		
		System.out.println("before test");
		
	}
	@AfterTest
	public void tearDown()
	{
		System.out.println("After test");
	}
	@BeforeSuite
public void beforeSuite()
{
		System.out.println("Before Suite");
}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite");
	}
	@BeforeMethod
	public void beforeMethod()
	{
			System.out.println("BeforeMethod");
	}
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("AfterMethod");
		}
		
	
		
		@BeforeClass
		
		
		public void beforeClass()
		{
			System.out.println("Before Class");
		}
			@AfterClass
			public void afterClass()
			{
				System.out.println("AfterClass");
			}
			
			@Test
			@Parameters("name")
			public void test1(String name)
			{
				System.out.println("Test1"+name);
				//System.out.println(browserName);
				//Reporter.log("Test1");
			}
			@Test
			@Parameters({"browser","url"})
			public void test2(String browser,String url)
			{
				System.out.println("Test 2" +browser+url);
				System.out.println("test2");
			}
			
			 public static void main(String[] args) throws ClassNotFoundException {
			        TestNG test = new TestNG();
			         test.setTestClasses(new Class[] { DriverScript.class });
			         test.run();
			    }
}
