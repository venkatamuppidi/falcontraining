/**
 * 
 */
package com.ui.automation.pages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.helper.CommonMethods;
import com.ui.automation.testsuite.TestSuiteBase;


/**
 * @author venkata.muppidi
 *
 */
public class GoogleSearchpage{
	private static final ReportLogService report=new ReportLogServiceImpl(GoogleSearchpage.class);
	Browser browser;
	//private static Properties dashboardpage=loadProperties(Constants.Dashboardpage);
	CommonMethods commonMethods;
	
	public GoogleSearchpage(Browser browser){	
		this.browser = browser;
		commonMethods=new CommonMethods (browser);
	}


	public void clickonGmaillink() throws InterruptedException {
		report.info("click on Gmail link");

		browser.getDriver().findElement(By.linkText("Gmail")).click();
		browser.getDriver().manage().timeouts().pageLoadTimeout(Constants.MIN_WAIT_TIME, TimeUnit.SECONDS);
		browser.getNavigate().back();

	}
	public void clickonImageslink() throws InterruptedException {
		report.info("click on Image link");
		browser.getDriver().findElement(By.linkText("Images")).click();
		browser.getDriver().manage().timeouts().pageLoadTimeout(Constants.MIN_WAIT_TIME, TimeUnit.SECONDS);
		browser.getNavigate().back();

	}
	public void entertextinSearchbox(String text) throws InterruptedException {
		report.info("Enter the text in Search box");

		browser.getTextField().enterTextField(LocatorType.NAME, "q", text);
		browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);
		browser.getNavigate().back();		
	}


}


