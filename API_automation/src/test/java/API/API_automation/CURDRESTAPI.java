package API.API_automation;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

public class CURDRESTAPI {
	/*@Test
	public void test()
	{
		String jbody="{\n"+ " \"name\": \"Megha\",\n"+ "\"job\": \"leader\"\n"+
"}";
		RestAssured.given().body(jbody)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.log().all()
		.assertThat().statusCode(201);
		
	}
*/	@Test(priority=1)
	public void postMethod()
	{
		HashMap map = new HashMap();
		map.put("name", "Megha");
		map.put("job","leader");
		RestAssured.given()
		.contentType("application/json")
		.body(map)
		.when().post("https://reqres.in/api/users")
		.then()
		.log().body().body("job",equalTo("leader"))
		.assertThat().statusCode(201);
	}
	@Test(priority=2)
	public void getMethod()
	{
		RestAssured.given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.log().body()
		.assertThat().statusCode(200);
	}
	@Test(priority=3)
	public void putMethod()
	{
		HashMap map = new HashMap();
		map.put("name", "Megha");
		map.put("job","tester");
		RestAssured.given().contentType("application/json")
		.body(map)
		.when().put("https://reqres.in/api/users/2").then().log().all().assertThat().statusCode(200);
	}
	@Test(priority=4)
	public void deleteMethod()
	{
		RestAssured.given()
		.when().delete("https://reqres.in/api/users?page=2").then().log().all()
		.assertThat().statusCode(204);
	}

}
