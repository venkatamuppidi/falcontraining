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
	

public Object[][] ProductData(String testDataFilePath,String testDataSheetName){
		
		
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			
		}
		int rowCount = xlsReader.getRowCount(testDataSheetName);
		
		Object[][] mydata1= new Object[rowCount][5];
		for (int iRow = 1; iRow <= rowCount; iRow++) {
			String Productname=xlsReader.getCellDataByColumnName(testDataSheetName, "ProductName", iRow);
			String Size=xlsReader.getCellDataByColumnName(testDataSheetName, "Size", iRow);
			String Color =xlsReader.getCellDataByColumnName(testDataSheetName, "Color", iRow);
			String Expectedmessage=xlsReader.getCellDataByColumnName(testDataSheetName, "Expectedmessage", iRow);
			String Quanity=xlsReader.getCellDataByColumnName(testDataSheetName, "Quanity", iRow);
			mydata1[iRow - 1][0] = Productname;
			mydata1[iRow - 1][1] = Size;
			mydata1[iRow - 1][2] = Color;
			mydata1[iRow - 1][3] = Expectedmessage;
			mydata1[iRow - 1][4] = Quanity;
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
	 
}
