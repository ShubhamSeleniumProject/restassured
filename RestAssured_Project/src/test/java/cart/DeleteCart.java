package cart;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteCart implements Endpoints {
	@Test
	public void deleteCart() throws IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/variables.properties");	
		Properties prop=new Properties();
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String productid = prop.getProperty("pid");
		String token = prop.getProperty("token");
		
		given()
		.header("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.pathParam("shopperId",shopperid)
		.pathParam("pid",productid)
		
		.when()
		.delete(baseURI+deleteCart).then().log().all();
		
		
	}

}
