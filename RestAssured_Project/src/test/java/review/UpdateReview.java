package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.UpdateReview_pojo;
import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateReview implements Endpoints{
	
	@Test
	public void updatReview() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
		String reviewid = prop.getProperty("reviewId");
		String productid = prop.getProperty("pid");
		
		UpdateReview_pojo up=new UpdateReview_pojo("2024-02-01T12:59:26.024Z","product is not good","review of product","4", shopperid,"shubham");
		
		given()
		.pathParam("reviewId",reviewid)
		.pathParam("pid",productid)
		.header("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.body(up)
		
		.when()
		.put(baseURI+putReview).then().log().all();
		
		
	}

}
