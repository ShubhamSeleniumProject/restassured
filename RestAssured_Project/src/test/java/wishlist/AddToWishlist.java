package wishlist;


	

	
	import org.testng.annotations.Test;

	import api.PayLoad.Wishlist_pojo;
	import api.utilities.Endpoints;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;

	import static io.restassured.RestAssured.*;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class AddToWishlist implements Endpoints{
		
		@Test
		public void addWishlist() throws IOException
		{
			
			FileInputStream fis=new FileInputStream("./src/test/resources/variables.properties");
			Properties prop=new Properties();
			
			prop.load(fis);
			String productId = prop.getProperty("pid");
			System.out.println(productId);
			String shopperid = prop.getProperty("shopperId");
			String token = prop.getProperty("token");
			
			Wishlist_pojo wp=new Wishlist_pojo(productId,1);
			
			Response res = given()
			.contentType(ContentType.JSON)
			
			.header("Authorization","Bearer "+token)
			.pathParam("shopperId",shopperid)
			.body(wp)
			
			.when()
			.post(baseURI+wishlistPost)
			
			.then().log().all().extract().response();
			
			
			
		String iId = res.jsonPath().getString("data.itemId");
		
		System.out.println(iId);
		
		
		
			FileOutputStream fos=new FileOutputStream("./src/test/resources/variables.properties",true);
			
			prop.setProperty("itemId", iId);
			
			prop.store(fos, iId);

			
			
		}

	}



