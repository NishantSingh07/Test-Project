package com.automtion.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.main.DriverManager;
import com.automation.main.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;
import org.apache.log4j.Logger;

//@Listeners(Listener.class)
public class TestName  {
Screenshot sc=new Screenshot();
WebDriver driver;
Logger Log = Logger.getLogger("TestName");

ExtentReports extent;

ExtentTest test;
    
    
    @BeforeTest	
	public void setup() {
//     System.out.println(System.getProperty("user.dir")+"\\test-output\\ExtentScreenshot.html");
        extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReport-Screenshot.html");
        DriverManager dm= new DriverManager();
        driver = dm.LaunchBrowser();
        Log.info("************Browser Setup Completed******************");
       }
	
	@Test
    public void LoginTest() throws InterruptedException {
	    test = extent.startTest("LoginTest");
	    driver.get("http://www.google.com");
		System.out.println("Passed");
	    Assert.assertEquals(true, true);
	// sc.takescreenshot(driver, "LoginTest"); 
		Log.info("****************Screenshot Captured*********************");
		test.log(LogStatus.PASS, "Test Passed");
		test.log(LogStatus.PASS, "Snapshot below :"+test.addScreenCapture( sc.takescreenshot(driver, "LoginTest")));

				}
	

   @Test
	public void HomePageTest() {
    	test =extent.startTest("HomePageTest");
		driver.get("http://www.gmail.com");
		System.out.println("Failed");
		Assert.assertEquals(true, false);
	}

	
	@AfterMethod()
	public void getResult(ITestResult result) throws InterruptedException {
	  if(result.getStatus()==ITestResult.FAILURE) {
	    String screenshotPath= sc.takescreenshot(driver, result.getMethod().getMethodName());
	    System.out.println(screenshotPath);
	    test.log(LogStatus.FAIL, result.getThrowable());
	    test.log(LogStatus.FAIL, "Snapshot below"+ test.addScreenCapture(screenshotPath));

	  }
		extent.endTest(test);
	}
	
	@AfterTest
	public void teardown()
	{
	    driver.quit();
	    extent.flush();
	    extent.close();
	}

   
}
