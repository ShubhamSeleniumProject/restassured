package address;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteAddress implements Endpoints {
	
	@Test
	public void deleteaddress() throws IOException
	{
FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String addressid = prop.getProperty("addressId");
		String token = prop.getProperty("token");
		
		given()
		
		.contentType(ContentType.JSON)
		.pathParam("shopperId",shopperid)
		.pathParam("addressId",addressid)
		.header("Authorization","Bearer "+token)
		
		.when()
		.delete(baseURI+deleteAddress)
		.then().log().all();
	
		
		
	}

}
