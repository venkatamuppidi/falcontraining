/***
 *
 */
package com.ui.automation.testsuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.logging.LogLevel;
import com.atmecs.falcon.automation.util.logging.LogManager;
import com.atmecs.falcon.automation.util.parser.PropertyParser;

public class TestSuiteBase {
	
	protected Browser browser;

    @BeforeSuite
    public void preSetup() {
        browser = new Browser();
        LogManager.setLogLevel(LogLevel.valueOf(PropertyParser.readEnvOrConfigProperty("LOG_LEVEL")));
    }

    @AfterSuite
    public void teardown() {
        browser.closeBrowser();
    }
    
    
    public   static Properties loadProperties(String propertyFilePath ) { 
		 File file=new File(propertyFilePath);
		 FileInputStream fileInput=null; 
		 try {
			 fileInput=new FileInputStream(file);
		 }catch(FileNotFoundException e) { 
		e.printStackTrace(); } 
		Properties prop=new
		Properties(); 
		try { 
			prop.load(fileInput); 
		}catch(IOException e) {
			e.printStackTrace();
			}
		return prop; 
	  }
	 
}