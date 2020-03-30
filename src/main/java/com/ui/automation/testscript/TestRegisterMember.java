/**
 * 
 */
package com.ui.automation.testscript;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
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
public class TestRegisterMember extends TestSuiteBase{

	XlsReader xlsReader =new XlsReader();

	private ReportLogService report = new ReportLogServiceImpl(TestRegisterMember.class);

	Testdata testData=new Testdata();

	public   Properties Homepage=testData.loadProperties(Constants.HOMEPAGE);
	Ecommercshelper Echelper;
	Loginpage loginpage;
	Womenpage womenpage;
	Productpage productpage;
	HomePage homepage;
	ShoppingCartPage shoppingcart;
	public String testDataFilePath = Constants.DASHBOARD_TEST_DATA_HOME;
	public String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
	public String testDataSheetName_Product= Constants.PRODUCT_TEST_DATA_SHEET;
	// Launching the site 
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void Lunchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("launching the portal homepage");
		Echelper = new Ecommercshelper(browser);
		homepage=new HomePage(browser);
		loginpage=new Loginpage(browser);
		womenpage=new Womenpage(browser);
		productpage =new Productpage(browser);
		shoppingcart=new ShoppingCartPage(browser);
		Echelper.launchsite(os, osVersion, br, browserVersion);
	}
	//Providing the Maild and Password through the excel 
	@DataProvider(name = "testdata") 
	public Object[][] getTestData() {
		Object[][] testdata=testData.Data(testDataFilePath, testDataSheetName); 
		return testdata;
	}

	@Test(dataProvider = "testdata") 
	public void LogintoGmail(String mailid ,String pwrd) throws Exception {
		report.info("Log into website ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		homepage.clickonSignin();
		loginpage.enterUsername(mailid);
		browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
		loginpage.enterpassword(pwrd); 
		browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
		loginpage.clickonSignIn();
		browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
		VerificationManager.verifyBoolean(browser.getDriver().findElement(By.xpath(
				Homepage.getProperty("Homepage_my_customer_acccount"))).isDisplayed(), true, "Member not login sucessfully"); 

		report.info("click on Tops ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			return;
		}
		int rowCount = xlsReader.getRowCount(testDataSheetName_Product);
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			String Expectedmessage=xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Expectedmessage", iRow);
			homepage.clickonWomenlink();
			browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
			womenpage.ClickonTops();
			browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
			productpage.Selectproduct(xlsReader.getCellDataByColumnName(testDataSheetName_Product, "ProductName", iRow));
			productpage.providesize(xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Size", iRow));
			productpage.Selectquanity(xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Quanity", iRow));
			productpage.Selectcolor(xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Color", iRow));
			productpage.Addtocart();
			Boolean present=VerificationManager.verifyString(browser.getDriver().findElement(By.xpath(Homepage.getProperty("Women_assert_message"))).getText(), Expectedmessage, "Product not Added sucessfully");
			if (present.equals(true)) {
				browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
				productpage.clickonContinueShopping();
			}
		}
		productpage.clickonProceedtoCheckout();
		shoppingcart.clickonProceedtocheckout();
		shoppingcart.clickonProceedtocheckout();
		shoppingcart.clickonAgreecheckbox();
		shoppingcart.clickonPayBybankwire();
		shoppingcart.clickonConfirmOrder();

	}


	@AfterMethod
	public void teardown() {
		browser.getDriver().quit();
	}

}
