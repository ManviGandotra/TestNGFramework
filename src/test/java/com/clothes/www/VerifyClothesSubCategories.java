package com.clothes.www;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.ClothesPageObjects;
import pageObjectModel.HomePageObjects;
import pageObjectModel.MenClothingPageObjects;
import resources.BaseClass;

public class VerifyClothesSubCategories extends BaseClass {
	
	/*
	 * HomePageObjects hpo=new HomePageObjects(driver); ClothesPageObjects cpo=new
	 * ClothesPageObjects(driver); MenClothingPageObjects mcp=new
	 * MenClothingPageObjects(driver);
	 */
	
	
	 @BeforeTest public void invokeBrowser() throws IOException {
	 driverInitialize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 }
	 
	 @Test(priority=1)
	 public void verifyProductsInHomePage() {
		 HomePageObjects hpo=new HomePageObjects(driver);
		List<WebElement> productList= hpo.getProductsRow();
		System.out.println(productList.size());
		 java.util.Iterator<WebElement> it=productList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getText());
				
			}
	 }
	 
	
	@Test(enabled = false,priority = 2)
	public void verifyCategoriesCount() throws InterruptedException, IOException {
		//driverInitialize();
		HomePageObjects hpo=new HomePageObjects(driver);
		hpo.getClothes().click();
		//Thread.sleep(4000);
		ClothesPageObjects cpo=new ClothesPageObjects(driver);
		int actualSubCategoryCount=cpo.getSubcategory().size();
		System.out.println("Total Number of categories: "+actualSubCategoryCount);
		int expectedSubCategoryCount=2;
		if(actualSubCategoryCount==expectedSubCategoryCount) {
			System.out.println("Category count verified");
		}
	}
	
	@Test(enabled= false,priority = 5)
	public void verifyCategoryMen() throws IOException {
		ClothesPageObjects cpo=new ClothesPageObjects(driver);
		MenClothingPageObjects mcp=new MenClothingPageObjects(driver);
		cpo.getCategoryMen().click();
		//String expectedTitle=readDataFromProperties("expectedmenpagetitle");
		Boolean actualTitle=mcp.getTitle().isDisplayed();
		//System.out.println(actualTitle.toString());
		Assert.assertTrue(actualTitle);
		
		  if(actualTitle==true) 
		  { 
			  System.out.println("Men page title match: "+actualTitle); 
			  }
		 
		
	}
	

}
