package validating;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class Togetusers {
	@Test
	public void getusers()
	{
		 Response res = given()
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		JSONObject responsebody=new JSONObject(res.asString());
		JSONArray users=responsebody.getJSONArray("data");
				
				boolean flag=false;
		
		for (int i=0;i<users.length();i++)
		{
			JSONObject userdetails=(JSONObject) users.get(i);
			String username = userdetails.getString("last_name");
			if (username.equals("Funke"))
			{
				flag=true;
				break;
				
			}
		}
		if(flag)
		{
			System.out.println("Funke is present");
			
		}
		else
		{
			System.out.println("Funke is not present");
		}
	}

}
