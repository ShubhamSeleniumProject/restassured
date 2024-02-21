package address;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.UpdateAddress_pojo;
import api.utilities.Endpoints;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutAddress implements Endpoints{
	
	@Test
	public void putaddress() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String addressid = prop.getProperty("addressId");
		String token = prop.getProperty("token");
		
		UpdateAddress_pojo up=new UpdateAddress_pojo("1","403","Bangalore","India","near sbi bank","maan aPt",
										"8789214781","560010","karnataka west","2nd cross strt","string");
		
		given()
		.contentType(ContentType.JSON)
		.header("Authorization","Bearer "+token)
		.body(up)
		.pathParam("shopperId",shopperid)
		.pathParam("addressId",addressid)
		
		.when()
		.put(baseURI+putAddress).then().log().all();
		
		
		
		
	}

}
