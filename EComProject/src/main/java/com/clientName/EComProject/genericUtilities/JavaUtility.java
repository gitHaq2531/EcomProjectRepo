package com.clientName.EComProject.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNum()
	{
		Random random=new Random();
		int rnum = random.nextInt(1000);
		return rnum;
	}
	
	public String getSystemDate()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
		String date=sdf.format(dateobj);
		return date;	
	}
	
	public String getRequriedDate(int days)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sdf.format(cal.getTime());
		return reqDate;
	}
}



