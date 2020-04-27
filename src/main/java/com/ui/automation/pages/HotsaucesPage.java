/**
 * 
 */

package com.ui.automation.pages;

import java.util.ArrayList;
import java.util.List;
import
java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import
com.atmecs.falcon.automation.util.reporter.ReportLogService;
import
com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import
com.ui.automation.config.Constants;
import
com.ui.automation.dataprovider.Testdata;

/**
 * @author venkata.muppidi
 *
 */
public class HotsaucesPage { 
	Browser browser; 
	Testdata testData =new Testdata(); 
	private static final ReportLogService report=new ReportLogServiceImpl(ClearancePage.class);
	public Properties HotSauces=testData.loadProperties(Constants.HOTSAUCES);
	public	ArrayList<String> product=new ArrayList<String>();
	
	public	HotsaucesPage(Browser browser) { 
		this.browser=browser;
		}
	//Store the list of the products 
	public String selectNewArrival() {
		String Productname="";
	report.info("Click on New Arrival products"); 
	Productname=browser.getDriver().findElement(By.xpath(HotSauces.getProperty("productname"))).getText();
	browser.getDriver().findElement(By.xpath(HotSauces.getProperty("HotSauces_new_Arrival"))).click();
	return Productname;
	}
	//Select the Manufacturer name 
	public void selectManufuturename(String Manufuture) {
		report.info("select the manufuture name");
		if(true==browser.getDriver().findElement(By.xpath(HotSauces.getProperty("Manufuture_name")+Manufuture+HotSauces.getProperty("HotSauces_endpoint"))).isDisplayed()) {
			browser.getDriver().findElement(By.xpath(HotSauces.getProperty("Manufuture_name")+Manufuture+HotSauces.getProperty("HotSauces_endpoint"))).click();
		}
		else {
			browser.getDriver().findElement(By.xpath(HotSauces.getProperty("click_manufuture_dropdown"))).click();
			browser.getDriver().findElement(By.xpath(HotSauces.getProperty("Manufuture_name")+Manufuture+HotSauces.getProperty("HotSauces_endpoint"))).click();	
		}
	}
}
		

