package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingWindows {
	WebDriver driver=new ChromeDriver();
	@BeforeTest
	public void openBrowser() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Test(enabled= false)
	public void windowHandles() throws InterruptedException {
		
		driver.findElement(By.id("openwindow")).click();
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindowHandles=driver.getWindowHandles();
		Iterator<String> it=allWindowHandles.iterator();
		while(it.hasNext()) {
			String childWindow=it.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.xpath("(//ul[@class='navbar-nav ml-auto']/li)[5]")).click();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.id("opentab")).click();
		String parentWindow2=driver.getWindowHandle();
		Set<String> allWindowHandles2=driver.getWindowHandles();
		Iterator<String> it2=allWindowHandles2.iterator();
		while(it2.hasNext()) {
			String childWindow=it2.next();
			if(!parentWindow2.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.xpath("(//ul[@class='navbar-nav ml-auto']/li)[5]")).click();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(parentWindow2);
		
	}
	
	@Test (enabled= false)
	public void sameTabs() throws InterruptedException {
		driver.findElement(By.id("opentab")).click();
		driver.findElement(By.id("opentab")).click();
		String parentWindow2=driver.getWindowHandle();
		Set<String> allWindowHandles2=driver.getWindowHandles();
		Iterator<String> it2=allWindowHandles2.iterator();
		while(it2.hasNext()) {
			String childWindow=it2.next();
			if(!parentWindow2.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.xpath("(//ul[@class='navbar-nav ml-auto']/li)[5]")).click();
				Thread.sleep(3000);
				System.out.println(driver.getWindowHandle());
			}
		}
		driver.switchTo().window(parentWindow2);
		System.out.println(driver.getWindowHandle());
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}


}
