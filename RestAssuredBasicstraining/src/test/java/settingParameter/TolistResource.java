package settingParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TolistResource {

	@Test
	
	public void listResource()
	{
		baseURI="https://reqres.in/";
		
		given()
		.pathParam("ResourcePath1", "api")
		.pathParam("ResourcePath2", "unknown")
		
		.when()
		.get("{ResourcePath1}/{ResourcePath2}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
