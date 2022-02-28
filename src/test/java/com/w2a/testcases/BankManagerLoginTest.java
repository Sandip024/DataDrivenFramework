package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		click("bmlBtn_XPATH");

		Thread.sleep(1000);
		log.info("clicked on Bank Manager Login button");
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn_XPATH"))),"login not successful");
		
		Assert.fail("Login not succesfull");
	}

}
