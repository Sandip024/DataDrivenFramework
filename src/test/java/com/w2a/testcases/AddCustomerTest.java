package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {
		
		click("addCustBtn_XPATH");
		type("firstname_XPATH", firstName);
		type("lastname_XPATH", lastName);
		type("postcode_XPATH", postCode);
		click("addbtn_XPATH");
		/*
		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();
		*/
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertTrue(alertMessage.contains(alertText));
		//driver.switchTo().alert().dismiss();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertMessage), "Customer added successfully");
		alert.accept();
		
		Assert.fail("Customer not added successfully");
	
		
	}
	
	@DataProvider
	public Object[][] getData(){
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum=2; rowNum<=rows;rowNum++) {
			for(int colNum=0; colNum<cols;colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
		
	}

}
