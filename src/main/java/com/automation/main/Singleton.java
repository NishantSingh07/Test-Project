package com.automation.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Singleton {
	  static WebDriver driver;
	
	
	@BeforeMethod
	public static void init() {
	//	DriverInit instanceDriver = DriverInit.getInstance();
	//	driver = instanceDriver.openBrowser();
			                         }
	@Test
	public static void test() {
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
}
	@AfterTest
	public static void after() {
		driver.quit();
	}
	
	
}