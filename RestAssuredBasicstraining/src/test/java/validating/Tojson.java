package validating;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Tojson {
	@Test
	public void getUsers()
	{
		RestAssured.
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.body("data[1].first_name", Matchers.equalTo("Lindsay"));
		
	}
	

}
