package com.clientName.EComProject.genericUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtiity {

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitForElementToPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToWindowByUrl(WebDriver driver,String partialURL)
	{
		Set<String> windowID = driver.getWindowHandles();
		for (String id:windowID)
		{
			driver.switchTo().window(id);
			String url = driver.getCurrentUrl();
			if(url.contains(partialURL))
			{
				break;
			}
			
		}
	}
	public void switchToWindowByTitle(WebDriver driver,String partialTitle)
	{
		Set<String> windowID = driver.getWindowHandles();
		for (String id:windowID)
		{
			driver.switchTo().window(id);
			String url = driver.getTitle();
			if(url.contains(partialTitle))
			{
				break;
			}
			
		}
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void selectByIndex(WebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);	
	}
	public void selectByVisibleText(WebElement ele,String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	
}
