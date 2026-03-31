package com.clientName.EComProject.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name = "keyword")
	private WebElement searchBar;
	
	@FindBy(partialLinkText = "Entrance Exam")
	private WebElement  Entrance_examLink;
	
	@FindBy(partialLinkText = "Literature")
	private WebElement LiteratureFictionLink;
	
	@FindBy(partialLinkText = "Academic & Professional")
	private WebElement  AcademicProfessionalLink;
	
	@FindBy(partialLinkText = "Biographies & Auto Biographies")
	private WebElement  Biographies; 
	
	@FindBy(partialLinkText = "Children & Teens")
	private WebElement  ChildrenTeens;
	
	@FindBy(partialLinkText = "LogOut")
	private WebElement logout;
	
	public void logOut()
	{
		logout.click();
		driver.switchTo().alert().accept();
	}
	
	
	public WebElement getAcademicProfessionalLink() {
		return AcademicProfessionalLink;
	}


	public WebElement getBiographies() {
		return Biographies;
	}


	public WebElement getChildrenTeens() {
		return ChildrenTeens;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getEntrance_examLink() {
		return Entrance_examLink;
	}

	public WebElement getLiteratureFictionLink() {
		return LiteratureFictionLink;
	}
	
	
	

}
