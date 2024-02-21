package reqres;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToregisterUSer {
	@Test
	public void registeruser()
	{
		given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}")
		
		.when()
		.post("https://reqres.in/api/register")
		
		.then()
	.statusCode(200)
		.log().all();
	}

}
