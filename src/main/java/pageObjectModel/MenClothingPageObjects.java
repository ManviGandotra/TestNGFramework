package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenClothingPageObjects {
	
public WebDriver driver;
	
	public MenClothingPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}
	
	

	//private By title=By.xpath("//h1[contains(text(),'Men')]");
	private By title=By.xpath("//*[@id=\"js-product-list-header\"]/div/h1");
	
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}

}
