package com.automation.main;

public class TestMain {
	
	public static TestMain obj;
	
	 
	private TestMain() {
		System.out.println("Instance Created");
	}
	
	public static TestMain getinstance() {
		
		if(obj==null)
		{
			obj = new TestMain();
		}
  		
		return obj;
	
	}
	
	
	public static void main(String[] args) {
	
		TestMain abc1 = TestMain.getinstance();
	    TestMain abc2 = TestMain.getinstance();

	}
}
