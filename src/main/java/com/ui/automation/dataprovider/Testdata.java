/**
 * 
 */
package com.ui.automation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;


/**
 * @author venkata.muppidi
 *
 */
public class Testdata  {
	private ReportLogService report = new ReportLogServiceImpl(Testdata.class);

	XlsReader xlsReader =new XlsReader();
	
	public Object[][] Data(String testDataFilePath,String testDataSheetName){
		
		
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			
		}
		int rowCount = xlsReader.getRowCount(testDataSheetName);
		Object[][] mydata= new Object[rowCount][2];
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			String mobnum=xlsReader.getCellDataByColumnName(testDataSheetName, "username", iRow);
			String password=xlsReader.getCellDataByColumnName(testDataSheetName, "password", iRow);
			mydata[iRow - 1][0] = mobnum;
			mydata[iRow - 1][1] = password;
		}
		return mydata;
}
	

public Object[][] Registerdata1(String testDataFilePath,String testDataSheetName){
		
		
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			
		}
		int rowCount = xlsReader.getRowCount(testDataSheetName);
		
		Object[][] mydata1= new Object[rowCount][10];
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			String NewMailid=xlsReader.getCellDataByColumnName(testDataSheetName, "NewMailid", iRow);
			String title=xlsReader.getCellDataByColumnName(testDataSheetName, "Title", iRow);
			String firstname =xlsReader.getCellDataByColumnName(testDataSheetName, "FirstName", iRow);
			String lastname=xlsReader.getCellDataByColumnName(testDataSheetName, "LastName", iRow);
			String Password=xlsReader.getCellDataByColumnName(testDataSheetName, "Password", iRow);
			String Address=xlsReader.getCellDataByColumnName(testDataSheetName, "Address", iRow);
			String City=xlsReader.getCellDataByColumnName(testDataSheetName, "City", iRow);
			String State =xlsReader.getCellDataByColumnName(testDataSheetName, "State", iRow);
			String Pincode=xlsReader.getCellDataByColumnName(testDataSheetName, "Pincode", iRow);
			String Mobilenum=xlsReader.getCellDataByColumnName(testDataSheetName, "MobileNum", iRow);
			String Dob=xlsReader.getCellDataByColumnName(testDataSheetName, "DOB", iRow);
			mydata1[iRow - 1][0] = NewMailid;
			mydata1[iRow - 1][1] = title;
			mydata1[iRow - 1][2] = firstname;
			mydata1[iRow - 1][3] = lastname;
			mydata1[iRow - 1][4] = Password;
			mydata1[iRow - 1][5] = Address;
			mydata1[iRow - 1][6] = City;
			mydata1[iRow - 1][7] = State;
			mydata1[iRow - 1][8] = Pincode;
			mydata1[iRow - 1][6] = Mobilenum;
			mydata1[iRow - 1][7] = Dob;
			
			
		}
		
		return mydata1;

}

	

    public   Properties loadProperties(String propertyFilePath ) { 
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
	 

//Reading the test data from excel    
    public Object[][] Registerdata(String testDataFilePath,String testDataSheetName){
    	
    	try {
    		xlsReader.setPath(testDataFilePath);
    	} catch (IOException ioException) {
    		report.error("IOExeption occured as " + ioException.getMessage());
    	}
    	int rowCount = xlsReader.getRowCount(testDataSheetName);
    	int colcount=xlsReader.getColumnCount(testDataSheetName);
    		Object[][] data=new Object[rowCount][xlsReader.getColumnCount(testDataSheetName)];
	
    		for(int i=0;i<rowCount;i++) {
    			for(int j=0;j<colcount;j++) {
    				data[i][j]=	xlsReader.getCellDataByColumnIndex(testDataSheetName, j, (i+1));	
		}
	}
			
	return data;
}
    
    
  //Reading the test data from excel    
    public Object[][] logindata(String testDataFilePath,String testDataSheetName){
    	
    	try {
    		xlsReader.setPath(testDataFilePath);
    	} catch (IOException ioException) {
    		report.error("IOExeption occured as " + ioException.getMessage());
    	}
    	int rowCount = xlsReader.getRowCount(testDataSheetName);
    	int colcount=xlsReader.getColumnCount(testDataSheetName);
    		Object[][] data=new Object[rowCount][xlsReader.getColumnCount(testDataSheetName)];
	
    		for(int i=0;i<rowCount;i++) {
    			for(int j=0;j<colcount;j++) {
    				data[i][j]=	xlsReader.getCellDataByColumnIndex(testDataSheetName, j, (i+1));	
		}
	}
			
	return data;
}
}
