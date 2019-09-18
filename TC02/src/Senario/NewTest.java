package Senario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTest 
{
  @Test
  public void tc() throws IOException, EncryptedDocumentException, InvalidFormatException
  {
	  	
	  	RestAssured.baseURI = "https://reqres.in/api"; // base url
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/users?page=2"); // parameter
		String responsebodys /*this variable we have to use*/ = response.getBody().asString(); // we will get the response
		System.out.println("Response Body is => "+ responsebodys);
//		
//		 // Get the status code from the Response. In case of 
//		 // a successfull interaction with the web service, we
//		 // should get a status code of 200.
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
//		 // Assert that correct status code is returned.
//		 //Assert.assertEquals(statusCode , 200 , "Correct status code returned");
//		 if (statusCode==200)
//		 {
//			 System.out.println("status code is 200");
//		}
//		 else 
//		 {
//			 System.out.println("status code is not 200");
//		 }
//		 String statuscodeline = response.statusLine();
//		 System.out.println(statuscodeline);
		 
		 FileInputStream fis = new FileInputStream("./Data/Book1.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	
	int row = sh.getLastRowNum();
	System.out.println(row);
	
	Row r = sh.getRow(0);
	
	short cell = r.getLastCellNum();
	System.out.println(cell);
	
	Cell c = r.getCell(0);
	
//		 FileOutputStream fo = new FileOutputStream("./Data/Data.xlsx");
//		 wb.write(fo);
		 
//	  	File f = new File("./Data/Data1.txt");
//	  	FileWriter f1 = new FileWriter(f);
//	  	f1.write(responsebodys);
//	  	f1.flush();
	  	
  }
}
