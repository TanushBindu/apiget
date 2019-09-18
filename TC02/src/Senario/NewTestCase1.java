package Senario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTestCase1 
{
	public static void main(String[] args) throws IOException 
	{
	  	RestAssured.baseURI = "https://reqres.in/api";
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.request(Method.GET,"/users?page=2");
			String responsebody = response.getBody().asString();
			System.out.println("Response Body is => "+ responsebody);
			File f = new File("./Data/Data.xlsx");
			FileWriter fw = new FileWriter(f);
			fw.write(responsebody);
			fw.flush();
			
	}
}
