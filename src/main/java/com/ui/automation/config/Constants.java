/**
 * 
 */
package com.ui.automation.config;

import java.io.File;

/**
 * @author venkata.muppidi
 *
 */
public class Constants {
	public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
	public static final String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator;
	
	
	
	
	//PAGE OBJECTS 
	
	public static final String TEST_DATA_HOME_PAGE_OBJECTS = RESOURCES_HOME + "pageobjects" + File.separator;
	//TestData
	public static final String TEST_DATA_HOME = RESOURCES_HOME + "Testdata" + File.separator;
	//PAGE OBJECTS FOR DASHBOARD
	public static final String LOGINPAGE=TEST_DATA_HOME_PAGE_OBJECTS+"LoginPage.properties";
	public static final String HOMEPAGE=TEST_DATA_HOME_PAGE_OBJECTS+"Homepage.properties";
	public static final String WOMENPAGE=TEST_DATA_HOME_PAGE_OBJECTS+"Womenpage.properties";
	public static final String SHOPPINGCART=TEST_DATA_HOME_PAGE_OBJECTS+"ShoppingCart.properties";
	
	public static final String DASHBOARD_TEST_DATA_HOME =TEST_DATA_HOME + "selenium.xlsx";
	public static final String DASHBOARD_TEST_DATA_SHEET ="Credentials";
	public static final String PRODUCT_TEST_DATA_SHEET ="Productdetails";
	
	
	//Wait Constants
	public static final long MIN_WAIT_TIME=2000;
	public static final long lESS_WAIT_TIME=2000;
	public static final long WAIT_FOR_WINDOW_TO_SWITCH=5000;
	public static final long MAX_EXPLICITY_WAIT_TIME=7000;
	public static final long MAX_WAIT_TIME=1000;
	public static final long PAGELOADTIME=30000;
}
