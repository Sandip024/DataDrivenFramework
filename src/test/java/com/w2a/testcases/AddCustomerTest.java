package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {
		
		System.out.println(data.get("firstname"));
		System.out.println(data.get("lastname"));
		System.out.println(data.get("postcode"));
		
		
		click("addCustBtn_XPATH");
		type("firstname_XPATH", data.get("firstname"));
		type("lastname_XPATH", data.get("lastname"));
		type("postcode_XPATH", data.get("postcode"));
		click("addbtn_XPATH");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")), "Customer added successfully");
		alert.accept();


	}
	
}
