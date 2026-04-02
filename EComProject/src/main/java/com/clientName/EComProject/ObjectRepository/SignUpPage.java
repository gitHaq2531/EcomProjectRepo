package com.clientName.EComProject.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage 
{
	WebDriver driver;
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(name = "register_username")
	private WebElement register_username;
	
	@FindBy(name = "register_password")
	private WebElement register_password;
	
	@FindBy(xpath = "//button[@name='submit' and @value='register']")
	private WebElement signup;

	public WebElement getRegister_username() {
		return register_username;
	}

	public WebElement getRegister_password() {
		return register_password;
	}

	public WebElement getSignup() {
		return signup;
	}
	
	

}
