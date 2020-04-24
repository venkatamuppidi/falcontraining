/**
 * 
 */
package com.ui.automation.testscript;

import java.util.ArrayList;
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
	public   Properties Loginpage=testData.loadProperties(Constants.LOGINPAGE);
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
	@Test(priority = 1,dataProvider = "testdata",enabled = false)
	public void Logintowebsite(String username ,String password,String Country) throws Exception {
		report.info("Log into website ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		homepage.clickonlogin();
		report.info("enter the username");
		loginpage.enterUsername(username);
		report.info("enter the password");
		loginpage.enterpassword(password);
		loginpage.clickonLoginbutton();
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		System.out.println("countryname"+Country);
		homepage.selectcountry(Country);
		Boolean account =true;
		if(account==browser.getDriver().findElement(By.xpath(Loginpage.getProperty("LoginPage_accountcircle"))).isDisplayed()) {
			homepage.Logout();
		}
		else {
			report.info("User not loged in sucessfully");
		}
	}
	//Search for the product
	@Test(priority = 2,dataProvider = "testdata",enabled = true)
	public void Searchfortheproduct(String username ,String password,String Country) {

		report.info("Log into website ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		homepage.clickonlogin(); report.info("enter the username");
		loginpage.enterUsername(username); report.info("enter the password");
		loginpage.enterpassword(password); loginpage.clickonLoginbutton();
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		System.out.println("countryname"+Country); homepage.selectcountry(Country);

		homepage.clickClearancelink();
		int elements = browser.getDriver().findElements(By.xpath(Clearance.getProperty("Clearance_productname"))).size();
		System.out.println("size"+elements);
		ArrayList<String> productname=clearancePage.listofproduct();
		for(int i=0;i<=elements;i++){
			System.out.println("productname"+productname);
			System.out.println("single product"+productname.get(i));
			homepage.clickClearancelink();
			String pricename=clearancePage.Productprice(productname.get(i));
			System.out.println("Pricename"+pricename);
			homepage.clickonHomelink();
			homepage.Searchforproduct(productname.get(i));
			int numofproducts=browser.getDriver().findElements(By.xpath(Homepage.getProperty("Homepage_listofproducts"))).size();
			if (numofproducts>1) {
				VerificationManager.verifyInteger(numofproducts, 1, "Showing multiple products");
				report.info("Showing multiple products");
			}
			else {
				VerificationManager.verifyString(pricename, browser.getDriver().findElement(By.xpath(Clearance.getProperty("Clearance_productname_price")+productname.get(i)+Clearance.getProperty("Clearance_price_endpoint"))).getText(), "Price was different");

			}
		}
		homepage.Logout();

	}



}
