package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TologinUSerUnsuccesful {
	@Test
	public void userunsuccesfull()
	{
		given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"email\": \"peter@klaven\"\r\n"
				+ "}")
		
		.when()
		.post("https://reqres.in/api/login")
		
		
		.then()
		.statusCode(400)
		.log().all();
	}

}
