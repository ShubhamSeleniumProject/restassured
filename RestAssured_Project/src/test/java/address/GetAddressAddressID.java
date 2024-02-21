package address;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAddressAddressID implements Endpoints{
	
	@Test
	public void getaddressaddressid() throws IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String addressid = prop.getProperty("addressId");
		String token = prop.getProperty("token");
		
		given()
		.header("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.pathParam("shopperId",shopperid)
		.pathParam("addressId",addressid)
		
		.when()
		.get(baseURI+getAddressid).then().log().all();
	}

}
