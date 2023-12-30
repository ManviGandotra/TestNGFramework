package pageObjectModel;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
public WebDriver driver;
	
	public HomePageObjects(WebDriver driver2) {
		this.driver=driver2;
	}
	
	private By signInButton=By.xpath("//span[contains(text(), 'Sign in')]");

	private By clothes=By.id("category-3");

	//private By accessories=By.xpath("//span[contains(text(), 'Accessories')]");
	private By accessories=By.id("category-6");
	
	private By art=By.xpath("//a[contains(text(), 'Art')]");
	
	private By signOutButton=By.xpath("//a[@class='logout hidden-sm-down']");
	
	private By productsRow=By.xpath("//article[@class='product-miniature js-product-miniature']");
	
	
	public WebElement getClothes() {
		return driver.findElement(clothes);
	}

	public WebElement getAccessories() {
		return driver.findElement(accessories);
	}

	public WebElement getArt() {
		return driver.findElement(art);
	}

	public WebElement getSignInButton() {
		return driver.findElement(signInButton);
	}

	public WebElement getSignOutButton() {
		return driver.findElement(signOutButton);
	}

	public List<WebElement> getProductsRow() {

		List<WebElement> productsList=driver.findElements(productsRow);
		//int productListSize=productsList.size();
		//java.util.Iterator<E>
		/*
		 * java.util.Iterator<WebElement> it=productsList.iterator();
		 * while(it.hasNext()) { System.out.println(it.next()); it.next(); }
		 */
		//return productsList;
		//System.out.println(productsList.size());
		return productsList;
	}

	
	
}
