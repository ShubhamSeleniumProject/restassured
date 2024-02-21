package Shopper;

import static io.restassured.RestAssured.given;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.Login_post_POJO;
import api.utilities.Endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login_post implements Endpoints 
	
	 {
		 @Test
		public void login() throws IOException
		{
		
		Login_post_POJO lp=new Login_post_POJO("shubham0002.gupta@gmail.com","Shubham@123", "SHOPPER");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.body(lp)
		
		.when()
			.post(baseURI+shopperLogin);
		
		String token = res.jsonPath().getString("data.jwtToken");
		String shopperID = res.jsonPath().getString("data.userId");
		Properties prop=new Properties();
		prop.setProperty("token", token);
		prop.setProperty("shopperId", shopperID);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
		
		
		prop.store(fos, "token & shopperID");
		
		
		
		
		
			
		
		
		
	}

}
