package address;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class GetAddress implements Endpoints {

	@Test
	public void getaddress() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		
		prop.load(fis);
		String token = prop.getProperty("token");
		String shopperid = prop.getProperty("shopperId");
		
		given()
		.header("Authorization","Bearer "+token)
		.pathParam("shopperId", shopperid)
		.contentType(ContentType.JSON)
		
		.when()
		.get(baseURI+getAddress).then().log().all();
		
	}

}
