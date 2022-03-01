package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener{

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

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ISuite suite) {
		MonitoringMail mail = new MonitoringMail();

		String messageBody = null;
		try {
			messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8090/job/DataDrivenMaven/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
