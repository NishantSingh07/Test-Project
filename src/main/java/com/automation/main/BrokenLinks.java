package com.automation.main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpGet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpRequest;
import org.testng.annotations.Test;

public class BrokenLinks {
  
  
 DriverManager dm= new DriverManager();
 
 WebDriver driver;
 
 @Test
 public void FindBrokenLinks() throws IOException {
   driver =dm.openChromebrowser();
   driver.get("https://www.google.com");
   driver.manage().window().maximize();
   driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
    List <WebElement> mylist=driver.findElements(By.xpath("//a"));
    
    for (WebElement e :mylist) {
      
      String href =e.getAttribute("href");
      if ((href != null) && !href.startsWith("javascript")) {
       
      String url =href;      
      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();
       int res = con.getResponseCode();
       if (res ==200)
       System.out.println("Link working fine -------------for :-"+url);
       else
       System.out.println("Broken Link found ------------for :-"+url);
   
    }
   
   
 }
 
 }
}
