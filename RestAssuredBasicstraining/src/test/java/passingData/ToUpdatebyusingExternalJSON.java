package passingData;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class ToUpdatebyusingExternalJSON {
	@Test
	public void updateUser() throws FileNotFoundException
{
	FileReader fr=new FileReader("./JSON/data.JSON");
	JSONTokener js=new JSONTokener(fr);
	JSONObject jo=new JSONObject(js);
	
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

