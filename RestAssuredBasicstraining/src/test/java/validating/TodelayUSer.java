package validating;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TodelayUSer {

	
	@Test
	public void delay()
	{
		baseURI="https://reqres.in/";
		Response res = given()
				
				.pathParam("resource_path1","api")
				.pathParam("resource_path2","users")
				.queryParam("query","3")
				
				
				.when()
				.get("{resource_path1}/{resource_path2}");
		
		JSONObject jo=new JSONObject(res.asString());
		JSONArray ja = jo.getJSONArray("data");
	
		
		boolean flag=false;
		for (int i=0;i<ja.length();i++)
		{
			JSONObject lname=(JSONObject) ja.get(i);
							String l_name = lname.getString("last_name");
							if (l_name.equals("Wong"))
							{
								flag=true;
								break;
							}
		}
							if(flag)
							{
								System.out.println("wong exists");
							}
							else
							{
								System.out.println("wong not exists");
							}
		
				
				
	}
}
