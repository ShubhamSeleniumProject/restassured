package settingParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ToSingleUSerNotFound {
	@Test
	public void tosingleuser()
	{
		baseURI="https://reqres.in/";
		
		given()
		.pathParam("ResourcePath1", "api")
		.pathParam("ResourcePAth2", "users")
		.pathParam("ResourcePath3", "23")
		
		
		.when()
		.get("{ResourcePath1}/{ResourcePAth2}/{ResourcePath3}")
		
		.then()
		.statusCode(404)
		.log().all();
	}

}
