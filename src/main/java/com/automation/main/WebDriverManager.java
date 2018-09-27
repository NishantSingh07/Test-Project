package com.automation.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver driver;
    private ConfigFileReader read;
    private static String browsername;
    WebDriverWait wait ;


    private WebDriverManager() {

    }


    public static WebDriver init() {
        if (driver == null) {
            driver = LaunchDriver();
        }
        return driver;
    }


    private static WebDriver LaunchDriver() {
        ConfigFileReader read = new ConfigFileReader();
        browsername = read.getBrowser();
        System.out.println("Selected Browser is --->" + browsername);
        {

            switch (browsername) {

                case "chrome":
                    System.out.println("********* Launching Chrome Browser ***************");
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

    private static WebDriver openChromebrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");
        opt.addArguments("disable-geolocations");


        // *****************Setting Chrome Proxy**********************************

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


    private static WebDriver openFirefoxbrowser() {
        System.out.println("Setting FireFox driver");
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver\\geckodriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("locationContextEnabled", false);
        driver = new FirefoxDriver(cap);
        return driver;

    }

    public static void close() {

        driver.close();
    }

    public static void quit() {

        driver.quit();
    }

    public void webDriverWait() {
     wait= new WebDriverWait(driver,100);
           }
}
