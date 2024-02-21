package validating;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetSingleuser {

	@Test
	public void user()
	{
		
		baseURI="https://reqres.in/";
				Response res = given()
						.pathParam("resourcePAth1", "api")
						.pathParam("resourcePath2", "users")
						.pathParam("resourcePath", "2")
						
						
						
						.when()
						.get("{resourcePAth1}/{resourcePath2}/{resourcePath}");
						
						JSONObject jo=new JSONObject(res.asString());
				JSONObject jo1 = jo.getJSONObject("data");
				
				String l_name = jo1.getString("last_name");
				if (l_name.equals("Weaver"))
				{
					System.out.println("weaver exists");
				}
				else
				{
					System.out.println("Weaver not exists");
				}
	}
	
}
