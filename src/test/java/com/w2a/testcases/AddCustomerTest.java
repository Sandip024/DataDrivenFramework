package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText) throws InterruptedException {
		
		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();
		Thread.sleep(2000);
		
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertTrue(alertMessage.contains(alertText));
		//driver.switchTo().alert().dismiss();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertMessage));
		alert.accept();
		
		
		
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
