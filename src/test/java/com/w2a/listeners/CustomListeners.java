package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.utilities.TestUtil;

public class CustomListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot: <br/>");
		try { TestUtil.captureScreenShot();} catch (IOException e) {e.printStackTrace();}
		Reporter.log("<a target=\"blank\" href="+TestUtil.screenShotName+">Screenshot</a>");
		Reporter.log("<br/>");
		Reporter.log("<a target=\"blank\" href="+TestUtil.screenShotName+"><img src="+TestUtil.screenShotName+" height=400 width=400 /></a>");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
