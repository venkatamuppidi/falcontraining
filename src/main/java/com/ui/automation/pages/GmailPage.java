/**
 * 
 */
/*
 * package com.ui.automation.pages;
 * 
 * import java.util.Properties;
 * 
 * import org.openqa.selenium.By;
 * 
 * import com.atmecs.falcon.automation.ui.selenium.Browser; import
 * com.atmecs.falcon.automation.util.enums.LocatorType; import
 * com.atmecs.falcon.automation.util.reporter.ReportLogService; import
 * com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl; import
 * com.ui.automation.config.Constants; import
 * com.ui.automation.dataprovider.Testdata;
 * 
 *//**
	 * @author venkata.muppidi
	 *
	 *//*
		 * public class GmailPage { private static final ReportLogService report=new
		 * ReportLogServiceImpl(GmailPage.class); Testdata testData=new Testdata();
		 * public Properties gmailpage=testData.loadProperties(Constants.GMAIL);
		 * 
		 * Browser browser;
		 * 
		 * 
		 * public void Enterusername(String gmailid) {
		 * 
		 * report.info("enter the Gmaiid");
		 * browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		 * browser.getTextField().enterTextField(LocatorType.ID,
		 * gmailpage.getProperty("Username"), gmailid); } public void
		 * EnterPassword(String password) { report.info("enter the Password");
		 * browser.getWait().implicitWait(Constants.MIN_WAIT_TIME);
		 * browser.getTextField().enterTextField(LocatorType.XPATH,
		 * gmailpage.getProperty("Password"), password); } public void clickOnNext() {
		 * report.info("click on Next button");
		 * browser.getWait().HardPause(Constants.MIN_WAIT_TIME);
		 * browser.getDriver().findElement(By.xpath(gmailpage.getProperty("Next_button")
		 * )).click(); browser.getWait().implicitWait(Constants.MIN_WAIT_TIME); }
		 * 
		 * public void Iconbutton() { report.info("click on Icon button");
		 * browser.getDriver().findElement(By.xpath(gmailpage.getProperty("clickonicon")
		 * )).click(); } public void clickonsignout() {
		 * report.info("click on Signout button");
		 * browser.getDriver().findElement(By.xpath(gmailpage.getProperty("signout"))).
		 * click(); browser.getWait().implicitWait(Constants.MIN_WAIT_TIME); } public
		 * void ClickonFirstmail() { report.info("click on firstmail ");
		 * browser.getDriver().findElement(By.xpath(gmailpage.getProperty(
		 * "clcikonFirstmail"))).click(); } public GmailPage(Browser browser) {
		 * this.browser=browser;
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * 
		 */