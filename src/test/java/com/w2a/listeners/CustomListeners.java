package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		//test = rep.startTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		TestBase.test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASSED");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		try { TestUtil.captureScreenShot();} catch (IOException e) {e.printStackTrace();}
		
		TestBase.test.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAILED WITH EXCEPTION"+result.getThrowable());
		TestBase.test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));	
		rep.endTest(test);
		rep.flush();
		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Click to see screenshot: <br/>");
		Reporter.log("<a target=\"blank\" href="+TestUtil.screenShotName+">Screenshot</a>");
		Reporter.log("<br/>");
		Reporter.log("<a target=\"blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+" height=300 width=300 /></a>");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		test = rep.startTest(context.getName().toUpperCase());
		
	}

	public void onFinish(ITestContext context) {
		rep.endTest(test);
		rep.flush();
		
	}

}
