package com.ui.automation.helper;

import java.io.IOException;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.ui.automation.testscript.TestRegisterMember;
import com.ui.automation.testsuite.TestSuiteBase;

public class RegisterMemberhelper extends TestSuiteBase{
	
	XlsReader xlsReader =new XlsReader();
	private ReportLogService report = new ReportLogServiceImpl(RegisterMemberhelper.class);
	
	public void product(String testDataFilePath, String testDataSheetName) throws Exception {
		try {
			xlsReader.setPath(testDataFilePath);
		} catch (IOException ioException) {
			report.error("IOExeption occured as " + ioException.getMessage());
			return;
		}
		int rowCount = xlsReader.getRowCount(testDataSheetName);
		
		for (int iRow = 1; iRow <= rowCount; iRow++) {
		}
	}
	
	public RegisterMemberhelper(Browser browser) {
		this.browser=browser;
	}

}
