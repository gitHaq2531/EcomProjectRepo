package com.clientName.EComProject.UserModule;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.MasterBaseClass;
import com.clientName.EComProject.ObjectRepository.HomePage;
import com.clientName.EComProject.ObjectRepository.LogInPage;
import com.clientName.EComProject.ObjectRepository.SignUpPage;

public class LoginTest extends MasterBaseClass{
	@Test(groups = "smoke")
	public void signUpTest() throws IOException, InterruptedException
	{
		int runm = ju.getRandomNum();
		String URL=pfu.getDataFromPropertyFile("url");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		LogInPage lp= new LogInPage(driver);	
		lp.getSignUp().click();
		
		String ExpectedPopUp="Successfully Registered!!!";
		
		SignUpPage sp=new SignUpPage(driver);
		sp.getRegister_username().sendKeys("test21"+runm);
		sp.getRegister_password().sendKeys("test21");
		sp.getSignup().click();
		
		wu.waitForAlertToPresent(driver);
		Alert alrt = driver.switchTo().alert();
		String ActualPopUp=alrt.getText();
		alrt.accept();
		
		boolean alrtResult = ActualPopUp.contains(ExpectedPopUp);
		assertTrue(alrtResult);

	}
	
	
	@Test(groups = "smoke")
	public void UserLoginWithValidCred() throws InterruptedException, IOException
	{
		String URL=pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		
		LogInPage lp= new LogInPage(driver);	
		lp.LoginToApp(URL, USERNAME, PASSWORD);	

		HomePage hp=new HomePage(driver);
		String actualusername=hp.getHello().getText();	
		boolean res = actualusername.contains(USERNAME);
		assertTrue(res);
		hp.logOut();

		
	}
	@Test(groups ="smoke")
	public void UserLogOut() throws InterruptedException, IOException
	{
		String URL=pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		
		LogInPage lp= new LogInPage(driver);	
		lp.LoginToApp(URL, USERNAME, PASSWORD);	

		HomePage hp=new HomePage(driver);
		hp.logOut();
		boolean button = lp.getLoginBtn().isDisplayed();
		assertTrue(button);
	}
	
	
	
}
