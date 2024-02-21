package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToGetSingleResourceNotFound {
	@Test
	public void resourceNotFound()
	{
		given()
		.header("Content-Type","application/json")
		
		.when()
		.get("https://reqres.in/api/unknown/23")
		
		.then()
		.statusCode(404)
		.log().all();
	}

}
