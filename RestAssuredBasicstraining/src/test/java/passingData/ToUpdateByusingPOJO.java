package passingData;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ToUpdateByusingPOJO {


	@Test
	public void updateUser()
	{
		POJOclass pc=new POJOclass("skg", "qa team");
		given()
		.header("Content-Type","application/json")
		.body(pc).log().all()
		.when()
		.put("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}


}
