package order;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.AddOrder_pojo;
import api.utilities.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddOrder implements Endpoints {
	
	@Test
	public void addorder() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
					String addid = prop.getProperty("addressId");
					System.out.println(addid);
		
		
		AddOrder_pojo obj=new AddOrder_pojo(addid);
		AddOrder_pojo data = new AddOrder_pojo(obj, "COD");
		
					
		Response res = given()
		.pathParam("shopperId",shopperid)
		.contentType(ContentType.JSON)
		.header("Authorization","Bearer "+token)
		.body(data).log().all()
		
		.when()
		.post(baseURI+addOrder).then().log().all().extract().response();
		
		String orderid = res.jsonPath().getString("data.orderId");
		System.out.println(orderid);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
	prop.setProperty("orderId",orderid);
		
	prop.store(fos, orderid);
		
		
	}

}
