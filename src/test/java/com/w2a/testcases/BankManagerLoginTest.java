package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {
		
		verifyEquals("abc", "xyz");
		Thread.sleep(1000);
		
		click("bmlBtn_XPATH");
		Thread.sleep(1000);
		log.info("clicked on Bank Manager Login button");
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn_XPATH"))),"login not successful");
	//	Assert.fail("Login not succesfull");
	}

}
