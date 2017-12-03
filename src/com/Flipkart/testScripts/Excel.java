package com.Flipkart.testScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Flipkart.utilities.FilePaths;

public class Excel {
	
	
	public static int totalNoOfRows(String sheetName) throws IOException
	{	  
    	
    	System.out.println("counting rows");    
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

	
	public String[][] readExcel(String sheetName) throws IOException
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
						cellData[i][j]=c.getStringCellValue();		
						System.out.print(cellData[i][j]);
					}
				}
				System.out.println("");
			}

		return cellData;
	}
	
	@Test
	public void mai() throws IOException
	{
		String[][] out=readExcel("sheet1");
		System.out.println(out);
		
	}
}