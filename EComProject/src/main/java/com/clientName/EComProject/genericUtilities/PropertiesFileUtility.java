package com.clientName.EComProject.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Utility class to handle operations related to Properties file.
 * It provides methods to read data from properties file.
 * 
 * @author Jyoti Kamble
 */

public class PropertiesFileUtility {
	 /**
     * This method reads data from a default properties file path.
     * 
     * @param key Key whose value needs to be fetched
     * @return Returns the value associated with the given key
     * @throws IOException If file is not found or unable to read
     */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		String path="C:\\Users\\Jyoti\\git\\EcomProjectRepoJyoti\\EComProject\\Test-Data\\OnlineBookStrore.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties pobj = new Properties();
		pobj.load(fis);
		String VALUE = pobj.getProperty(key);
		return VALUE;
	}
	
	   /**
     * This method reads data from a properties file by passing file path dynamically.
     * 
     * @param path Path of the properties file
     * @param key Key whose value needs to be fetched
     * @return Returns the value associated with the given key
     * @throws IOException If file is not found or unable to read
     */
	public String getDataFromPropertyFile(String path ,String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Properties pobj = new Properties();
		pobj.load(fis);
		String VALUE = pobj.getProperty(key);
		return VALUE;	
	}


}
