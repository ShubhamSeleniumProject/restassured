package order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import static io.restassured.RestAssured.*;

public class GetOrder implements Endpoints{
	
	@Test
	
	public void getorder() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
		
		given()
		.pathParam("shopperId",shopperid)
		.header("Authorization","Bearer "+token)
		
		.when()
		.get(baseURI+getOrder).then().log().all();
		
		
		
	}
	

}
