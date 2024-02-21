package passingData;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ToLoginusingPayLoad {
	@Test
	public void usersucessfull()
	{
		given()
		.header("Content-Type","application/json")
		.body(PayLoad.loginUSerSuccessfull())
		
		.when()
		.post("https://reqres.in/api/login")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}


