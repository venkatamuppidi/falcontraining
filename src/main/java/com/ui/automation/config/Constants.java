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
	
	
	
	
	//PAGE OBJECTS PATH 
	
	public static final String TEST_DATA_HOME_PAGE_OBJECTS = RESOURCES_HOME + "pageobjects" + File.separator;
	//TestData
	public static final String TEST_DATA_HOME = RESOURCES_HOME + "Testdata" + File.separator;
	//PAGE OBJECTS FOR LOGIN PAGE
	public static final String LOGINPAGE=TEST_DATA_HOME_PAGE_OBJECTS+"LoginPage.properties";
	//PAGE OBJECTS FOR HOME PAGE
	public static final String HOMEPAGE=TEST_DATA_HOME_PAGE_OBJECTS+"Homepage.properties";
	//PAGE OBJECTS FOR SHOPPING PAGE
	public static final String SHOPPINGCART=TEST_DATA_HOME_PAGE_OBJECTS+"ShoppingCart.properties";
	//PAGE OBJECTS FOR REGISTRATION PAGE
	public static final String REGISTRATION=TEST_DATA_HOME_PAGE_OBJECTS+"RegistrationPage.properties";
	//PAGE OBJECTS FOR CLEARANCE PAGE
	public static final String CLEARANCE=TEST_DATA_HOME_PAGE_OBJECTS+"Clearance.properties";
	//PAGE OBJECTS FOR HOTSAUCES PAGE
	public static final String 	HOTSAUCES=TEST_DATA_HOME_PAGE_OBJECTS+"HotSauces.properties";
	//PAGE OBJECTS FOR MERCHANDISE PAGE
	public static final String 	MERCHANDISE=TEST_DATA_HOME_PAGE_OBJECTS+"Merchandise.properties";
	//PATH FOR TESTDATA FOR ECCOMERCE
	public static final String ECCOMMERS_TEST_DATA_HOME =TEST_DATA_HOME + "testdata.xlsx";
	//TEST DATA SHEET NAME'S
	public static final String DASHBOARD_TEST_DATA_SHEET ="Credentials";
	public static final String PRODUCT_TEST_DATA="Productdetails";
	
	
	//Wait Constants
	public static final long MIN_WAIT_TIME=2000;
	public static final long PAGELOADTIME=30000;
}
