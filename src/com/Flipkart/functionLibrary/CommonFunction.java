package com.Flipkart.functionLibrary;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.Flipkart.utilities.FilePaths;
//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class CommonFunction {

	public static WebDriver driver;
	 public static boolean alertExists;
	
public static String propertyValue(String propertyname) throws IOException
{
	FileInputStream fs=new FileInputStream(FilePaths.configPath); 
	Properties prop=new Properties();
	prop.load(fs);
	return prop.getProperty(propertyname);
}

public static void openBrowser() throws IOException
{
	String url=propertyValue("url");
	String browser=propertyValue("browser");
	
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",FilePaths.chromedriver);
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	else if(browser.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver","FilePaths.iedriver");
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	else if(browser.equalsIgnoreCase("firefox"))
	{	
		System.setProperty("webdriver.ie.driver","FilePaths.geckodriver");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
	}
	else
	{
     System.out.println("The browser name enetered in Config file is not appropriate");		
	}
	
}
public static void closeBrowser()
{
	driver.close();
	driver.quit();
}



public static void type(WebElement element,String value)
{
	element.sendKeys(value);
}


public static void clear(WebElement element)
{
	element.clear();
}

public static void click(WebElement element)
{
	element.click();
}

public static void hover(WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
	
}

public static void alertDismiss()
{
	Alert popup=driver.switchTo().alert();
	popup.dismiss();
}
public static void alertAccept()
{
	Alert popup=driver.switchTo().alert();
	popup.accept();
}
public static boolean isAlertPresent(int seconds)
{
	WebDriverWait wait=new WebDriverWait(driver,seconds);
	wait.until(ExpectedConditions.alertIsPresent());
	 return true;
}
public static void implicitWait(int seconds)
{
	driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
}

public static void waitUntilElementVisible(WebElement element,int seconds)
{
	WebDriverWait wait=new WebDriverWait(driver,seconds);
	wait.until(ExpectedConditions.visibilityOf(element));
}

public static void waitUntilElementIsClickable(WebElement element,int seconds)
{
	WebDriverWait wait=new WebDriverWait(driver,seconds);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}


public static void javaClick(WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("element.click()");
}

/*public static void waitClick(String path)
{
By by = By.xpath(path);

WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement el = wait.until(presenceOfElementLocated(by));
}*/



public static int totalNoOfRows(String sheetName) throws IOException
{	
		FileInputStream fis=new FileInputStream(FilePaths.testInputPath);
		XSSFWorkbook w=new XSSFWorkbook(fis);
		XSSFSheet s=w.getSheet(sheetName);
		return s.getLastRowNum()+1;
}

public static int totalNoOfCol(String sheetName) throws IOException
{	
		FileInputStream fis=new FileInputStream(FilePaths.testInputPath);
		XSSFWorkbook w=new XSSFWorkbook(fis);
		XSSFSheet s=w.getSheet(sheetName);
		XSSFRow r=s.getRow(0);
		return r.getLastCellNum();
}


public static String[][] readExcel(String sheetName) throws IOException
{
		int row=totalNoOfRows("sheet1");
		int col=totalNoOfCol("sheet1");
	
		FileInputStream fis=new FileInputStream(FilePaths.testInputPath);
		XSSFWorkbook w=new XSSFWorkbook(fis);
		XSSFSheet s=w.getSheet(sheetName);
		String[][] cellData=new String[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<=col;j++)
			{
				XSSFRow r=s.getRow(i);
				XSSFCell c=r.getCell(j);
				if(c!=null)
				{ 
					cellData[i][j]=c.getStringCellValue();				}
			}
		}

	return cellData;
}
}
