package com.clientName.EComProject.CartModule;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.BaseClass;
import com.clientName.EComProject.ObjectRepository.*;

public class CartTest extends BaseClass
{
	@Test(groups = "smoke")
	public void CartPageNavigateTest()
	{
		HomePage hp=new HomePage(driver);
		hp.getCart().click();
		
		CartPage cp=new CartPage(driver);
		String heading = cp.getYourCartHeading().getText();
		//System.out.println(heading);
		String expectedHeading="YOUR CART";
		boolean res = heading.contains(expectedHeading);
		assertTrue(res);	
	}
	
	
	@Test()
	public void searchAndAddToCartTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		String Book = efu.getDataFromExcelFile("Search_module", 1, 0);
		hp.getSearchBar().sendKeys(Book,Keys.ENTER);
		List<WebElement> result = driver.findElements(By.xpath("//div[@class='book-block']"));
		for(WebElement i:result)
		{
			String relevantBook = i.getText();
			if(relevantBook.contains(Book))
			{
				i.click();
			}
			break;
		}
		Thread.sleep(2000);
		DescriptionPage dp=new DescriptionPage(driver);
		dp.getAddToCart().click();
		
		CartPage cp=new CartPage(driver);
		String heading = cp.getYourCartHeading().getText();
		//System.out.println(heading);
		String expectedHeading="YOUR CART";
		boolean res = heading.contains(expectedHeading);
		assertTrue(res);
	}
	
}
