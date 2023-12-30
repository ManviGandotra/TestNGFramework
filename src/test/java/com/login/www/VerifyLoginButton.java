package com.login.www;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.HomePageObjects;
import pageObjectModel.LoginPageObjects;
import resources.BaseClass;

public class VerifyLoginButton extends BaseClass {
	
	@Test(dataProvider = "testData")
	public void verifyLogin(String username, String password) throws IOException, InterruptedException {
		driverInitialize();
		System.out.println("Webpage launched");
		Thread.sleep(3000);
		HomePageObjects hpo=new HomePageObjects(driver);
		//excplicit wait
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	
		
		hpo.getSignInButton().click();
		Thread.sleep(4000);
		//driver.findElement(By.id("field-email")).sendKeys("neha.sharma");
		LoginPageObjects lpo=new LoginPageObjects(driver);
		lpo.getEmail().sendKeys(username);
		lpo.getPassword().sendKeys(password);
		lpo.getSubmitButton().click();
		//fluent wait
		/*
		 * FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		 * wait.withTimeout(Duration.ofSeconds(5));
		 * wait.pollingEvery(Duration.ofMillis(200));
		 * wait.ignoring(NoAlertPresentException.class);
		 * wait.until(ExpectedConditions.alertIsPresent());
		 */
		
		
		
		
		String errorMessage=driver.findElement(By.xpath("//li[contains(text(),'Authentication failed')]")).getText();
    	String expectedMessage="Authentication failed.";
		Assert.assertEquals(errorMessage, expectedMessage);
    	System.out.println("Invalid credentials");
		//driver.findElement(By.id("field-password")).sendKeys("Neha");
		//driver.findElement(By.id("submit-login")).click();
	}
	@DataProvider
	public Object[][] testData() {
		Object[][] data=new Object[3][2];
		data[0][0]="neha12@gmail.com";
		data[0][1]="43436";
		data[1][0]="riya@gmail.com";
		data[1][1]="ggggg";
		data[2][0]="rahul@gmail.com";
		data[2][1]="hhhhddd";
		//data[3][0]="hhhhqqqq";
		//above code with throw error- index 3 out of bound
		return data;
		
	}

}
