package com.clientName.EComProject.Login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clientName.EComProject.ObjectRepository.HomePage;
import com.clientName.EComProject.ObjectRepository.LogInPage;
import com.clientName.EComProject.genericUtilities.PropertiesFileUtility;

public class LoginDemoTest 
{
	@Test
	public void loginToAppTest() throws IOException, InterruptedException
	{
		PropertiesFileUtility pfu=new PropertiesFileUtility();
		String BROWSER = pfu.getDataFromPropertyFile("browser");
		String URL = pfu.getDataFromPropertyFile("url");
		String USERNAME = pfu.getDataFromPropertyFile("username");
		String PASSWORD = pfu.getDataFromPropertyFile("password");
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		LogInPage lp = new LogInPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
		Thread.sleep(3000);
		
		Alert alt = driver.switchTo().alert();
		String ExpectedAlt="successfully logged in!!!" ;
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		
		Assert.assertEquals(ExpectedAlt, text);
		
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);

		hp.getEntrance_examLink().click();
		

	}

}
