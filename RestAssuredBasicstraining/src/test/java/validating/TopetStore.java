package validating;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class TopetStore {
	
	long petid;
	@Test(priority = 1)
	
	public void pet() throws FileNotFoundException
	{
		
		
		baseURI="https://petstore.swagger.io/v2";
		
		FileReader fr=new FileReader("./src/test/resources/petstoreBody/BODY.JSON");
		JSONTokener jt=new JSONTokener(fr);
		JSONObject jo=new JSONObject(jt);
		
		Response res = given()
		.header("Content-Type","application/json")
		.body(jo.toString())
		.pathParam("ResourcePath1", "pet")
		.log().all()
		.when()
		.post("{ResourcePath1}");
//		.post("https://petstore.swagger.io/v2/pet");
		
//		
		
//		petid=res.jsonPath().get("id");
		JSONObject jo1=new JSONObject(res.asString());
		petid=jo1.getLong("id");
		
		System.out.println(petid);
	
	}


	@Test(priority = 2)
	public void capture()
	{
		given()
		
		.pathParam("id",petid )
		
		.when()
		.log().all()
		.get("https://petstore.swagger.io/v2/pet/{id}")
	
		.then().log().all();
	}
}
