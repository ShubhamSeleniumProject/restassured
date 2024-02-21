package validating;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class ToSingleuser {
	@Test
	public void singleuser()
	{
		
		  Response res = given()
				 
				 .when()
				 .get("https://reqres.in/api/users/2");
				 JSONObject jo=new JSONObject(res.asString());
				 JSONObject ja = jo.getJSONObject("data");
						 
				 String fname = ja.getString("first_name");
				 if(fname.equals("Janet"))
				 {
					 System.out.println("janet is present");
				 }
				 
				 else
				 {
					 System.out.println("janet is not present");
				 }
				 
	}

}
