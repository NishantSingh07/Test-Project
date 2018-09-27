package com.automtion.test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.main.ExcelReader;

public class RunExcel {

 /*@Test()
	public void run() throws IOException {
	  ExcelReader read= new ExcelReader();
      read.ReadData(1, 3);
	}
	*/

	@Test (dataProvider="getData")
	public void login (String Username,String Password) {
	  System.out.println("User Name is " +Username);
	   System.out.println("Password is " +Password);
	      
	  
	}
     
	@DataProvider(name="getData")
     public Object[][] getData() throws IOException {
	  
	  ExcelReader reader= new ExcelReader();
	  return reader.ReadData();
	    

	}
}

