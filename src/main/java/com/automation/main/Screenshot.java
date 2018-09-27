 package com.automation.main;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
     
      public  String takescreenshot(WebDriver driver,String TestCaseName ) throws InterruptedException {
                  File dest = new File("C:\\Users\\ZSINNIS\\eclipse-workspace\\Test-Project\\Screenshot\\"+TestCaseName+"_"+timestamp()+".png");
                  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	              Thread.sleep(3000);
	  try {
		         FileUtils.copyFile(src, dest);
	}  
	  catch (IOException e) {
				 e.printStackTrace();
	}
     return  dest.toString();
	        }
	 private static String timestamp() {
	  return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
			}
	 
}


