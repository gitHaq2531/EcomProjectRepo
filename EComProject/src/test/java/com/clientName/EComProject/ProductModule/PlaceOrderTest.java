package com.clientName.EComProject.ProductModule;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.BaseClass;
import com.clientName.EComProject.ObjectRepository.CartPage;
import com.clientName.EComProject.ObjectRepository.HomePage;

public class PlaceOrderTest extends BaseClass
{
	@Test(groups = "smoke")
	public void PlaceOver()
	{
		String expPopup="Order SuccessFully Placed!!";
		HomePage hp = new HomePage(driver);
		hp.getCart().click();
		
		CartPage cp= new CartPage(driver);
		cp.getPlaceOrder().click();
		Alert alert = driver.switchTo().alert();
		String actPopup = alert.getText();
		alert.accept();
		boolean result = actPopup.contains(expPopup);
		assertTrue(result);
	}

}
