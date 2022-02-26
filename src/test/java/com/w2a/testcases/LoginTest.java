package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(2000);
		log.info("clicked on Bank Manager Login button");
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))),"login not successful");
		
		
	}

}
