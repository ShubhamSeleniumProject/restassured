package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteReview implements Endpoints{
	
	@Test
	public void deletereview() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String reviewid = prop.getProperty("reviewId");
		String productid = prop.getProperty("pid");
		String token = prop.getProperty("token");
		
		given()
		.contentType(ContentType.JSON)
		.pathParam("reviewId",reviewid)
		.pathParam("pid",productid)
		.header("Authorization","Bearer "+token)
		
		.when()
		.delete(baseURI+deleteReview)
		
		.then().log().all();
		
		
		
	}

}
