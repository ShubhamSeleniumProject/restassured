package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TopostUser {
	@Test
	
	public void postUser()
	{
	given()
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "")
	.when()
	.post("https://reqres.in/api/users")
	.then()
	.statusCode(201)
	.log().all();
	}

}
