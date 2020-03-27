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
	public ShoppingCartPage(Browser browser) {
		this.browser=browser;
	}
	
	public void clickonProceedtocheckout() {
		report.info("click on Proceed to checkout");		
		browser.getDriver().findElement(By.xpath(Shoppingcart.getProperty("ProceedtoCheckout"))).click();
	}

	public void clickonAgreecheckbox() {
		report.info("click on Proceed to checkout");		
		browser.getCheckBox().clickCheckBoxById(LocatorType.ID,Shoppingcart.getProperty("Agreecheckbox"),SelectType.CHECK);
		
	}
	
	public void clickonPayBybankwire() {
		report.info("click on PayBybankwire");		
		browser.getDriver().findElement(By.xpath(Shoppingcart.getProperty("PayBybankwire"))).click();
	}
	
	public void clickonConfirmOrder() {
		report.info("click on ConfirmOrder");		
		browser.getDriver().findElement(By.xpath(Shoppingcart.getProperty("IconfirmtoOrder"))).click();
	}

}