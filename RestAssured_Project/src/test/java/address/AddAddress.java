package address;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import api.PayLoad.AddAddress_pojo;

import api.utilities.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddAddress implements Endpoints{
	@Test
	public void addAddress() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String shopperid = prop.getProperty("shopperId");
		String token = prop.getProperty("token");
		
		AddAddress_pojo ap=new AddAddress_pojo("1","403","Bangalore","India",
				"near sbi bank","maan aPt","8789214781","560010","karnataka","2nd cross strt","string");
		
		Response res = given()
		.header("Authorization","Bearer "+token)
		.contentType(ContentType.JSON)
		.pathParam("shopperId",shopperid)
		.body(ap)
		
		.when()
		.post(baseURI+addAddress);
		
		String addressid = res.jsonPath().getString("data.addressId");
		System.out.println(addressid);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
		prop.setProperty("addressId",addressid);
		
		prop.store(fos, addressid);
		
		
		
		
	}

}
