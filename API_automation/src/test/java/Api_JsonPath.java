import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api_JsonPath {
	@Test
	public void path_JSON()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		httprequest.param("page",2);
		Response response = httprequest.request(Method.GET);
		Reporter.log(response.asString(),true);
		JsonPath jPath = response.jsonPath();
		Integer page = jPath.get("page");
		System.out.println(page);
		Integer per_page = jPath.get("per_page");
		System.out.println(per_page );
		Integer total=jPath.get("total");
		System.out.println(total);
		ArrayList<JsonElement> el1 = jPath.get("data.id");
		String val = String.valueOf(el1.get(0));
		System.out.println(val);
	}

}
