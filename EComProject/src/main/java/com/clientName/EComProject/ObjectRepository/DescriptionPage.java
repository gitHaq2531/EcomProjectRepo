package com.clientName.EComProject.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage 
{
	WebDriver driver;
	public DescriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(id = "buyLink")
	private WebElement addToCart;
	
	@FindBy(id = "quantity")
	private WebElement quantity;

	public CartPage clickAddToCart() {
		addToCart.click();
		return new CartPage(driver);
	}


	public WebElement getQuantity() {
		return quantity;
	}
	
	
	
	
	

}
