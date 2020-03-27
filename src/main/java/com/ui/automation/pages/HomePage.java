/**
 * 
 */


package com.ui.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import
com.atmecs.falcon.automation.util.reporter.ReportLogService;
import
com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;

/**
 * @author venkata.muppidi
 *
 */
public class HomePage { 
	private static final ReportLogService report=new ReportLogServiceImpl(HomePage.class); 
   Testdata testData =new Testdata();
	public   Properties Homepage=testData.loadProperties(Constants.HOMEPAGE);
	public	Browser browser;


	
	public HomePage(Browser browser) {
		this.browser=browser;
	}
	
	public Loginpage clickonSignin() {
		report.info("click on sign button ");
		browser.getDriver().findElement(By.linkText(Homepage.getProperty("Homepage_Signin"))).click();;
		return new Loginpage(browser);
		
	}
	public Womenpage clickonWomenlink() {
		report.info("Selecting the Women");
		browser.getDriver().findElement(By.linkText(Homepage.getProperty("Homepage_Women")));
		return new Womenpage(browser);
}



}