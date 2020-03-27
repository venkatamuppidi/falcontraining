/**
 * 
 */
package com.ui.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;

/**
 * @author venkata.muppidi
 *
 */
public class Productpage {
	private static final ReportLogService report=new ReportLogServiceImpl(Productpage.class);
	Testdata testData=new Testdata();
	Browser browser;
	public   Properties womenpage=testData.loadProperties(Constants.WOMENPAGE);
	public Productpage(Browser browser) {
		this.browser=browser;
	}

	public void Selectproduct(String productname) {
		report.info("select the  Product ");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Womenpage_selectProductName")+productname+womenpage.getProperty("Womenspage_endpoint"))).click();
	}
	public void providesize(String size) {
		report.info("Selecrt the size");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Womenpage_size")+size+womenpage.getProperty("Womenspage_endpoint"))).click();
	}
	public void Selectcolor(String color) {
		report.info("Select the color ");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Women_color")+color+womenpage.getProperty("Womenspage_endpoint"))).click();
	}
	public void Selectquanity(String quanity) {
		report.info("Select the quanity ");
		browser.getTextField().enterTextField(LocatorType.XPATH, womenpage.getProperty("Women_quantity"),quanity );
	}
	public void Addtocart() {
		report.info("Click on addtocart button");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Women_addtocart"))).click();
	}
	public void clickonContinueShopping() {
		report.info("Click on ContinueShopping");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Women_continue_shoping"))).click();
	}
	public void clickonProceedtoCheckout() {
		report.info("Click on ProceedtoCheckout");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Women_procced_check_out"))).click();
	}
	
	
	
	
}
