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
	public String testDataFilePath = Constants.DASHBOARD_TEST_DATA_HOME;
	public String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
	public String testDataSheetName_Product= Constants.PRODUCT_TEST_DATA_SHEET;

	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void LunchGmailsite(String os, String osVersion, String br, String browserVersion) {
		report.info("launching the gmail homepage");
		Echelper = new Ecommercshelper(browser);
		homepage=new HomePage(browser);
		loginpage=new Loginpage(browser);
		womenpage=new Womenpage(browser);
		productpage =new Productpage(browser);
		Echelper.launchsite(os, osVersion, br, browserVersion);
	}
	  @DataProvider(name = "testdata") 
	  public Object[][] getTestData() {
		  Object[][] testdata=testData.Data(testDataFilePath, testDataSheetName); 
		  return testdata;
	  }
	  
	  @Test(priority=1,dataProvider = "testdata") 
	  public void LogintoGmail(String mailid ,String pwrd) throws Exception {
		  report.info("Log into website ");
	  browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
	  homepage.clickonSignin(); loginpage.enterUsername(mailid);
	  loginpage.enterpassword(pwrd); loginpage.clickonSignIn();
	  VerificationManager.verifyBoolean(browser.getDriver().findElement(By.xpath(
	  Homepage.getProperty("Homepage_my_customer_acccount"))).isDisplayed(), true, "Member not login sucessfully"); 
	  }
	 
	@Test(priority=2)
	public void AddTopstotheCart() {
		report.info("click on Tops ");
		browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			return;
		}
		int rowCount = xlsReader.getRowCount(testDataSheetName);
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			String Productname=xlsReader.getCellDataByColumnName(testDataSheetName, "ProductName", iRow);
			String Size=xlsReader.getCellDataByColumnName(testDataSheetName, "Size", iRow);
			String Color =xlsReader.getCellDataByColumnName(testDataSheetName, "Color", iRow);
			String Expectedmessage=xlsReader.getCellDataByColumnName(testDataSheetName, "Expectedmessage", iRow);
			String Quanity=xlsReader.getCellDataByColumnName(testDataSheetName, "Quanity", iRow);
			homepage.clickonWomenlink();
			womenpage.ClickonTops();
			productpage.Selectproduct(Productname);
			productpage.providesize(Size);
			productpage.Selectquanity(Quanity);
			productpage.Selectcolor(Color);
			productpage.Addtocart();
			Boolean present=VerificationManager.verifyString(browser.getDriver().findElement(By.xpath(Homepage.getProperty("Women_assert_message"))).getText(), Expectedmessage, "Product not Added sucessfully");
			if (present.equals(true)) {
				productpage.clickonContinueShopping();
			}
		}
		productpage.clickonProceedtoCheckout();
	}


	@AfterMethod
	public void teardown() {
		browser.getDriver().quit();
	}

}
