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
public class ShoppingCartPage {
	private static final ReportLogService report=new ReportLogServiceImpl(ShoppingCartPage.class);
	Testdata testData=new Testdata();
	Browser browser;
	public   Properties Shoppingcart=testData.loadProperties(Constants.SHOPPINGCART);
	
	//Initialization the browser		
	public ShoppingCartPage(Browser browser) {
		this.browser=browser;
	}
//Click on Proceed to Add to cart
	public void clickonAddtocart() {
		report.info("click on Proceed to Add to cart");		
		browser.getDriver().findElement(By.xpath(Shoppingcart.getProperty("AddtoCart"))).click();
	}
	//Click on View to the cart
	public void clickonConfirmOrder() {
		report.info("click on View to the cart");		
		browser.getDriver().findElement(By.xpath(Shoppingcart.getProperty("Select_view_in_Cart"))).click();
	}

}