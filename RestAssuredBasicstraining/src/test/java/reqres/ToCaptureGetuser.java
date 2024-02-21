package reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ToCaptureGetuser {
	
	@Test
	
	public void getUsers()
	{
		RestAssured
		//precondition
		.given().contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then().statusCode(200)
		.log().all();
	}
	
	

}
