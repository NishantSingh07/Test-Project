package com.automtion.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.automation.main.Screenshot;

public class Listener extends Screenshot implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	     
       WebDriver driver = null;
		System.out.println("***************Taking Screenshot***********************");
		String TestCaseName=result.getMethod().getMethodName();
		System.out.println("Test Case Name is :" + TestCaseName);
		try {
			takescreenshot(driver,TestCaseName);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		
	}

}
