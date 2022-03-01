package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		if(!TestUtil.isTestRunnable(result.getName(), excel)) {
			throw new SkipException("Skipping the test: "+ result.getName()+" as runmode is set to NO");
		}

	}

	public void onTestSuccess(ITestResult result) {
		TestBase.test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASSED");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		try { TestUtil.captureScreenShot();} catch (IOException e) {e.printStackTrace();}
		
		TestBase.test.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAILED WITH EXCEPTION"+result.getThrowable());
		TestBase.test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));	

	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as runmode is NO");
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
