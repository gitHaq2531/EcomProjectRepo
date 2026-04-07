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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.clientName.EComProject.genericUtilities.ThreadSafeUtility;
public class ListenersImp implements ITestListener,ISuiteListener
{
	ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) 
	{   //report config
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println("Report Configuration");
		spark=new ExtentSparkReporter("./AdvanceReport/EComeReport_" + time + ".html");
		spark.config().setDocumentTitle("online book store");
		spark.config().setReportName("ECom Report");
		spark.config().setTheme(Theme.DARK);
		
		//SystemConfig
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-11");
	}
	
	public void onFinish(ISuite suite) 
	{
		System.out.println("report backup");
		report.flush();
	}
	
	public void onTestStart(ITestResult result)
	{
		report.setSystemInfo("browser", ThreadSafeUtility.getBrowser());
		ThreadSafeUtility.setTest(report.createTest(result.getName()));
		ThreadSafeUtility.getTest().log(Status.INFO, result.getName()+" execution starts");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		ThreadSafeUtility.getTest().log(Status.PASS, result.getName()+" execution successfull");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		ThreadSafeUtility.getTest().log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot)ThreadSafeUtility.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		ThreadSafeUtility.getTest().addScreenCaptureFromBase64String(filepath, result.getName()+"_"+time);		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		ThreadSafeUtility.getTest().log(Status.SKIP, result.getName()+" got skipped"+ result.getThrowable());
	}

}
