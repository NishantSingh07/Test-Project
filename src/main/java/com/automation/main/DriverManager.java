package com.automation.main;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class  DriverManager {

   private WebDriver driver;
   private  String browsername;
    ConfigFileReader read ;



    public  WebDriver LaunchBrowser() {
        ConfigFileReader read= new ConfigFileReader() ;
        browsername = read.getBrowser();
        System.out.println("Selected Browser is --->" + browsername);
        {

            switch (browsername) {

                case "chrome":
                    System.out.println("********* Launching Chorme Browser ***************");
                   openChromebrowser();
                    break;
                case "firefox":
                    System.out.println("********* Launching Firefox Browser ***************");
                   openFirefoxbrowser();
                    break;

            }
        }
		return driver;
    }

/*    private DriverManager() {
     
    }
    
*/

    public  WebDriver openChromebrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        opt.addArguments("disable-geolocations");
        

        // *****************Setting Chorme Proxy**********************************

        /*	DesiredCapabilities cap = new DesiredCapabilities();
            
            Proxy proxy = new Proxy();
		    proxy.setHttpProxy("myhttpproxy:3337");
		    .setCapability("proxy", proxy);
        */

        // ************************************************************************


        driver = new ChromeDriver(opt);
        // 	driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
       // driver.manage().window().maximize();
       return driver;

    }


    public  WebDriver openFirefoxbrowser() {
        System.out.println("Setting FireFox driver");
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver\\geckodriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("locationContextEnabled", false);
        driver = new FirefoxDriver(cap);
        return driver;

    }
    
    /*public  DriverManager getinst()

    {
        if (driver == null)
           // driver = new DriverManager();
            
        return null;
        return new DriverManager();
       

    }
    */

}