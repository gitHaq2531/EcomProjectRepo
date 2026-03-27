package com.clientName.EComProject.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility 
{
	public String getDataFromPropertyFile(String key) throws IOException
	{
		String path="C:\\Users\\Jyoti\\git\\EcomProjectRepoJyoti\\EComProject\\Test-Data\\OnlineBookStrore.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties pobj = new Properties();
		pobj.load(fis);
		String VALUE = pobj.getProperty(key);
		return VALUE;
	}
	
	public String getDataFromPropertyFile(String path ,String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Properties pobj = new Properties();
		pobj.load(fis);
		String VALUE = pobj.getProperty(key);
		return VALUE;	
	}


}
