package com.Flipkart.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.Flipkart.functionLibrary.CommonFunction;
import com.Flipkart.pages.FlipkartOrderPage;

public class OrderTest {

	@AfterMethod
	public void quitApp() 
	{
		CommonFunction.closeBrowser();
	}

	@Test(priority=3)
	public void placeOrder() throws Exception
	{
		FlipkartOrderPage p1=PageFactory.initElements(CommonFunction.driver,FlipkartOrderPage.class);
		p1.orderPlacement();
		
	}
	
}
