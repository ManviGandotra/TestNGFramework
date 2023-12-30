package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class HandlingWebElementList {
	
	@BeforeTest
	public void invokeBrowser() throws IOException {
		BaseClass b=new BaseClass();
		b.driverInitialize();
	}
	
	@Test
	public void getProductList() {
		
		
	}

}
