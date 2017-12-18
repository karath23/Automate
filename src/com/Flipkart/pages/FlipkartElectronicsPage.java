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
	
	@FindBy(xpath="//a[@title='Samsung']")
	public WebElement samsung;
	
		
	public void SelectElectronics() throws InterruptedException
	{   		
		System.out.println("In Electronic fn");
		Thread.sleep(5000);
		CommonFunction.waitUntilElementIsClickable(electronicOption,100);
		CommonFunction.hover(electronicOption);
		System.out.println("Electronic Option Selected");
		CommonFunction.waitUntilElementIsClickable(samsung,30);	
		CommonFunction.click(samsung);
		System.out.println("Samsung Option Clicked");
		Thread.sleep(5000);
	}
	
	public void getLinks() 
	{
	
		List<WebElement> links=CommonFunction.driver.findElements(By.tagName("a"));
		
		System.out.println("No of Links are "+links.size());
			
		/*for(int i=1;i<=links.size();i++)
		{		
			System.out.println(i+". "+links.get(i).getText());
		}*/
		
		for (WebElement myElement : links)
		 {
	         String link = myElement.getAttribute("title"); 
	        System.out.println(link);; 
		 }
	}
	
}
