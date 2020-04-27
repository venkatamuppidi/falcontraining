/**
 * 
 */

package com.ui.automation.testscript;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import
com.atmecs.falcon.automation.util.reporter.ReportLogService;
import
com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import
com.atmecs.falcon.automation.verifyresult.VerificationManager;
import
com.ui.automation.config.Constants;
import
com.ui.automation.dataprovider.Testdata;

import
com.ui.automation.helper.Ecommercshelper;
import
com.ui.automation.pages.ClearancePage;
import
com.ui.automation.pages.HomePage;
import com.ui.automation.pages.HotsaucesPage;
import com.ui.automation.pages.Loginpage;
import
com.ui.automation.pages.ShoppingCartPage;
import
com.ui.automation.testsuite.TestSuiteBase;

/**
 * @author venkata.muppidi
 *
 */

public class TestHotSauces extends TestSuiteBase { 
	XlsReader xlsReader =new
			XlsReader();

	private ReportLogService report = new
			ReportLogServiceImpl(TestHotSauces.class);

	Testdata testData=new Testdata();
	Ecommercshelper Echelper; 
	Loginpage loginpage;
	HomePage homepage; 
	ClearancePage clearancePage; 
	ShoppingCartPage shoppingcart;
	HotsaucesPage hotsaucesPage;
	public String testDataFilePath = Constants.ECCOMMERS_TEST_DATA_HOME;
	public String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
	public String Product_testDataSheetName= Constants.PRODUCT_TEST_DATA; 
	public	Properties Clearance=testData.loadProperties(Constants.CLEARANCE);
	public	Properties Homepage=testData.loadProperties(Constants.HOMEPAGE); 
	public	Properties Loginpage=testData.loadProperties(Constants.LOGINPAGE); 
	public	Properties Hotsauces=testData.loadProperties(Constants.HOTSAUCES); 
	public	Properties Shopingcart=testData.loadProperties(Constants.SHOPPINGCART); 
	//	Launching the site

	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void	Lunchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("launching the portal homepage"); 
		Echelper = new	Ecommercshelper(browser);
		homepage=new HomePage(browser); 
		loginpage=new Loginpage(browser); 
		shoppingcart=new ShoppingCartPage(browser);
		clearancePage=new ClearancePage(browser);
		hotsaucesPage =new HotsaucesPage(browser);
		Echelper.launchsite(os, osVersion,br, browserVersion);
		}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		Object[][]	testdata=testData.testdata(testDataFilePath, testDataSheetName);
		return	testdata;
		}
	@Test (dataProvider="testdata")
	public void placeNewlyArrived(String username,String password,String
			Country) {
		report.info("Log into website ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		Echelper.login(username, password, Country);
		homepage.selectcountry(Country);
		VerificationManager.verifyString(browser.getDriver().findElement(By.xpath(Homepage.getProperty("imageverification"))).getAttribute("title"), Country, "Country name is same");
		homepage.clickHotsauceslink(); 
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			return;
		}
		int rowCount = xlsReader.getRowCount(Product_testDataSheetName);
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			String manufuturename=xlsReader.getCellDataByColumnName(Product_testDataSheetName, "Manufacturer", iRow);
			browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
		hotsaucesPage.selectManufuturename(manufuturename);
		String productname=hotsaucesPage.selectNewArrival();
		browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
		VerificationManager.verifyString(productname,
		browser.getDriver().findElement(By.xpath(Shopingcart.getProperty("Verify_Product_Name"))).getText(), "Product name same");
		Boolean present=true;
		Boolean present2=browser.getDriver().findElement(By.xpath(Shopingcart.getProperty("outofstock"))).isDisplayed();
		if(present==present2) {
			report.info("Product out of stock");
			browser.getDriver().navigate().back();
			browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
			browser.getDriver().findElement(By.xpath(Hotsauces.getProperty("Manufuture_name")+manufuturename+Hotsauces.getProperty("HotSauces_endpoint"))).click();
		}
		else{	
			shoppingcart.clickonAddtocart();
			shoppingcart.clickonConfirmOrder();
		}
		
		}
	
	} 
	
}
