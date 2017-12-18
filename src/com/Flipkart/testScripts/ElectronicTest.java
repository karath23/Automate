package com.Flipkart.testScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.Flipkart.functionLibrary.CommonFunction;
import com.Flipkart.pages.FlipkartElectronicsPage;


public class ElectronicTest {
	
	@Test(priority=2)
	public void selectOption() throws InterruptedException
	{
		FlipkartElectronicsPage p1=PageFactory.initElements(CommonFunction.driver,FlipkartElectronicsPage.class);
		p1.SelectElectronics();
		//System.out.println("Links will be displayed");
		//p1.getLinks();
	//	System.out.println("Links are getting displayed");
	}
	
}
