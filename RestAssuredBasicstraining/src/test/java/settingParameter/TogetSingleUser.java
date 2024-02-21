package settingParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TogetSingleUser {

	@Test
	public void getsingle_user()
	{
		baseURI="https://reqres.in/";
		
		given()
		.pathParam("ResourcePath1", "api")
		.pathParam("ResourcePath2", "users")
		.pathParam("ResourcePath3", "2")
		.log().all()
		
		.when()
		.get("{ResourcePath1}/{ResourcePath2}/{ResourcePath3}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
