package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromAFile {
	
	WebDriver driver;
	
	public void driverInitialize() throws IOException {
	driver= new ChromeDriver();
	driver.get(readDataFromPropertiesFile("url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	
	}
	
	
	
	public String readDataFromPropertiesFile(String attribute) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\nipun\\eclipse-workspace\\TestNgFramework\\src\\main\\java\\resources\\data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		prop.getProperty(attribute);
	
		return attribute;
		
	}
	
	public void takeScreenShot() throws IOException {
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File src=screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\nipun\\eclipse-workspace\\TestNgFramework\\Screenshot.png");
		FileUtils.copyDirectory(src, dest);
		
	}
	
	public void readDataFromExcelFile() throws IOException {
		FileInputStream fs=new FileInputStream("https://d.docs.live.net/1d4582574347729f/AmazonProductsWrite.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow row=sheet.getRow(0);
		
		XSSFCell cell=row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		
	}

}
