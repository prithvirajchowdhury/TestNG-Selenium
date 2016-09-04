package Reporting;



import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	static int  count=1;
	public static String getScreenShot(WebDriver driver)throws Exception
	{
		count++;
		File src =((org.openqa.selenium.TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="E:\\screenshot"+count+".jpg";
		FileUtils.copyFile(src,new File(path));
		return path;
	}

}
