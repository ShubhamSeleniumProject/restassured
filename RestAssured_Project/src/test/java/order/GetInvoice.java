package order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetInvoice implements Endpoints{
	
	@Test
	public void getInvoice() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		prop.load(fis);
		

		
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
		String orderid=prop.getProperty("orderId");
		
		given()
		
		.pathParam("shopperId",shopperid)
		.pathParam("orderId", orderid)
		.contentType(ContentType.JSON)
		.header("Authorization","Bearer "+token)
		
		.when()
		.get(baseURI+getInvoice)
		
		.then().log().all();
		
		
	}
	

}
