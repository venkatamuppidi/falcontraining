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
import com.ui.automation.pages.RegistrationPage;
import com.ui.automation.pages.ShoppingCartPage;
import com.ui.automation.pages.Womenpage;
import com.ui.automation.testsuite.TestSuiteBase;

/**
 * @author venkata.muppidi
 *
 */
public class TestNonRegisterMember  extends  TestSuiteBase{
	XlsReader xlsReader =new XlsReader();

	private ReportLogService report = new ReportLogServiceImpl(TestNonRegisterMember.class);

	Testdata testData=new Testdata();

	public   Properties Homepage=testData.loadProperties(Constants.HOMEPAGE);
	public   Properties Registration=testData.loadProperties(Constants.REGISTRATION);
	Ecommercshelper Echelper;
	Loginpage loginpage;
	Womenpage womenpage;
	Productpage productpage;
	HomePage homepage;
	RegistrationPage registrationpage;
	ShoppingCartPage shoppingcart;
	public String testDataFilePath = Constants.DASHBOARD_TEST_DATA_HOME;
	public String testDataSheetName_registration= Constants.REGISTRATION_TEST_DATA;
	public String testDataSheetName_Product= Constants.PRODUCT_TEST_DATA_SHEET;
//Launch the Site 
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void Lunchsite(String os, String osVersion, String br, String browserVersion) {
		report.info("launching the gmail homepage");
		Echelper = new Ecommercshelper(browser);
		homepage=new HomePage(browser);
		loginpage=new Loginpage(browser);
		womenpage=new Womenpage(browser);
		productpage =new Productpage(browser);
		registrationpage =new RegistrationPage(browser);
		shoppingcart =new ShoppingCartPage(browser);
		Echelper.launchsite(os, osVersion, br, browserVersion);
	}
	//Providing the test data for registration form
	@DataProvider(name = "testdata") 
	public Object[][] getTestData() {
		Object[][] testdata1=testData.Registerdata(testDataFilePath, testDataSheetName_registration); 
		return testdata1;
	}
	
	@Test(dataProvider = "testdata")
	public void RegisteraMember(String NewMailid,String title ,String firstname, String lastname, String Password,String Address,String City,String State,String Pincode,String Mobilenum,String Dob) {
		report.info("Register a member ");

		VerificationManager.verifyBoolean(browser.getDriver().findElement(By.xpath(
				Homepage.getProperty("Homepage_my_customer_acccount"))).isDisplayed(), false, "Member already registered");

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
			String Productname=xlsReader.getCellDataByColumnName(testDataSheetName_Product, "ProductName", iRow);
			String Size=xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Size", iRow);
			String Color =xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Color", iRow);
			String Expectedmessage=xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Expectedmessage", iRow);
			String Quanity=xlsReader.getCellDataByColumnName(testDataSheetName_Product, "Quanity", iRow);
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
		shoppingcart.clickonProceedtocheckout();
		Boolean value=browser.getDriver().findElement(By.xpath(
				Registration.getProperty("Signtab"))).isDisplayed();
		if(value==true) {
			loginpage.EntertheNewMailAddress(NewMailid);
			loginpage.clickonCreateanAccount();
			if (browser.getDriver().findElement(By.xpath(Registration.getProperty("Error_alert_message"))).isDisplayed()==true){		
				VerificationManager.verifyTrueAndStopTest(false, "An account using this email address has already been registered. Please enter a valid password or request a new one.");
			}
			 else if(true) {
			registrationpage.clickonTitle(title);
			registrationpage.enterfirstName(firstname);
			registrationpage.enterlastName(lastname);
			registrationpage.enterpassword(Password);
			registrationpage.EntertheAddress(Address);
			registrationpage.EntertheCity(City);
			registrationpage.clickonSate(State);
			registrationpage.EntertheZipcode(Pincode);
			registrationpage.EnterthePhonenum(Mobilenum);
			registrationpage.entertheDob(Dob);
			registrationpage.clickonRegisterButton();
			}
		}
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

