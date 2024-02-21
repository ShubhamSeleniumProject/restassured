package settingParameter;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TocreateUser {

	@Test
	
	public void createUser()
	{
		
		Map<String, String> mp=new HashMap<>();
		
		mp.put("skg", "test eng");
		mp.put("sohan", "head");
		
		baseURI="https://reqres.in/";
		
		
		given()
//		.contentType(ContentType.JSON)
		.header("Content-Type","application/json")
	.body(mp)
		.pathParam("ResourcePath1", "api")
		.pathParam("ResourcePath2", "users")
		
		.log().all()
		
		.when()
		.post("{ResourcePath1}/{ResourcePath2}")
		
		
		
		.then()
		.statusCode(201)
		.log().all();
		
		
		
	}
	
}
