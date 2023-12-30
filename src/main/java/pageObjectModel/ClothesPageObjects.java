package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClothesPageObjects {
	
	public WebDriver driver;
	
	public ClothesPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}
	
	private By subcategory=By.className("subcategory-name");
	
	private By categoryMen=By.xpath("(//a[contains(text(),'Men')])[4]");

	public List<WebElement> getSubcategory() {
		return driver.findElements(subcategory);
	}

	public WebElement getCategoryMen() {
		return driver.findElement(categoryMen);
	}
	
	

}
