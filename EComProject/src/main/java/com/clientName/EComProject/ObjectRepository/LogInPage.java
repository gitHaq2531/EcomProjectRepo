package com.clientName.EComProject.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clientName.EComProject.genericUtilities.WebDriverUtiity;

public class LogInPage 
{
	WebDriver driver;
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}
	@FindBy(id = "login_button")
	private WebElement loginBtn;
	
	@FindBy(name = "login_username")
	private WebElement username;
	
	@FindBy(name = "login_password")
	private WebElement password;
	
	@FindBy(name = "submit")
	private WebElement singin;
	
	@FindBy(className = "btn.btn-default")
	private WebElement close;
	
	public void LoginToApp(String url,String uname,String pass) throws InterruptedException
	{
		WebDriverUtiity wu=new WebDriverUtiity();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(url);
		wu.waitForPageLoad(driver);
		loginBtn.click();
		username.sendKeys(uname);
		password.sendKeys(pass);
		singin.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
	}
	
}
