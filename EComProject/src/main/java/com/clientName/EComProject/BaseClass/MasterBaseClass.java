package com.clientName.EComProject.BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.clientName.EComProject.genericUtilities.ExcelFileUtility;
import com.clientName.EComProject.genericUtilities.JavaUtility;
import com.clientName.EComProject.genericUtilities.PropertiesFileUtility;
import com.clientName.EComProject.genericUtilities.WebDriverUtiity;

public class MasterBaseClass 
{
	public WebDriver driver=null;
	public static WebDriver sdriver;
	protected PropertiesFileUtility pfu=new PropertiesFileUtility();
	protected ExcelFileUtility efu=new ExcelFileUtility();
	protected JavaUtility ju= new JavaUtility();
	protected WebDriverUtiity wu = new WebDriverUtiity();
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("DB Connection");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Launching the browser");
		String BROWSER=pfu.getDataFromPropertyFile("browser");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			sdriver=driver;
		}
		
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("clossing the browser");
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("clossing the DB connection");
	}
	
	

}