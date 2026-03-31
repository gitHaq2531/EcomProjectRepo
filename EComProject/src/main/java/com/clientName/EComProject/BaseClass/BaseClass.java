package com.clientName.EComProject.BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.clientName.EComProject.ObjectRepository.HomePage;
import com.clientName.EComProject.ObjectRepository.LogInPage;
import com.clientName.EComProject.genericUtilities.PropertiesFileUtility;


public class BaseClass 
{
	public WebDriver driver=null;
	public static WebDriver sdriver;
	PropertiesFileUtility pfu=new PropertiesFileUtility();
	
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
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException
	{
		LogInPage lp= new LogInPage(driver);
		System.out.println("Login to application");
		String URL=pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		lp.LoginToApp(URL, USERNAME, PASSWORD);	
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		
		System.out.println("Logout form application");
		HomePage hp=new HomePage(driver);
		hp.logOut();	
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
