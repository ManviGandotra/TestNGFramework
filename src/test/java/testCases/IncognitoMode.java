package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class IncognitoMode {
	
	@Test
	public void incognitoWindow() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.8.0");
	}

}
