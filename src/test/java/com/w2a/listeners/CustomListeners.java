package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot: <br/>");
		Reporter.log("<a target=\"blank\" href=\"C:\\Users\\sandip\\Desktop\\RAM_upgrade.png\">Screenshot</a>");
		Reporter.log("<br/>");
		Reporter.log("<a target=\"blank\" href=\"C:\\Users\\sandip\\Desktop\\RAM_upgrade.png\"><img src=\"C:\\Users\\sandip\\Desktop\\RAM_upgrade.png\" height=400 width=400 /></a>");
		
		
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
