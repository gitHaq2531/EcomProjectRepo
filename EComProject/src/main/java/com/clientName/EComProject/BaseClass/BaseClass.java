package com.clientName.EComProject.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import com.clientName.EComProject.ObjectRepository.HomePage;
import com.clientName.EComProject.ObjectRepository.LogInPage;
import com.clientName.EComProject.genericUtilities.ExcelFileUtility;
import com.clientName.EComProject.genericUtilities.PropertiesFileUtility;
import com.clientName.EComProject.genericUtilities.ThreadSafeUtility;
import com.clientName.EComProject.genericUtilities.WebDriverUtiity;


public class BaseClass 
{
	public WebDriver driver=null;
	public static WebDriver sdriver;
	protected PropertiesFileUtility pfu=new PropertiesFileUtility();
	protected ExcelFileUtility efu=new ExcelFileUtility();
	protected WebDriverUtiity wu = new WebDriverUtiity();

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		System.out.println("DB Connection");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass(XmlTest test) throws IOException
	{
		System.out.println("Launching the browser");

		String BROWSER=System.getProperty("browser");
		if(BROWSER==null)
		{
			BROWSER=test.getParameter("browser");
			if(BROWSER==null)
			{
				BROWSER=pfu.getDataFromPropertyFile("browser");
			}
		}
		ThreadSafeUtility.setBrowser(BROWSER);

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			sdriver=driver;
		}else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			sdriver=driver;
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			sdriver=driver;
		}
		ThreadSafeUtility.setDriver(driver);
		driver=ThreadSafeUtility.getDriver();
		//driver.get(futils.getDataFromPropertiesFile("url"));	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws IOException, InterruptedException
	{
		LogInPage lp= new LogInPage(ThreadSafeUtility.getDriver());
		System.out.println("Login to application");
		String URL=pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		lp.LoginToApp(URL, USERNAME, PASSWORD);	
	}

	@AfterMethod(alwaysRun = true)
	public void AfterMethod() throws InterruptedException
	{
		WebDriver driver = ThreadSafeUtility.getDriver();
		HomePage hp = new HomePage(driver);
		hp.logOut();
		System.out.println("Logout from application");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		System.out.println("clossing the browser");
		try {
			if(driver!=null) {
				driver.quit();
			}
		}
		finally
		{
			ThreadSafeUtility.removeDriver();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite()
	{
		System.out.println("clossing the DB connection");
	}
}
