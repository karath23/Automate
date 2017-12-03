package com.Flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Flipkart.functionLibrary.CommonFunction;

public class FlipkartHomePage {
  
	// //a[@class='_2k0gmP'][@data-reactid='29']
	////*[@id='container']/div/header/div[1]/div[1]/div/ul/li[9]/a

	@FindBy(xpath="//a[@class='_2k0gmP'][contains(text(),'Log In')]")
	public  WebElement logIn;
	
	//input[@class='_2zrpKA'][@type='text']    
	@FindBy(xpath="//input[@class='_2zrpKA'][@type='text']")
	public  WebElement EmailNo;
	
	////input[@class='_2zrpKA _3v41xv'][@type='password'] 
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv'][@type='password']")
	public  WebElement password;
	
	////button[@class='_2AkmmA _1LctnI _7UHT_c'][@type='submit'] 
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c'][@type='submit']")
	public  WebElement logSubmit;
	
	// //a[@class='_1QZ6fC'][@title='Women'] 
	@FindBy(xpath="//span[contains(text(),'Women')]")
	public  WebElement Women;
	
	@FindBy(xpath="//a[@class='_1AHrFc _2k0gmP'][contains(text(),'My Account')]")
	public WebElement MyAccount;

	public void login(String email,String pwd) throws InterruptedException
	{	
		
		//CommonFunction.click(logIn);		
		CommonFunction.type(EmailNo,email);		
		CommonFunction.type(password,pwd);		
		CommonFunction.click(logSubmit);
		System.out.println("submitted");
		CommonFunction.waitUntilElementVisible(MyAccount,40);
		System.out.println("visible");
		CommonFunction.hover(MyAccount);
		//CommonFunction.hover(Women);
		//System.out.println("Women Selected");
	}
		
}
