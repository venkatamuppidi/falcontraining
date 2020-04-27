/**
 * 
 */
package com.ui.automation.testscript;

import java.util.Properties;

import org.openqa.selenium.By;
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
import com.ui.automation.helper.Ecommercshelper;
import com.ui.automation.pages.ClearancePage;
import com.ui.automation.pages.HomePage;
import com.ui.automation.pages.Loginpage;
import com.ui.automation.pages.ShoppingCartPage;
import com.ui.automation.testsuite.TestSuiteBase;

/**
 * @author venkata.muppidi
 *
 */
public class TestMerchandise  extends TestSuiteBase{
	XlsReader xlsReader =new XlsReader();

	private ReportLogService report = new ReportLogServiceImpl(TestMerchandise.class);

	Testdata testData=new Testdata();
	Ecommercshelper Echelper;
	Loginpage loginpage;
	HomePage homepage;
	ClearancePage clearancePage;
	ShoppingCartPage shoppingcart;
	public String testDataFilePath = Constants.ECCOMMERS_TEST_DATA_HOME;
	public String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
	public   Properties Clearance=testData.loadProperties(Constants.CLEARANCE);
	public   Properties Homepage=testData.loadProperties(Constants.HOMEPAGE);
	public   Properties Loginpage=testData.loadProperties(Constants.LOGINPAGE);
	// Launching the site 
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void Lunchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("launching the portal homepage");
		Echelper = new Ecommercshelper(browser);
		homepage=new HomePage(browser);
		loginpage=new Loginpage(browser);
		shoppingcart=new ShoppingCartPage(browser);
		clearancePage=new ClearancePage(browser);
		Echelper.launchsite(os, osVersion, br, browserVersion);
	}
	//Providing the Maild and Password through the excel 
	@DataProvider(name = "testdata") 
	public Object[][] getTestData() {
		Object[][] testdata=testData.testdata(testDataFilePath, testDataSheetName); 
		return testdata;
	}

	/*
	 * Login into the application and search for and comparing the price in
	 * clearance page and page product
	 * 
	 * Getting data from the excel testdata
	 */
	//Login into the Website with vaild credentials
	@Test(priority = 1,dataProvider = "testdata",enabled = true)
	public void selectMerchandise(String username ,String password,String Country) throws Exception {
		report.info("Log into website ");
		Echelper.login(username, password, Country);
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		System.out.println("countryname"+Country);
		homepage.selectcountry(Country);
		VerificationManager.verifyString(browser.getDriver().findElement(By.xpath(Homepage.getProperty("imageverification"))).getAttribute("title"), Country, "Country name is same");


}
}
