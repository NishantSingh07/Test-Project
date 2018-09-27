package com.automation.main;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestNG {
    
	@Test
	public static void Start() {
		
		System.out.println("Launching Browser");
		Assert.assertEquals(12, 12);
	}
	
	@Test(dependsOnMethods="Start")
	public static void Login() {
		
		System.out.println("Login Success");
		Assert.assertEquals(12, 13);
		
	}
	
	@Test(dependsOnMethods="Login")
	public static void Logout() {
		
		System.out.println("Logout Sucess");
	
		
	}
	
	@AfterTest(enabled=false)
	public static void After() {
	
		System.out.println("In After Test Method");
	
	}
	
	@AfterTest
	public static void After1()
	{
		System.out.println("In After1 Test Method ");
	}
	
}


