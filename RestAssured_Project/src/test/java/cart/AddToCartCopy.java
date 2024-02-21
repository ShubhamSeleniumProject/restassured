package cart;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.AddCart_pojo;
import api.utilities.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddToCartCopy implements Endpoints{
	
	@Test
	public void addcart() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		String productId = prop.getProperty("pid");
		System.out.println(productId);
		String shopperId = prop.getProperty("shopperId");
		System.out.println(shopperId);
		String token = prop.getProperty("token");
		
		AddCart_pojo ap=new AddCart_pojo(productId,1);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.pathParam("shopperId", shopperId)
		.header("Authorization","Bearer "+token)
		.body(ap)
		
		.when()
		.post(baseURI+postCart).then().log().all().extract().response();
		
		String cart_itemid = res.jsonPath().getString("data.itemId");
		System.out.println(cart_itemid);
		

		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
		
		prop.setProperty("itemId",cart_itemid);
		prop.store(fos, cart_itemid);
		
	}

}
