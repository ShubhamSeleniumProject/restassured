package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.AddReview_pojo;
import api.utilities.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Addreview implements Endpoints{
	
	@Test
	public void getInvoice() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String productid = prop.getProperty("pid");
		String token=prop.getProperty("token");
		String shopperid = prop.getProperty("shopperId");
		
		AddReview_pojo ap=new AddReview_pojo("2024-02-01T12:59:26.024Z","product is good","review of product","4",shopperid,"shubham");
		
		Response res = given()
		.contentType(ContentType.JSON)
		.pathParam("pid", productid)
		.header("Authorization","Bearer "+token)
		.body(ap)
		
		.when()
		.post(baseURI+addReview);
		
		String reviewid = res.jsonPath().getString("data.reviewId");
		
		System.out.println(reviewid);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
		
		prop.setProperty("reviewId",reviewid);
		
		prop.store(fos,reviewid);
		
		
		
		
		
		
		
		
		
	}

}
