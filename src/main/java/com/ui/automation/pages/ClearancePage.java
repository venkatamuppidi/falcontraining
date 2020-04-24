/**
 * 
 */
package com.ui.automation.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;


/**
 * @author venkata.muppidi
 *
 */
public class ClearancePage {
	Browser browser;
	Testdata testData =new Testdata();
	private static final ReportLogService report=new ReportLogServiceImpl(ClearancePage.class); 
	public   Properties Clearance=testData.loadProperties(Constants.CLEARANCE);

	public ArrayList<String> product=new ArrayList<String>();
	public ClearancePage(Browser browser) {
		this.browser=browser;
	}


	//Store the list of the products  
	public   ArrayList<String>listofproduct() {
		report.info("Store the list of the products ");
		List<WebElement> elements = browser.getDriver().findElements(By.xpath(Clearance.getProperty("Clearance_productname")));
		  String productname=""; 
		  for(WebElement ele:elements) {
			  productname=ele.getText();
			  product.add(productname);
		  }
		return product;
		
	}
	//getting the each product price
	public String Productprice(String productnam) {
		report.info("Storeproduct price");
		String productprice=browser.getDriver().findElement(By.xpath(Clearance.getProperty("Clearance_productname_price")+productnam+Clearance.getProperty("Clearance_price_endpoint"))).getText();
		return productprice;
		

	}


}
