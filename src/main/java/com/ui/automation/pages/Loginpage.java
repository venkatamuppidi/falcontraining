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

	//Enter the MailID
	public void enterUsername(String Username) {
		report.info("enter the emailid");
		browser.getTextField().enterTextField(LocatorType.ID, Loginpage.getProperty("LoginPage_Username"), Username);
	}
	//Enter the  valid password in the field
	public void enterpassword(String pwrd) {
		report.info("enter the password");
		browser.getTextField().enterTextField(LocatorType.ID, Loginpage.getProperty("LoginPage_password"), pwrd);
	}
//Click on Signin after enter valid credentials 
	public void clickonSignIn() {
		report.info("Click on SignButton");
		browser.getDriver().findElement(By.id(Loginpage.getProperty("LoginPage_Signin"))).click();
	}

// Click on CreateAccount button
	public RegistrationPage clickonCreateanAccount() {
		report.info("Click on Create an Account");
		browser.getDriver().findElement(By.id(Loginpage.getProperty("LoginPage_Createan_Account"))).click();
		return new RegistrationPage(browser);
	}
//Provide the Email id if user what to create new Registration 
	public RegistrationPage EntertheNewMailAddress(String NewMailid) {
		report.info("Enter the New Mail Address to create an account");
		browser.getTextField().enterTextField(LocatorType.ID, Loginpage.getProperty("LoginPage_EnterMailid"), NewMailid);
		return new RegistrationPage(browser);
	}

	//Initialization the browser
	public Loginpage(Browser browser) {
		this.browser=browser;

	}



}
