package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenShotName;

	public static void captureScreenShot() throws IOException {
		
		Date d= new Date();
		screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
		
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String, String> table = null;
		
		for(int rowNum=2; rowNum<=rows;rowNum++) {
			
			table = new Hashtable<String, String>();
			
			for(int colNum=0; colNum<cols;colNum++) {
				
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0]=table;
			}
		}
		return data;
		
	}
	
	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		
		String sheetname = "test_suite";
		int rows=excel.getRowCount(sheetname);
		System.out.println("number of rows are: "+rows);
		
		for(int rNum=2; rNum<=rows; rNum++) {
			
			String testCase = excel.getCellData(sheetname, "TCID", rNum);
			System.out.println(testCase);
			if(testName.equalsIgnoreCase(testCase)) {
				String runmode = excel.getCellData(sheetname, "Runmode", rNum);
				System.out.println("Runmode is: "+runmode);
				if(runmode.equalsIgnoreCase("Y"))
						return true;

			}
			
		}
		
		return false;
	}
	
	
	
}
