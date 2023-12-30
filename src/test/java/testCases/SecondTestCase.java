package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestCase {
	
	WebDriver driver=new ChromeDriver();
	@BeforeTest
	public void openBrowser() {
		
		driver.get("https://testground.internsified.com/");
	}
	
	@Test(priority = 1)
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
	
	@Test(priority =3)
	public void openHomeAccessories() throws InterruptedException {
		WebElement accessoriesButton=driver.findElement(By.xpath("//li[@id='category-6']//a[@class='dropdown-item']"));
		Actions a =new Actions(driver);
		a.moveToElement(accessoriesButton).build().perform();
		Thread.sleep(2000);
		WebElement homeAccessoriesButton=driver.findElement(By.xpath("//a[contains(text(),'Home Accessories')]"));
		homeAccessoriesButton.click();
	}
	
	@Test(priority = 6)
	public void verifyHomeAccessoriesTitle() {
		String actual=driver.findElement(By.xpath("//h1[normalize-space()='Home Accessories']")).getText();
		String expected="HOME ACCESSORIES";
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("HOME ACCESSORIES title verified");
		}
	}
	
	@Test(priority = 9)
	public void addProductToCart() throws InterruptedException {
		WebElement product=driver.findElement(By.xpath("//a[contains(text(),'Hummingbird cushion')]"));
		Actions a =new Actions(driver);
		a.scrollToElement(product).build().perform();
		product.click();
		Thread.sleep(3000);
		WebElement color=driver.findElement(By.xpath("//input[@title='White']"));
		color.click();
		WebElement addToCartButton=driver.findElement(By.xpath("//button[@type='submit']"));
		addToCartButton.click();
		Thread.sleep(3000);
		WebElement proceedToCheckoutButton=driver.findElement(By.xpath("//a[contains(text(), 'Proceed to checkout')]"));
    	proceedToCheckoutButton.click();
		
		
		
	}

}
