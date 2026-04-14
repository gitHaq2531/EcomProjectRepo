package com.clientName.EComProject.CartModule;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.BaseClass;

public class ContinueShoppingNavigationTest extends BaseClass
{
	@Test 
	public void NavigateToHomeTest()
	{
		hp.getCart().click();
		WebElement DoSomeShopping = driver.findElement(By.linkText("Do Some Shopping"));
		System.out.println(DoSomeShopping.isDisplayed());
		DoSomeShopping.click();
		WebElement homepage = driver.findElement(By.xpath("//a[contains(text(),'test.')]"));
		assertTrue(homepage.isDisplayed());
		
	}
	

}
