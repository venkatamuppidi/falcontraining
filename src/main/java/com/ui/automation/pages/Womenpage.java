/**
 * 
 */
package com.ui.automation.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;

/**
 * @author venkata.muppidi
 *
 */
public class Womenpage {
	private static final ReportLogService report=new ReportLogServiceImpl(Womenpage.class);
	Testdata testData=new Testdata();
	Browser browser;
	public   Properties womenpage=testData.loadProperties(Constants.WOMENPAGE);
	public Womenpage(Browser browser) {
		this.browser=browser;
	}
	
	public Productpage ClickonTops() {
		report.info("click on Subcategories on Tops ");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Women_subcategories_tops"))).click();
		return new Productpage(browser);
	}
	public void ClickonDresses() {
		report.info("click on Subcategories on Dresses ");
		browser.getDriver().findElement(By.xpath(womenpage.getProperty("Women_subcategories_dresses"))).click();	
	}
}
