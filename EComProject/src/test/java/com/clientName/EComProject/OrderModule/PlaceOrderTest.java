package com.clientName.EComProject.OrderModule;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.BaseClass;

import com.clientName.EComProject.ObjectRepository.CartPage;
import com.clientName.EComProject.ObjectRepository.HomePage;

public class PlaceOrderTest extends BaseClass
{
	@Test(groups = "smoke")
	public void PlaceOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		String expPopup="Order SuccessFully Placed!!";
		HomePage hp = new HomePage(driver);
		hp.getCart().click();
		Thread.sleep(2000);
		CartPage cp= new CartPage(driver);
		cp.getPlaceOrder().click();
		Alert alert = driver.switchTo().alert();
		String actPopup = alert.getText();
		alert.accept();
		boolean result = actPopup.contains(expPopup);
		assertTrue(result);
	}

}
