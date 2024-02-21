package validating;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class LIstResource {
	@Test
	
	public void list()
	{
		baseURI="https://reqres.in/";
	Response res = given()
			.pathParam("Resource_path1", "api")
			.pathParam("Resource_path2", "unknown")
			
			
			.when()
			.get("{Resource_path1}/{Resource_path2}");
	
		JSONObject jo=new JSONObject(res.asString());
		JSONArray ja=jo.getJSONArray("data");
	
		boolean flag=false;
		for (int i=0;i<ja.length();i++)
		{
			JSONObject yearList=(JSONObject) ja.get(i);
			int year1 = yearList.getInt("year");
			
			if (year1==2001)
			{
				
				
				flag=true;
				break;
			}
		}
			if (flag)
			{
				System.out.println("year exists");
				
			}
			else
			{
				System.out.println("year not exist");
			}
			
			
		}
	

}
