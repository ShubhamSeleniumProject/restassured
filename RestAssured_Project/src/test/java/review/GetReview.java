package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetReview implements Endpoints {
	
	@Test
	public void getReview() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String productid = prop.getProperty("pid");
		String token = prop.getProperty("token");
		
				given()
				.contentType(ContentType.JSON)
				.pathParam("pid",productid)
				.header("Authorization","Bearer "+token)
				
				.when()
				.get(baseURI+getReview).then().log().all();
				
		
		
		
		
	}

}
