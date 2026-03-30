package com.clientName.EComProject.Login;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clientName.EComProject.genericUtilities.PropertiesFileUtility;

public class SearchBookTest 
{
	@Test 
	public void verifyUserCanSearchBookAndViewResults() throws IOException, InterruptedException
	{
		PropertiesFileUtility pfu= new PropertiesFileUtility();
		String BROWSER=pfu.getDataFromPropertyFile("browser");
		String URL=pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		WebDriver driver =null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("login_button")).click();
		driver.findElement(By.name("login_username")).sendKeys(USERNAME);
		driver.findElement(By.name("login_password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String ExpectedAlt="successfully logged in!!!" ;
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		Assert.assertEquals(ExpectedAlt, text);
		driver.findElement(By.name("keyword")).sendKeys("like a love song",Keys.ENTER);
		String title = driver.findElement(By.xpath("//h4[contains(text(),'records')]")).getText();
		System.out.println(title);
		List<WebElement> releventBook = driver.findElements(By.xpath("//div[@class='book-block']"));
		for(WebElement i:releventBook)
		{
			System.out.println(i.getText());
		}
		

	}
		
		
		
		
}


