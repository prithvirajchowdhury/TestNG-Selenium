package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import Reporting.Report;
import Reporting.Status;
import ReusableFunctions.WebDriverFactory;


public class Test1 {
	public static WebDriver driver=null;
	Report report=null;
  @Test(priority=1)
  public void testMethod() {
	  
	  
	  driver.findElement(By.name("q")).sendKeys("Jurrasic Park");
	  report.updateTestLog("Typed Jurrasic Park", Status.PASS);
	 
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  Capabilities cap=((RemoteWebDriver)driver).getCapabilities();
	  String browserName=cap.getBrowserName();
	  System.out.println(browserName);
	  if(browserName.equalsIgnoreCase("firefox"))
	  report.updateTestLog("Pressed Enter", Status.FAIL);
	  else
		  report.updateTestLog("Pressed Enter", Status.PASS);
		  
	
	  report.updateTestLog("Test Complete", Status.PASS); 
	  report.sa.assertAll();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  @Parameters({"browser"})
  public void beforeTest(String browser) {
	   report=Report.getInstance();
	  System.out.println("Browser:"+browser);
	  driver=WebDriverFactory.getDriver(browser);
	  
  }

  @AfterClass
  public void afterClass() {
  }
  @BeforeClass
 
  @Parameters({"url"})
  public void beforeClass(String url) {
	  System.out.println("Browser:"+url);
	  driver.get(url);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	 driver.quit();
	
	   }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
