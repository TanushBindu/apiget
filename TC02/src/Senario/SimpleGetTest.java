package Senario;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest 
{

	@Test
	public void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
		/*Response response = httpRequest.get("/Hyderabad");*/

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Bangalore");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		int statusCode = response.getStatusCode();
		 
		 // Assert that correct status code is returned.
		 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

		 String statusLine = response.getStatusLine();
		 Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code response");
		 
		// Reader header of a give name. In this line we will get
		 // Header named Content-Type
		 String contentType = response.header("Content-Type");
		 System.out.println("Content-Type value: " + contentType);
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Server
		 String serverType =  response.header("Server");
		 System.out.println("Server value: " + serverType);
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Encoding
		 String acceptLanguage = response.header("Content-Encoding");
		 System.out.println("Content-Encoding: " + acceptLanguage);
		 
		// Get all the headers. Return value is of type Headers.
		 // Headers class implements Iterable interface, hence we
		 // can apply an advance for loop to go through all Headers
		 // as shown in the code below
		 Headers allHeaders = response.headers();
		 
		 // Iterate over all the Headers
		 for(Header header : allHeaders)
		 {
		 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		 
		// Reader header of a give name. In this line we will get
		 // Header named Content-Type
		 String contentType1 = response.header("Content-Type");
		 Assert.assertEquals(contentType1 /* actual value */, "application/json" /* expected value */);
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Server
		 String serverType1 =  response.header("Server");
		 Assert.assertEquals(serverType1 /* actual value */, "nginx" /* expected value */);
		 
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Encoding
		 String contentEncoding = response.header("Content-Encoding");
		 Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
		 
		 ResponseBody body = response.getBody();
		 String bodyasString = body.asString();
		 Assert.assertEquals(bodyasString.contains("Bangalore") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		 
		// convert the body into lower case and then do a comparison to ignore casing.
		 Assert.assertEquals(bodyasString.toLowerCase().contains("Bangalore") /*Expected value*/, false /*Actual Value*/, "Response body contains Hyderabad");
		 
		// First get the JsonPath object instance from the Response interface
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 
		 // Then simply query the JsonPath object to get a String value of the node
		 // specified by JsonPath: City (Note: You should not put $. in the Java code)
		 String city = jsonPathEvaluator.get("City");
		 
		 // Let us print the city variable to see what we got
		 System.out.println("City received from Response " + city);
		 
		 // Validate the response
		 Assert.assertEquals(city, "Bangalore", "Correct city name received in the Response");
		 
		// Let us print the city variable to see what we got
		 System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
		 
		 // Print the temperature node
		 System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));
		 
		 // Print the humidity node
		 System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));
		 
		 // Print weather description
		 System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));
		 
		 // Print Wind Speed
		 System.out.println("City received from Response " + jsonPathEvaluator.get("WindSpeed"));
		 
		 // Print Wind Direction Degree
		 System.out.println("City received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
		 
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");
		 
		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email",  "someuser@gmail.com");
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		// Post the request and check the response
		Response response_1 = httpRequest.post("/register");
		
		//int poststatusCode = response.getStatusCode();
		//Assert.assertEquals(statusCode, "200");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( successCode,null, "OPERATION_SUCCESS");

		/*--------------------------------Post------------------------------*/
		
/*		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "Virender"); // Cast
		 requestParams.put("LastName", "Singh");
		 requestParams.put("UserName", "sdimpleuser2dd2011");
		 requestParams.put("Password", "password1");
		 
		 requestParams.put("Email",  "sample2ee26d9@gmail.com");
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/register");
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, "201");
		 String successCode = response.jsonPath().get("SuccessCode");
		 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS"); */
		
		
		
		 }
	}

}

