/**
 * 
 */
package com.ui.automation.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.ui.automation.config.Constants;

import com.ui.automation.pages.Loginpage;

/**
 * @author venkata.muppidi
 *
 */
public class Spiecejethelper{
	
	private ReportLogService report = new ReportLogServiceImpl(Spiecejethelper.class);
	public Browser browser;
	private static String testDataFilePath = Constants.DASHBOARD_TEST_DATA_HOME;
	private static String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
	Loginpage loginpage;
	//HomePage homepage;
	/* public ArrayList<String> mobnum=new ArrayList<String>(); */
	
	 XlsReader xlsReader = new XlsReader();


	public Spiecejethelper(Browser browser) {
		this.browser=browser;
		loginpage = new Loginpage(browser);
		//homepage=new HomePage(browser);
	}
	public void launchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		browser.openURL("https://www.spicejet.com/", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().pageLoadTimeout(Constants.MIN_WAIT_TIME, TimeUnit.SECONDS);
	}

	
		
		
}
	
	
	/*
	 * public void PerformactionHome() { report .info("Home page");
	 * homepage.clickBookingflight(); homepage.clickCheckin();
	 * homepage.clickEditBooking(); homepage.clickFlightStatus();
	 * 
	 * }
	 */
	
	


