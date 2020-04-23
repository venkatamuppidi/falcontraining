/**
 * 
 */
package com.ui.automation.testscript;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.ui.automation.config.Constants;
import com.ui.automation.dataprovider.Testdata;
import com.ui.automation.helper.CommonMethods;
import com.ui.automation.helper.Ecommercshelper;
import com.ui.automation.pages.ClearancePage;
import com.ui.automation.pages.HomePage;
import com.ui.automation.pages.Loginpage;
import com.ui.automation.pages.Productpage;
import com.ui.automation.pages.ShoppingCartPage;
import com.ui.automation.pages.Womenpage;
import com.ui.automation.testsuite.TestSuiteBase;

/**
 * @author venkata.muppidi
 *
 */
public class TestSearchingforProduct extends TestSuiteBase {
	XlsReader xlsReader =new XlsReader();

	private ReportLogService report = new ReportLogServiceImpl(TestSearchingforProduct.class);

	Testdata testData=new Testdata();
	Ecommercshelper Echelper;
	Loginpage loginpage;
	Productpage productpage;
	HomePage homepage;
	CommonMethods commonmethods;
	ClearancePage clearancePage;
	ShoppingCartPage shoppingcart;
	public String testDataFilePath = Constants.ECCOMMERS_TEST_DATA_HOME;
	public String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
	public   Properties Clearance=testData.loadProperties(Constants.CLEARANCE);
	public   Properties Homepage=testData.loadProperties(Constants.HOMEPAGE);
	// Launching the site 
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void Lunchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("launching the portal homepage");
		Echelper = new Ecommercshelper(browser);
		homepage=new HomePage(browser);
		loginpage=new Loginpage(browser);
		productpage =new Productpage(browser);
		shoppingcart=new ShoppingCartPage(browser);
		commonmethods =new CommonMethods(browser);
		clearancePage=new ClearancePage(browser);
		Echelper.launchsite(os, osVersion, br, browserVersion);
	}
	//Providing the Maild and Password through the excel 
	@DataProvider(name = "testdata") 
	public Object[][] getTestData() {
		Object[][] testdata=testData.logindata(testDataFilePath, testDataSheetName); 
		return testdata;
	}

	/*
	 * Login into the application and search for and comparing the price in
	 * clearance page and page product
	 * 
	 * Getting data from the excel testdata
	 */
	@Test(dataProvider = "testdata",enabled = true)
	public void Logintowebsite(String username ,String password,String Country) throws Exception {
		report.info("Log into website ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		homepage.clickonlogin(); loginpage.enterUsername(username);
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		loginpage.enterpassword(password);
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		loginpage.clickonLoginbutton();
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		System.out.println("countryname"+Country); homepage.selectcountry(Country);
		homepage.clickClearancelink();
		int elements = browser.getDriver().findElements(By.xpath(Clearance.getProperty("Clearance_productname"))).size();
		System.out.println("size"+elements);
		String productname=clearancePage.listofproduct();
		System.out.println("productname"+productname);
		homepage.clickClearancelink();
		String pricename=clearancePage.Productprice(productname);
		System.out.println("Pricename"+pricename);
		homepage.clickonHomelink();
		homepage.Searchforproduct(productname);
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		VerificationManager.verifyString(pricename, browser.getDriver().findElement(By.xpath(Clearance.getProperty("Clearance_productname_price")+productname+Clearance.getProperty("Clearance_price_endpoint"))).getText(), "Price was different");
		homepage.Logout();
	}

	
}
