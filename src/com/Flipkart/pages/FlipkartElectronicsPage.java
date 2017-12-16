package com.Flipkart.pages;

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
		CommonFunction.waitUntilElementVisible(electronicOption,60);
		CommonFunction.hover(electronicOption);
		System.out.println("clicked");
		
		//CommonFunction.click(electronicOption);
		//CommonFunction.javaClick(electronicOption);		
				
		CommonFunction.waitUntilElementIsClickable(mobileOption,30);	
		System.out.println("Option Clickable");
		CommonFunction.click(mobileOption);
		System.out.println("Mobile Option Clicked");
		
	}
	
}
