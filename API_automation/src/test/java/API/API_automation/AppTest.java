package API.API_automation;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest 
  
{
	@Test
	public void test()
	{
		
		Response respbody = RestAssured.given()
				.param("page", 2)
		.when().get("https://reqres.in/api/users");
		Reporter.log(respbody.asString(),true);
		Reporter.log(respbody.asPrettyString(),true);
		Reporter.log(respbody.getSessionId(),true);
		
		/*RestAssured.baseURI="https://reqres.in/api/users";
		Reporter.log(RestAssured.baseURI,true);
		RestAssured.basePath="api/users/2";
		Reporter.log(RestAssured.basePath,true);
		
		RestAssured.given().param("page",2)
		.when()
		.get()
		.then()
		.assertThat()
		.log().cookies()
		.statusCode(200);*/
		
	}
   
}
