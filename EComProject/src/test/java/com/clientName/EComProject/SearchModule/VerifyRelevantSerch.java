package com.clientName.EComProject.SearchModule;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.BaseClass;

public class VerifyRelevantSerch extends BaseClass{
	@Test(groups = "smoke")
	public void onSearchReturnRelevantBook() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String Book = efu.getDataFromExcelFile("Search_module", 1, 0);
		hp.getSearchBar().sendKeys(Book,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> result = driver.findElements(By.xpath("//div[@class='book-block']"));
		for(WebElement i:result)
		{
			System.out.println(i.getText());
			boolean relevantBook = i.getText().contains(Book);
			Assert.assertEquals(true, relevantBook);
		}
		
	}
	

}

