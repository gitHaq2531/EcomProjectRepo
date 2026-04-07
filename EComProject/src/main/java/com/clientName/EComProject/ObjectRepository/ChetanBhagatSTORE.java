package com.clientName.EComProject.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChetanBhagatSTORE 
{
	WebDriver driver;
	public ChetanBhagatSTORE(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name = "sort")
	private WebElement sortby;
	

	
}
