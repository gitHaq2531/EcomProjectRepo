package com.clientName.EComProject.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(xpath = "//div[@id='heading']//h2")
	private WebElement yourCartHeading;
	
	@FindBy(linkText = "Place Order")
	private WebElement placeOrder;
	
	@FindBy(xpath = "//div[@class='container']//div[@class='panel-heading']")
	private WebElement total;
	
	
	public WebElement getTotal() {
		return total;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public WebElement getYourCartHeading() {
		return yourCartHeading;
	}
	
	
	

}
