package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	public LoginPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}
	
	private By email=By.id("field-email");
	
	private By password=By.id("field-password");
	
	private By submitButton=By.id("submit-login");
	
	private By authenticationFailed=By.xpath("//li[contains(text(),'Authentication failed.')]");
	
	

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getSubmitButton() {
		return driver.findElement(submitButton);
	}

	public WebElement getAuthenticationFailed() {
		return driver.findElement(authenticationFailed);
	}



}
