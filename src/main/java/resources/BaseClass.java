package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;

	public void driverInitialize() throws IOException {
		/*
		 * FileInputStream fis=new FileInputStream(
		 * "C:\\Users\\nipun\\eclipse-workspace\\TestNgFramework\\src\\main\\java\\resources\\data.properties"
		 * ); Properties prop=new Properties(); prop.load(fis);
		 */
		//String browserName=prop.getProperty("browser");
		String browserName=readDataFromProperties("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			driver.get("https://testground.internsified.com/");
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get("https://testground.internsified.com/");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.get("https://testground.internsified.com/");
		}
		else {
			System.out.println("No such browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void driverInitializeIncognito() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	public String readDataFromProperties(String s) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\nipun\\eclipse-workspace\\TestNgFramework\\src\\main\\java\\resources\\data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(s);
	}
	
	public void getScreenShot() throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		//String timeStamp1=getCurrentDateTime();
		String timeStamp=getCurrentTimeStamp();
		File destFile=new File("C:\\Users\\nipun\\eclipse-workspace\\TestNgFramework\\Screenshots\\Screenshot"+ timeStamp+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	
	public String getCurrentDateTime() {
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 Date date=new Date();
		 String currentDateTimeStamp=dateFormat.format(date);
		return currentDateTimeStamp;
		 
	}
	
	public String getCurrentTimeStamp() {
		
		long currentTimeMillis = System.currentTimeMillis();
		String timeStamp =""+currentTimeMillis;
		return timeStamp;
		
	}

}
