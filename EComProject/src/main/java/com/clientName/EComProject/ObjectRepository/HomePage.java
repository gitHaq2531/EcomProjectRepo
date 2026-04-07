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
	
	@FindBy(xpath = "//a[@href=\"Author.php?value=Chetan%20Bhagat\"]")
	private WebElement ChetanBhagat;
	
	
	@FindBy(partialLinkText = "LogOut")
	private WebElement logout;
	
	@FindBy(xpath = "//li//a[@href='#']")
	private WebElement hello;
	
	@FindBy(partialLinkText = "Cart")
	private WebElement cart;
	
	
	
	
	public WebElement getLogout() {
		return logout;
	}


	public WebElement getChetanBhagat() {
		return ChetanBhagat;
	}


	public WebElement getCart() {
		return cart;
	}


	public WebElement getHello() {
		return hello;
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
	
	public void logOut() throws InterruptedException
	{
		//driver.navigate().refresh();
		//driver.switchTo().alert().accept();
		logout.click();
		driver.switchTo().alert().accept();
	}
	
	
	

}
