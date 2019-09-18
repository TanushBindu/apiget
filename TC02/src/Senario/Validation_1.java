package Senario;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Validation_1
{
	static void getrequest()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpsRequest = RestAssured.given();
		Response reponses = httpsRequest.request(Method.GET,"/users?page=2");
		String responsebody = reponses.getBody().toString();
		System.out.println(responsebody);
		httpsRequest.post().
	}
	
	public static void main(String[] args) 
	{
		getrequest();
	}
}
