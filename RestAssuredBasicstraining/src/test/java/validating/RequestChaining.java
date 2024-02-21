package validating;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {
	
	String Reponame;
	@Test(priority = 1)
	public void togetid()
	{
		Random random=new Random();
		int rand=random.nextInt(1000);
		
		Map<String, String> mp=new HashMap<>();
		
		mp.put("name", "skgupta2"+rand);
		mp.put("description","hello");
		mp.put("private", "true");
		
		Response res = given()
		.header("Authorization","Bearer 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")
		.body(mp)
		
		.when()
		.post("https://api.github.com/user/repos");
		
		res.then().log().body();
		
		JSONObject jo=new JSONObject(res.asString());
		Reponame = jo.getString("name");
		System.out.println(Reponame);
	
		
		
	}
	
	@Test(priority = 2)
	public void capture()
	{
		given()
		.header("Authorization","Bearer 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")
		.pathParam("skg",Reponame)
		
		
		.when()
		.get("https://api.github.com/repos/shubhamtrainer/{skg}")
		
		
		
		.then()
		.log().all();
	}

}
