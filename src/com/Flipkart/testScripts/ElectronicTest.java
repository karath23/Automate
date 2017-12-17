package com.Flipkart.testScripts;

import org.testng.annotations.Test;
//import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import com.Flipkart.functionLibrary.CommonFunction;
import com.Flipkart.pages.FlipkartElectronicsPage;

import java.io.IOException;

public class ElectronicTest {
	
	/*@BeforeMethod
	public void launchApp() throws IOException
	{
		CommonFunction.openBrowser();
	}*/
	
	@AfterMethod
	public void quitApp() 
	{
		CommonFunction.closeBrowser();
	}

	@Test(priority=2)
	public void selectOption() throws InterruptedException
	{
		FlipkartElectronicsPage p1=PageFactory.initElements(CommonFunction.driver,FlipkartElectronicsPage.class);
	
		p1.SelectElectronics();
		System.out.println("Links will be displayed");
		p1.getLinks();
		System.out.println("Links are getting displayed");
	
	}
	
}
