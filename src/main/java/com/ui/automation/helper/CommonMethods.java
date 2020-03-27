/**
 * 
 */
package com.ui.automation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.atmecs.falcon.automation.ui.selenium.Browser;

/**
 * @author venkata.muppidi
 *
 */
public class CommonMethods {
	Browser browser;

	public CommonMethods(Browser browser){
		this.browser =browser;

	}

	public void implicitWait(int timeInSeconds) {
		browser.getDriver().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
		
	}


	public void explicitWait(WebElement element,
			long maxExplicityWaitTime, String fieldName) {

		try {
			Thread.sleep(maxExplicityWaitTime);
			WebDriverWait wait=new WebDriverWait(browser.getDriver(), maxExplicityWaitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail("Maximum Time out reached for Identifying " + fieldName
					+ "\n" + " Original Message is: " + e.getMessage());
		}

	}
	  public  Properties loadProperties(String propertyFilePath ) { 
			 File file=new File(propertyFilePath);
			 FileInputStream fileInput=null; 
			 try {
				 fileInput=new FileInputStream(file);
			 }catch(FileNotFoundException e) { 
			e.printStackTrace(); } 
			Properties prop=new
			Properties(); 
			try { 
				prop.load(fileInput); 
			}catch(IOException e) {
				e.printStackTrace();
				}
			return prop; 
		  }
		 
	
}
