package reqres;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class ToupdateUser {
	@Test
	public void updateUser()
	{
		given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "")
		.when()
		.put("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
