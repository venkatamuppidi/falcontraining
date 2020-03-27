/**
 * 
 */
package com.ui.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.ICheckBox.SelectType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;

/**
 * @author venkata.muppidi
 *
 */
public class RegistrationPage {
	private static final ReportLogService report=new ReportLogServiceImpl(RegistrationPage.class);
	Testdata testData=new Testdata();
	public   Properties Registration=testData.loadProperties(Constants.REGISTRATION);
	Browser browser;
	
	//Initialization the browser	
	public RegistrationPage(Browser browser) {
		this.browser=browser;
	}
	
	//Click on Title Means(Mr.,Mrs.)
	public void clickonTitle(String title) {
		report.info("click on Title");	
			browser.getCheckBox().clickCheckBoxById(LocatorType.XPATH,(Registration.getProperty("Title")+title+Registration.getProperty("Containsendpoint")),SelectType.CHECK);		
		
	}
	//Provide the First Name in Registration form
	public void enterfirstName(String firstname) {
		report.info("enter the First Name");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("Firstname"), firstname);
	}
	//Provide the LastName in Registration page
	public void enterlastName(String lastname) {
		report.info("enter the last Name");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("LastName"), lastname);
	}
	//Provide the Enterpassword in Registration page
	public void enterpassword(String pasword) {
		report.info("enter the password");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("Password"), pasword);
	}
	//Provide the DOB 
	public void entertheDob(String DOB) {
		report.info("Enter the DOB");
		String dob=DOB;
		String[] arrdob=dob.split("/");
	browser.getDriver().findElement(By.xpath(Registration.getProperty("Day")+arrdob[0]+Registration.getProperty("Containsendpoint"))).click();
	browser.getDriver().findElement(By.xpath(Registration.getProperty("Month")+arrdob[1]+Registration.getProperty("Containsendpoint"))).click();
	browser.getDriver().findElement(By.xpath(Registration.getProperty("Years")+arrdob[2]+Registration.getProperty("Containsendpoint"))).click();
	}
	//Enter the Address
	public void EntertheAddress(String Address) {
		report.info("enter the Address");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("Address"), Address);
		
	}
	//Enter the City
	public void EntertheCity(String City) {
		report.info("enter the City");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("City"), City);
	}
	//Enter the zipcode 
	public void EntertheZipcode(String Zipcode) {
		report.info("enter the Zipcode");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("Zipcode"), Zipcode);
	}
	//Enter the State
	public void clickonSate(String State) {
		report.info("click on State");	
			browser.getDriver().findElement(By.id(Registration.getProperty("State")+State+Registration.getProperty("Containsendpoint"))).click();		
		
	}
	//Enter the Phone number  
	public void EnterthePhonenum(String EnterNum) {
		report.info("enter the Phonenum");
		browser.getTextField().enterTextField(LocatorType.ID, Registration.getProperty("Mobilephone"), EnterNum);
	}
	//Click the RegisterButton after providing mandatory fields
	public void clickonRegisterButton() {
		report.info("Click on RegisterButton");
		browser.getDriver().findElement(By.id(Registration.getProperty("Register"))).click();
	}
	}

