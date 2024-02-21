package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToGetListResource {
	@Test
	public void getlistResource()
	{
	given()
	.header("Content-Type","application/json")
	
	.when()
	.get("https://reqres.in/api/unknown")
	
	.then()
	.statusCode(200)
	.log().all();
	}

}
