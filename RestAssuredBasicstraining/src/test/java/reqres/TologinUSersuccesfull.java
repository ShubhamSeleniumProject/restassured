package reqres;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TologinUSersuccesfull {
	@Test
	public void usersucessfull()
	{
		given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}")
		
		.when()
		.post("https://reqres.in/api/login")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
