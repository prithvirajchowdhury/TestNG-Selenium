 package Reporting;

import org.testng.Assert;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.asserts.SoftAssert;

import Tests.Test1;

public class Report implements ITestListener {
	
	public static SoftAssert sa=null;
	
	public static Report report=null;
	
	
	public static Report getInstance()
	{
		if(report==null)
		{
			report=new Report();
			sa=new SoftAssert();
		}
		return report;
	}
	public  void updateTestLog(String StepName,  Status status)
	{
		final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
		  System.setProperty(ESCAPE_PROPERTY, "false");
		switch(status)
		{
		case PASS:
			 Reporter.log("<table><tr><td style=\"width:100px\"><b>Step Name:</b></td><td style=\"width:530px\"> "+StepName+"</td><td><b><font color=\"green\">PASS</font></b></td></tr></table>");
			break;
		case FAIL:
			String path=null;
			try {
			 path="file:///"+Screenshot.getScreenShot(Test1.driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.log("<table><tr><td style=\"width:100px\"><b>Step Name:</b></td><td style=\"width:530px\"> "+StepName+"</td><td><a href="+path+"><b><font color=\"red\">FAIL</font></b></a></td></tr></table>");
			try{
				report.sa.assertTrue(false);
				}
				catch(Error e)
				{
					Reporter.log("<table><tr><td style=\"width:100px\">Error Details:</td><td style=\"width:530px\"> "+e.getLocalizedMessage()+"</td><td></td></tr></table>");
				}
			
			//onTestFailure(Reporter.getCurrentTestResult());
			break;
		case WARNING:
			break;
		case SCREENSHOT:
			break;
			
		}
	}
	@Override
	public void onFinish(ITestContext arg0) {
	
		
	}
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

	


}
