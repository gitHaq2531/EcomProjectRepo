package com.clientName.EComeProject.ListenerUtility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ListenersImp implements ITestListener,ISuiteListener
{
	ExtentSparkReporter spark;
	public static ExtentReports report;
	public void onStart(ISuite suite) 
	{
		//report config
		System.out.println("Report Configuration");
		spark=new ExtentSparkReporter("./AdvanceReport/report1.html");
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
		
	}
	
	public void onTestStart(ITestResult result)
	{
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		
	}

}
