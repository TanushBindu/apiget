package Senario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./Data/Book1.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");	
	for (int j = 2; j <=60; j++) 
	{
		Row r = sh.getRow(j);
		for (int i = 3; i <=7; i++) 
		{
		if (r!=null)
			{
					Cell c = r.getCell(i);
					String value = c.getStringCellValue();
					System.out.println(value);
				
			}
		}
	}
	
	}
	
}
