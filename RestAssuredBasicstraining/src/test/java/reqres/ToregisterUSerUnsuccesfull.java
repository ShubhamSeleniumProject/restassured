package reqres;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class ToregisterUSerUnsuccesfull {
	
	@Test
	public void userUnsuccessfull()
	{
		given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"email\": \"sydney@fife\"\r\n"
				+ "}\r\n"
				+ "")
		
		.when()
		.post("https://reqres.in/api/register")
		
		.then()
		.statusCode(400)
		.log().all();
	}

}
