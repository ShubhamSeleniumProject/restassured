package wishlist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteWishlist implements Endpoints {
	
	@Test
	public void delete() throws IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String productid = prop.getProperty("pid");
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
		
		given()
		.contentType(ContentType.JSON)
		.header("Authorization","Bearer"+token)
		.pathParam("pid", productid)
		.pathParam("shopperId",shopperid)
		
		.then().log().all();
		
		
	}

}
