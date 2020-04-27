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
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;

/**
 * @author venkata.muppidi
 *
 */
public class MerchandisePage {
	Browser browser; 
	Testdata testData =new Testdata(); 
	private static final ReportLogService report=new ReportLogServiceImpl(MerchandisePage.class);
	public Properties Merchandise=testData.loadProperties(Constants.MERCHANDISE);
	
	//Initialization the browser
		public MerchandisePage(Browser browser) {
			this.browser=browser;
		}

public void selectproductname(String productname) {
	report.info("select the required product");
browser.getDriver().findElement(By.xpath(Merchandise.getProperty("selectproductname")+
		productname+Merchandise.getProperty("Merchandise_endpoint"))).click();

}
public void selectcolor(String color) {
	report.info("Select the Merchandise color");
	browser.getDriver().findElement(By.xpath(Merchandise.getProperty("selectcolor")+color+Merchandise.getProperty("Merchandise_endpoint"))).click();
}
public void selectthesize(String size) {
	report.info("Select the size of the dress");
	browser.getDriver().findElement(By.xpath(Merchandise.getProperty("select_Dress_size")+size+Merchandise.getProperty("Merchandise_endpoint"))).click();
}

public void personlizedName(String personlizedName) {
	report.info("Enter personlizedName");
	browser.getTextField().enterTextField(LocatorType.XPATH, Merchandise.getProperty("personlized_Name"), personlizedName);
}
		
		
}
