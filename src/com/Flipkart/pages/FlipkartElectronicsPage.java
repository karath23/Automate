package com.Flipkart.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Flipkart.functionLibrary.CommonFunction;

public class FlipkartElectronicsPage {

	
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	public WebElement electronicOption;
	
	@FindBy(xpath="//a[@title='Mobiles']")
	public WebElement mobileOption;
	
		
	public void SelectElectronics() throws InterruptedException
	{   		
		CommonFunction.waitUntilElementIsClickable(electronicOption,100);
		CommonFunction.hover(electronicOption);
		System.out.println("clicked");	
		CommonFunction.waitUntilElementIsClickable(mobileOption,30);	
		System.out.println("Option Clickable");
		CommonFunction.click(mobileOption);
		System.out.println("Mobile Option Clicked");
		
	}
	
	public void getLinks() 
	{
	
		List<WebElement> links=CommonFunction.driver.findElements(By.tagName("a"));
		
		System.out.println("No of Links are "+links.size());
		
		for(WebElement ele : links)
		{		
			//print the links i.e. http://example.com or https://www.example.com
			//System.out.println(ele.getAttribute("href"));
			 
			//print the links text
			System.out.println(ele.getText());
			
		}
		
		
		
	}
	
}
