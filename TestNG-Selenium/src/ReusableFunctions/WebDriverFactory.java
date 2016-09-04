package ReusableFunctions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
public static WebDriver driver=null;
public static WebDriver getDriver(String browser)
{
	switch(browser)
	{
	case "firefox":
		driver=new FirefoxDriver();
		break;
	case "chrome":
		System.setProperty("webdriver.chrome.driver", new File(System.getProperty("user.dir")).getAbsolutePath()+"\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
	case "iexplore":
	
	break;
	}
	return driver;
}
}
