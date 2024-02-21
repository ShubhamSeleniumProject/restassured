package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToupdateUSers {
	@Test
	public void updateusers()
	{
		given()
		.header("Content-Type","application/json")
		
		.when()
		.patch("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
