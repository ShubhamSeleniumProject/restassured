package cart;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.PutCart_pojo;
import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutCart implements Endpoints{
	
	@Test
	public void putCart() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String productid = prop.getProperty("productId");
		String token = prop.getProperty("token");
		String itemid = prop.getProperty("itemId");
		PutCart_pojo pc=new PutCart_pojo(productid,1);
		
	given()
			.header("Authorization","Bearer "+token)
			.pathParam("shopperId",shopperid)
			.pathParam("itemId",itemid)
			.contentType(ContentType.JSON)
			.body(pc)
			
			.when()
			.put(baseURI+putCart).then().log().all();
			
		
	}

}
