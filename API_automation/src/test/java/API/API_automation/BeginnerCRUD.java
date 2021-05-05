package API.API_automation;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BeginnerCRUD {
	@Test(priority =3)
	public void test1()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		Reporter.log(RestAssured.baseURI,true);
		RequestSpecification res = RestAssured.given();
		Reporter.log(res.toString(),true);
		RequestSpecification bd1 = res.param("page",2);
		Response bd = bd1.get();
		Reporter.log(bd.asString(),true);
		Reporter.log(bd.asPrettyString(),true);
	}
	@Test(priority=4)
	public void postMethod()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		Reporter.log(RestAssured.baseURI,true);
		RequestSpecification httprequest = RestAssured.given();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name","Megha");
		jsonObject.put("job","SEDT");
		httprequest.contentType("application/json");
		httprequest.body(jsonObject.toJSONString());
		Response body = httprequest.request(Method.POST);
		Reporter.log(body.asPrettyString(),true);
		int status_code=body.getStatusCode();
		Reporter.log("status code:"+status_code,true);
	}
	@Test(priority=2)
	public void putMethod()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		httprequest.param("id",1);
		httprequest.contentType("application/json");
		HashMap map = new HashMap();
		map.put("name", "Megha Kar");
		map.put("job", "SEDT1");
		httprequest.body(map);
		
		Response resbody = httprequest.request(Method.PUT);
		Reporter.log(resbody.asPrettyString(),true);
		String st_linne = resbody.statusLine();
		Reporter.log(st_linne,true);
	}

	@Test(priority=1)
	public void deleteMethod()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		httprequest.param("id",2);
		Response resbody = httprequest.delete();
		Reporter.log(resbody.asPrettyString(),true);
		int code=resbody.getStatusCode();
		Reporter.log("status code: "+code,true);
		
	}
}
