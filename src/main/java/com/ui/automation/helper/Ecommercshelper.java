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
import com.ui.automation.pages.HomePage;
import com.ui.automation.pages.Loginpage;



/**
 * @author venkata.muppidi
 *
 */
public class Ecommercshelper {
	
	private ReportLogService report = new ReportLogServiceImpl(Ecommercshelper.class);
	public Browser browser;
	
	Testdata testData=new Testdata();
	public   Properties homepages=testData.loadProperties(Constants.HOMEPAGE);
	 XlsReader xlsReader = new XlsReader();
	 Loginpage loginpage;
	 HomePage homepage;

//Initialization the browser
	public Ecommercshelper(Browser browser) {
		this.browser=browser;
		homepage=new HomePage(browser);
		loginpage=new Loginpage(browser);
		
	}
	
	//Initialization the browser and opening the website 
	public void launchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		browser.openURL(homepages.getProperty("URL"),os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().pageLoadTimeout(Constants.MIN_WAIT_TIME, TimeUnit.SECONDS);
	}
	public void login(String username ,String password,String Country) {
		report.info("Log into website ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		homepage.clickonlogin();
		report.info("enter the username");
		loginpage.enterUsername(username);
		report.info("enter the password");
		loginpage.enterpassword(password);
		loginpage.clickonLoginbutton();
	}

}
