package com.automation.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.automation.main.WebDriverManager.init;
import static com.automation.main.WebDriverManager.quit;

public class ValidateDriverManager {

    @BeforeMethod
	public void validate() {

    	WebDriver driver= init();
		driver.get("http://www.google.com");
		}

	@Test
	public void LoginTest(){

		System.out.println("In Login Test");
	}

	@Test
	public void HomePageTest(){

		System.out.println("In HomePage Test");
	}

	@AfterTest
	public  void after() {
    	quit();
}



}
