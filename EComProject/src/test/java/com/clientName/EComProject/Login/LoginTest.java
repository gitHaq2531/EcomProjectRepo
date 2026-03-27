package com.clientName.EComProject.Login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clientName.EComProject.genericUtilities.PropertiesFileUtility;

public class LoginTest 
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
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("login_button")).click();
		driver.findElement(By.name("login_username")).sendKeys(USERNAME);
		driver.findElement(By.name("login_password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		Alert alt = driver.switchTo().alert();
		String ExpectedAlt="successfully logged in!!!" ;
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		
		Assert.assertEquals(ExpectedAlt, text);

	}

}
