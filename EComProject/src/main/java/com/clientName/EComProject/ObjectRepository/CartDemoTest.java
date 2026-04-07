package com.clientName.EComProject.ObjectRepository;

import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.BaseClass;

public class CartDemoTest extends BaseClass
{
	@Test()
	public void verifyTheTotal()
	{
		HomePage hp = new HomePage(driver);
		hp.getCart().click();
		CartPage cp = new CartPage(driver);
		System.out.println(cp.getTotal().isDisplayed());
	}
}
