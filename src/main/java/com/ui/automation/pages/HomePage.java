/**
 * 
 */


package com.ui.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
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
	Browser browser;


	//Initialization the browser
	public HomePage(Browser browser) {
		this.browser=browser;
	}
	// Click on Signin button
	public Loginpage clickonlogin() {
		report.info("click on login button ");
		browser.getDriver().findElement(By.xpath(Homepage.getProperty("Homepage_login"))).click();;
		return new Loginpage(browser);

	}
	//Click on country dropdown link 
	public  void selectcountry(String countryname) {
		report.info("Select the country name");
		browser.getDriver().findElement(By.cssSelector(Homepage.getProperty("Homepage_countryname"))).click();
		browser.getDriver().findElement(By.xpath(Homepage.getProperty("Homepage_country_dropdown")+countryname+Homepage.getProperty("Homepage_endpoint"))).click();	
	}
	// Click on Home button
	public void clickonHomelink() {
		report.info("click on Home button ");
		browser.getDriver().findElement(By.xpath(Homepage.getProperty("HomePage_link"))).click();;


	}
	// Click on Home button
	public ClearancePage clickClearancelink() {
		report.info("click on Clearance button ");
		browser.getDriver().findElement(By.xpath(Homepage.getProperty("HomePage_Clearance"))).click();
		return new ClearancePage(browser);


	}
	public void Searchforproduct(String productname) {
		report.info("Search for the product");
		browser.getTextField().enterTextField(LocatorType.NAME, "q", productname);
		browser.getDriver().findElement(By.name("q")).clear();
	browser.getDriver().findElement(By.name("q")).sendKeys(productname);
	browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);

	}
	//Logout the user
	public  void Logout() {
		report.info("click on logout");
		browser.getDriver().findElement(By.xpath(Homepage.getProperty("Homepage_logout"))).click();
		browser.getDriver().findElement(By.xpath(Homepage.getProperty("Homepage_logoutbutton"))).click();
		}


}