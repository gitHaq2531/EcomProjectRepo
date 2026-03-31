package com.clientName.EComProject.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection conn;
	public void getDbConnection(String url,String username,String password) throws SQLException
	{
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		DriverManager.getConnection(url,username,password);
			
	}
	
	public void getDbconnection() throws SQLException
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
			} catch (Exception e) {}
	}
	
	public void executeSelectQuery(String query) throws SQLException
	{
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
			
			}catch (Exception e) {}
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
			} catch (Exception e) {}
		return result;
	}

}
