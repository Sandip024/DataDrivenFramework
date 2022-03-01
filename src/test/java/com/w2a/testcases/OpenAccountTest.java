package com.w2a.testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(String customer, String currency) throws InterruptedException {
		
		click("openAcct_XPATH");
		select("customer_XPATH", customer);
		select("currency_XPATH", currency);
		click("process_XPATH");
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
	}
}
