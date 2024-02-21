package settingParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;




public class ToLIstUsers {
	@Test
	public void listUsers()
	{
		baseURI= "https://reqres.in/";
		given()
		.pathParam("ResourcePath1", "api")
		.pathParam("ResourcePath2", "users")
		.queryParam("page",2)
		.log().all()
		
		.when()
		.get("{ResourcePath1}/{ResourcePath2}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
