/**
 * 
 */
package com.ui.automation.pages;



import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;
import com.ui.automation.helper.CommonMethods;
import com.ui.automation.testsuite.TestSuiteBase;

/**
 * @author venkata.muppidi
 *
 */
public class Loginpage extends TestSuiteBase{
	private static final ReportLogService report=new ReportLogServiceImpl(Loginpage.class);
	Testdata testData=new Testdata();
	public   Properties Loginpage=testData.loadProperties(Constants.LOGINPAGE);
	Browser browser;
	
	public void enterUsername(String Username) {
		report.info("enter the emailid");
		browser.getTextField().enterTextField(LocatorType.ID, Loginpage.getProperty("LoginPage_Username"), Username);
	}
	public void enterpassword(String pwrd) {
		report.info("enter the password");
		browser.getTextField().enterTextField(LocatorType.ID, Loginpage.getProperty("LoginPage_password"), pwrd);
	}
	
	public void clickonSignIn() {
		report.info("Click on SignButton");
		browser.getDriver().findElement(By.id(Loginpage.getProperty("LoginPage_Signin"))).click();
	}
	public Loginpage(Browser browser) {
		this.browser=browser;
		
	}



}
