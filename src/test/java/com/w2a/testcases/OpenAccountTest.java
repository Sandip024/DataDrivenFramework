package com.w2a.testcases;


import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {
		
		click("openAcct_XPATH");
		select("customer_XPATH", data.get("customer"));
		select("currency_XPATH", data.get("currency"));
		click("process_XPATH");
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
	}
}
