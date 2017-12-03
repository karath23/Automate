package com.Flipkart.utilities;

import java.io.File;

public class FilePaths {

	public static final File configPath= new File("src/com/Flipkart/testData/config.properties").getAbsoluteFile();
	public static final File testInputPath=new File("src/com/Flipkart/testData/TestInput.xlsx").getAbsoluteFile();
	public static final String chromedriver=new File("src/com/Flipkart/resources/chromedriver.exe").getAbsolutePath();
	public static final String iedriver=new File("src/com/Flipkart/resources/iedriver.exe").getAbsolutePath();
	public static final String geckodriver=new File("src/com/Flipkart/resources/geckoriver.exe").getAbsolutePath();
	
}
