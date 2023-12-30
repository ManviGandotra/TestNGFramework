package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@Test
public class FirstTestCase {
	static WebDriver driver=new ChromeDriver();
	@BeforeTest
	public void openBrowser() {
		
		driver.get("https://testground.internsified.com/");
	}
	
	@Test(priority = 3)
	public void verifyTitle() {
		String actual=driver.findElement(By.xpath("//img[@class='logo img-fluid']")).getAttribute("alt");
		String expected="Internsified Test Site";
		try {
		Assert.assertEquals(actual, expected);
		System.out.println("Title verified");
		}
		catch(Exception e){
			System.out.println("Title mis-match");
		}
	}
	
    @Test(priority = 8)
	public void verifySearchButton() {
    	WebElement searchButton=driver.findElement(By.xpath("//input[@class='ui-autocomplete-input']"));
    	Boolean searchButtonDisplayed=searchButton.isDisplayed();
    	System.out.println("Search button displayed: "+searchButtonDisplayed);
    	searchButton.sendKeys("women sweater");
    	searchButton.sendKeys(Keys.ENTER);
    	System.out.println("Women sweater searched");
    	
		
	}
    
    @Test(enabled = true, priority = 12,dependsOnMethods = {"verifySearchButton"})
    public void verifyProduct() {
    	WebElement listedProduct=driver.findElement(By.xpath("//a[contains(text(), 'Hummingbird printed sweater')]"));
    	String actual=listedProduct.getText();
    	String expected="Hummingbird Printed Sweater";
    	System.out.println(actual+"*****"+expected);
    	try {
    	Assert.assertEquals(actual, expected);
    	System.out.println("Product verified");
    	}
    	catch(Exception e) {
    	System.out.println("Product name not as expected");	
    	}
    	
    }
    
    @Test(priority =15,dependsOnMethods = {"verifyProduct"})
    public void addProductToCart() throws InterruptedException {
    	WebElement listedProduct=driver.findElement(By.xpath("//a[contains(text(), 'Hummingbird printed sweater')]"));
    	listedProduct.click();
    	WebElement sizeTab=driver.findElement(By.xpath("//select[@id='group_1']"));
    	Select selectSize=new Select(sizeTab);
    	selectSize.selectByVisibleText("M");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
		/*
		 * if(isAlertPresent()) { System.out.println("Alert present"); }
		 */
    	Thread.sleep(3000);
    	WebElement proceedToCheckoutButton=driver.findElement(By.xpath("//a[contains(text(), 'Proceed to checkout')]"));
    	proceedToCheckoutButton.click();
    
    	
    }
    
    public static boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }catch(NoAlertPresentException ex){
            return false;
        }
  }

}
