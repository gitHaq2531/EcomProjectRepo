package com.clientName.EComProject.genericUtilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafeUtility 
{
public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
public static ThreadLocal<String> browser = new ThreadLocal<String>();

public static void setDriver(WebDriver baseDriver){
	driver.set(baseDriver);
}
public static WebDriver getDriver(){
	return driver.get();
}
public static void removeDriver(){
	driver.remove();
}

public static void setTest(ExtentTest extentTest) {
	test.set(extentTest);
}
public static ExtentTest getTest() {
	return test.get();
}

public static void setBrowser(String actualbrowser) {
	browser.set(actualbrowser);
}
public static String getBrowser() {
	return browser.get();
}
}
