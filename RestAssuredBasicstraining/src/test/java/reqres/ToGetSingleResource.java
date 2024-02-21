package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToGetSingleResource {
	@Test
	public void singleResource()
	{
		given()
		.header("Content-Type","application/json")
		
		.when()
		.get("https://reqres.in/api/unknown/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
