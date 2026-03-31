package com.clientName.EComProject.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.clientName.EComProject.BaseClass.BaseClass;
public class ListenersImp implements ITestListener,ISuiteListener
{
	ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	public void onStart(ISuite suite) 
	{   //report config
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println("Report Configuration");
		spark=new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("online book store");
		spark.config().setReportName("ECom Report");
		spark.config().setTheme(Theme.DARK);
		
		//SystemConfig
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome");	
	}
	
	public void onFinish(ISuite suite) 
	{
		System.out.println("report backup");
		report.flush();
	}
	
	public void onTestStart(ITestResult result)
	{
		String testName=result.getMethod().getMethodName();
		System.out.println("============"+testName+"========STARTED===========");
		test=report.createTest(testName);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		String testName=result.getMethod().getMethodName();
		test.pass(testName);
		System.out.println("============"+testName+"========ENDED===========");
		
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		String testName=result.getMethod().getMethodName();
		System.out.println("============"+testName+"========FAILED===========");
		test.fail(result.getThrowable());
		TakesScreenshot tk= (TakesScreenshot)BaseClass.sdriver;
		String filePath = tk.getScreenshotAs(OutputType.BASE64);
		
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		
	}

}
