package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessOperation {
	
	@Test
		public void getPage() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.8.0");
		System.out.println("Headless operation");
	}
	


}
