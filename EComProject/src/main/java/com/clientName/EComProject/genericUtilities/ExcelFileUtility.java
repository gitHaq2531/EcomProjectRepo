package com.clientName.EComProject.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility 
{
	String path ="C:\\Users\\Jyoti\\git\\EcomProjectRepoJyoti\\EComProject\\Test-Data\\OnlineBookstoreTD.xlsx";
	public String getDataFromExcelFile(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return value;	
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return count;	
	}
	
	public void setExcelCellValue(String sheetName,int rownum,int cellnum,String cellvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		if(row==null) {row=sheet.createRow(rownum);}
		
		row.createCell(cellnum, CellType.STRING).setCellValue(cellvalue);
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		wb.close();		
		
	}
}
