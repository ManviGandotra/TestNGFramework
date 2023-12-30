package testCases;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class AmazonPracticeTestCase extends BaseClass {
	
	@BeforeTest
	public void invokeBrowser() {
		driverInitializeIncognito();
	}
	
	@Test(enabled= false,priority=2)
	public void verifyDeptCellPhonesAndMenu() throws InterruptedException {
		driver.get("https://www.amazon.com/ref=nav_bb_logo");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		Thread.sleep(3000);
		WebElement selectAll=driver.findElement(By.xpath("//i[@class='nav-sprite hmenu-arrow-more']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",selectAll);
	    selectAll.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Electronics')]")).click();
		WebElement cellPhones=driver.findElement(By.xpath("//a[contains(text(),'Cell Phones & Accessories')]"));
		Actions a =new Actions(driver);
		a.moveToElement(cellPhones).build().perform();
		Thread.sleep(3000);
		a.click().build().perform();
		System.out.println("select cell phones and accessories from main menu");
		WebElement cellPhoneAndAccess=driver.findElement(By.xpath("//span[@class='nav-a-content'][normalize-space()='Cell Phones & Accessories']"));
	    Boolean cellPhonePresent= cellPhoneAndAccess.isDisplayed();
		Assert.assertTrue(cellPhonePresent);
		System.out.println("Cell phone and accessories page is open");
		Thread.sleep(3000);
	}
	
	@Test(enabled= false,priority=5)
	public void selectFiletersForCellPhones() throws InterruptedException {
		WebElement unlockedCellPhone=driver.findElement(By.xpath("//a[contains(text(),'Unlocked Phones')]"));
		unlockedCellPhone.click();
		System.out.println("user selects cell phones");
		Thread.sleep(3000);
		WebElement fourStarsAndUp=driver.findElement(By.xpath("//span[contains(text(),'4 Stars & Up')]"));
		fourStarsAndUp.click();
		Thread.sleep(3000);
		
	}
	
	@Test(enabled= false,priority=7)
	public void enterProductDataInExcelFile() {


		
		
	}

}
