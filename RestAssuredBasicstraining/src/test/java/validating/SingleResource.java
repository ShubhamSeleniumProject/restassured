package validating;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SingleResource {
	
	@Test
	public void single()
	{
		baseURI="https://reqres.in/";
		Response res = given()
				.pathParam("ResourcePath1", "api")
				.pathParam("ResourcePath2", "Unknown")
				.pathParam("ResourcePath3", "2")
				
				.when()
				.get("{ResourcePath1}/{ResourcePath2}/{ResourcePath3}");
				
				JSONObject jo=new JSONObject(res.asString());
		JSONObject jo1=jo.getJSONObject("data");
		
		String name1 = jo1.getString("name");
		if (name1.equals("fuchsia rose"))
		{
			System.out.println("name presnt");
			
		}
		else
		{
			System.out.println("name dont exist");
		}
	}

}
