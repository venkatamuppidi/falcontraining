/**
 * 
 */
package com.ui.automation.helper;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;



/**
 * @author venkata.muppidi
 *
 */
public class Ecommercshelper {
	
	private ReportLogService report = new ReportLogServiceImpl(Ecommercshelper.class);
	public Browser browser;
	
	Testdata testData=new Testdata();
	public   Properties homepage=testData.loadProperties(Constants.HOMEPAGE);
	 XlsReader xlsReader = new XlsReader();

//Initialization the browser
	public Ecommercshelper(Browser browser) {
		this.browser=browser;
		
	}
	
	//Initialization the browser and opening the website 
	public void launchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		browser.openURL("https://www.google.com/" ,os, osVersion, br, browserVersion);
		//homepage.getProperty("URL")
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().pageLoadTimeout(Constants.MIN_WAIT_TIME, TimeUnit.SECONDS);
	}
	
public static void main(String[] args) {
	
	System.out.println("url"+new Ecommercshelper(null).homepage.getProperty("URL"));
}
}
