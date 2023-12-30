package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Timestamp;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.HomePageObjects;
import pageObjectModel.LoginPageObjects;
import resources.BaseClass;
import resources.HandleExcel;

public class HandleExcelTestCase extends BaseClass {
	
	@BeforeTest
	public void invokeBrowser() throws IOException {
		driverInitialize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test(enabled = false)
	public void readDataFromExcel() throws InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\nipun\\Desktop\\TestingData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell=row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
	}
	
	@Test
	public void getInputDataFromExcel() throws InvalidFormatException, IOException, InterruptedException {
		//driverInitialize();
		System.out.println("Driver intialized");
		HandleExcel hExcel=new HandleExcel();
		//for loop to be added
		for(int i=1;i<5;i++) {
			Boolean authenticationFailure = false;
		String emailId=hExcel.readDataFromExcel(0, i, 1);
		String password=hExcel.readDataFromExcel(1, i, 1);
		HomePageObjects hp=new HomePageObjects(driver);
		//Thread.sleep(3000);
		hp.getSignInButton().click();
		//Thread.sleep(3000);
		LoginPageObjects lpo=new LoginPageObjects(driver);
		lpo.getEmail().clear();
		lpo.getEmail().sendKeys(emailId);
		lpo.getPassword().clear();
		lpo.getPassword().sendKeys(password);
		lpo.getSubmitButton().click();
		//Thread.sleep(3000);
		try{
			authenticationFailure=lpo.getAuthenticationFailed().isDisplayed();
		}
		catch(Exception e){
			System.out.println("No Authentication failure");
		}
		//System.out.println(authenticationFailure);
		if(authenticationFailure==true) {
			System.out.println("Authentication falied");
			getScreenShot();
			/*
			 * TakesScreenshot screenShot=((TakesScreenshot)driver); File
			 * srcFile=screenShot.getScreenshotAs(OutputType.FILE); File destFile=new
			 * File("C:\\Users\\nipun\\eclipse-workspace\\TestNgFramework\\Screenshots.png")
			 * ; FileUtils.copyFile(srcFile, destFile);
			 */
			System.out.println("screenshot taken");
		}
		else {
			System.out.println("Login successful");
			//Thread.sleep(3000);
			hp.getSignOutButton().click();
		}
		}
		
		
	}
}
