package com.automation.main.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class Utility {

    public static void waitforElement(WebDriver driver,WebElement We){
         WebDriverWait wait =  new WebDriverWait(driver, 10);
                 wait.until(ExpectedConditions.visibilityOf(We));
    }
    public static boolean waitforPageLoad(WebDriver driver) throws InterruptedException {
        boolean result = false;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        result = js.executeScript("return document.readyState").equals("complete");
       if (!result){
           sleep(2000);
       }
       return result;
    }
    public  static void  click(WebDriver driver,WebElement We){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",We);

            }

}
