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
	
	//Loading the properties file
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
    public Object[][] testdata(String testDataFilePath,String testDataSheetName){
    	
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
