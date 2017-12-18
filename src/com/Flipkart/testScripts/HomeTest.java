package com.Flipkart.testScripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Flipkart.functionLibrary.CommonFunction;
import com.Flipkart.pages.FlipkartHomePage;


public class HomeTest {

	@BeforeMethod
	public void launchApp() throws IOException
	{
	  CommonFunction.openBrowser();
	}
	 
	@Test(dataProvider="getData",priority=1)
	public void successfulLogin(String username,String pwd) throws InterruptedException
	{      
		
		//System.out.println("trying to login");
		FlipkartHomePage p1=PageFactory.initElements(CommonFunction.driver,FlipkartHomePage.class);
		p1.login(username,pwd);
		System.out.println("Logged In Successfully");
	}
	
	@DataProvider(name="getData")
	public Object[][] getData() throws IOException
	{   
		int row=CommonFunction.totalNoOfRows("sheet1");
		int col=CommonFunction.totalNoOfCol("sheet1");
	
		Object getData[][]=new Object[row][col];
		
		getData=CommonFunction.readExcel("sheet1");
		return getData;
	}

}