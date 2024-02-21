package wishlist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetFromWishlist implements Endpoints {
	
	@Test
	
	public void getwishlist() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
		
				Response res = given()
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+token)
				.pathParam("shopperId",shopperid)
				
				.when()
				.get(baseURI+getWishList)
				.then().log().all().extract().response();
				
				
		
		
		
	}

}
