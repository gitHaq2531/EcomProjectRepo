package DemoTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.clientName.EComProject.BaseClass.MasterBaseClass;
import com.clientName.EComProject.ObjectRepository.LogInPage;
import com.clientName.EComProject.ObjectRepository.SignUpPage;
import com.clientName.EComProject.genericUtilities.JavaUtility;
import com.clientName.EComProject.genericUtilities.WebDriverUtiity;



public class SignUp extends MasterBaseClass
{
	@Test(groups = "smoke")
	public void signUpTest() throws IOException, InterruptedException
	{
		
		JavaUtility ju= new JavaUtility();
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
		WebDriverUtiity wu = new WebDriverUtiity();
		wu.waitForAlertToPresent(driver);
		Alert alrt = driver.switchTo().alert();
		String ActualPopUp=alrt.getText();
		alrt.accept();
		
		boolean alrtResult = ActualPopUp.contains(ExpectedPopUp);
		assertTrue(alrtResult);

	}


}
