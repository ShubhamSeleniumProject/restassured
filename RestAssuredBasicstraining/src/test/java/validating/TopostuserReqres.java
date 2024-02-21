package validating;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class TopostuserReqres {

	@Test
	public void user()
	{
		Map<String,String> mp=new HashMap<String, String>();
		mp.put("name", "batsman");
		
		given()
		.header("Authorization","Bearer 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")
		.body(mp)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().body()
		.header("Content-Type","application/json; charset=utf-8")
//		.header("Content-Length", "5722")
		.body("name",Matchers.equalTo("batsman"))
		.statusCode(201)
		.log().all();

	}
}
