package passingData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ToUpdatebyusingHAshMap {
	@Test
	public void updateUser()
	{
		Map<String,String> mp=new HashMap<>();
		mp.put("name","shubham");
		mp.put("job","qa team");
	
		given()
		.header("Content-Type","application/json")
		.body(mp)
		.when()
		.put("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();

}
}
