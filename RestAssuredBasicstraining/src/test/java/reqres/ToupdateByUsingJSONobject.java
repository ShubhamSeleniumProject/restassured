package reqres;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class ToupdateByUsingJSONobject {

public class ToupdateUser {
	@Test
	public void updateUser()
	{
		JSONObject jo=new JSONObject();
		jo.put("skgupta", "head team");
	
		given()
		.header("Content-Type","application/json")
		.body(jo.toString())
		.when()
		.put("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}

}
