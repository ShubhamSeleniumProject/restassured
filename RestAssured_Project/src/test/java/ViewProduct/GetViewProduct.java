package ViewProduct;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetViewProduct implements Endpoints {
	
	@Test
	public void viewproduct() throws IOException
	{
		
		
		String token = null;
		  Response res = given()
		.header("Authorization","Bearer"+token)
		.when().get(baseURI+viewProduct);
		
		
		 String productId=res.jsonPath().getString("data[0].productId");
		 System.out.println(productId);
		 
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		
		
		prop.load(fis);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
		prop.setProperty("pid", productId);
		prop.store(fos, productId);
		
		
		
		
		
		
		
		
		
		
	}

}
