package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TodelayedResponse {
	@Test
	public void delayResponse()
	{
		given()
		.header("Content-Type","application/json")
		
		.when()
		.get("https://reqres.in/api/users?delay=3")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
