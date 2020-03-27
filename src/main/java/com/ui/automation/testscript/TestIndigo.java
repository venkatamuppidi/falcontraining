/**
 * 
 */
/*
 * package com.ui.automation.testscript;
 * 
 * import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import
 * org.testng.annotations.DataProvider; import
 * org.testng.annotations.Parameters; import org.testng.annotations.Test;
 * 
 * import com.atmecs.falcon.automation.util.reporter.ReportLogService; import
 * com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl; import
 * com.ui.automation.config.Constants; import
 * com.ui.automation.dataprovider.Testdata; import
 * com.ui.automation.helper.Spiecejethelper; import
 * com.ui.automation.pages.Loginpage; import
 * com.ui.automation.testsuite.TestSuiteBase;
 * 
 *//**
	 * @author venkata.muppidi
	 *
	 *//*
		 * public class TestIndigo extends TestSuiteBase{
		 * 
		 * private ReportLogService report = new ReportLogServiceImpl(TestIndigo.class);
		 * Testdata testData=new Testdata(); Spiecejethelper spicejethelper; Loginpage
		 * loginpage; String testDataFilePath = Constants.DASHBOARD_TEST_DATA_HOME;
		 * String testDataSheetName= Constants.DASHBOARD_TEST_DATA_SHEET;
		 * 
		 * @BeforeMethod
		 * 
		 * @Parameters({"os", "osVersion", "browser", "browserVersion"}) public void
		 * LunchIndigosite(String os, String osVersion, String br, String
		 * browserVersion) { report.info("launching the Spicejet homepage");
		 * spicejethelper = new Spiecejethelper(browser); loginpage= new
		 * Loginpage(browser); spicejethelper.launchsite(os, osVersion, br,
		 * browserVersion); }
		 * 
		 * @DataProvider(name = "testdata") public Object[][] getTestData() { Object[][]
		 * testdata=testData.login(testDataFilePath, testDataSheetName); return
		 * testdata; }
		 * 
		 * @Test(dataProvider = "testdata") public void LogintoIndigo(String
		 * mobnum,String password) throws Exception {
		 * report.info("performing action on spicejet page");
		 * //spicejethelper.PerformactionHome();
		 * //spicejethelper.Indigologin(testDataFilePath, testDataSheetName);
		 * loginpage.clickonlogin(); loginpage.clickonMemberlogin();
		 * loginpage.entermobilenumber(mobnum); loginpage.enterpassword(password);
		 * loginpage.LoginClick(); }
		 * 
		 * 
		 * 
		 * 
		 * @AfterMethod public void teardown() { browser.closeBrowser(); }
		 * 
		 * 
		 * public void testData() { Object[][] data = getTestData();
		 * 
		 * for (Object[] cols : data) { for (Object object : cols) {
		 * System.out.println(object.toString()); } } }
		 * 
		 * 
		 * public static void main(String[] args) { new TestIndigo().testData(); }
		 * 
		 * 
		 * 
		 * 
		 * }
		 */