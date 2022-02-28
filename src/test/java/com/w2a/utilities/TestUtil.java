package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenShotName;

	public static void captureScreenShot() throws IOException {
		
		Date d= new Date();
		screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
		
	}
	
	
	
}
