package com.Flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Flipkart.functionLibrary.CommonFunction;

public class FlipkartOrderPage {

	@FindBy(xpath="(//div[@class='_8Vcv_L'])[1]")
	public WebElement firstOption;
	
	//@FindBy(xpath="(//div[@class='_3BTv9X'])[1]")
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK RpigiU']") 
	public WebElement buy;
	
	@FindBy(xpath="//button[@class='_2AkmmA _14O7kc _7UHT_c']")
	public WebElement placeOrder;
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Q4i61 _7UHT_c']")
	public WebElement cont;
	
	public void orderPlacement() throws Exception
	{
		System.out.println("in oder fn");
		CommonFunction.waitUntilElementIsClickable(firstOption,60);
		CommonFunction.click(firstOption);
		System.out.println("first option selected");
		
		CommonFunction.waitUntilElementIsClickable(buy,60);
		//CommonFunction.scrollToElement(buy);
		CommonFunction.click(buy);
		
		CommonFunction.waitUntilElementIsClickable(placeOrder,60);
		CommonFunction.scrollAndClickElement(placeOrder);
	
		CommonFunction.waitUntilElementIsClickable(cont,60);
		CommonFunction.scrollAndClickElement(cont);
		CommonFunction.navigateHome();
		
	}
	
}
