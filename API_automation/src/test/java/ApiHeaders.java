import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHeaders {

	@Test(priority=1)
	public void headContents()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification res1 = RestAssured.given();
		res1.param("page", 2);
		Response res_body = res1.get();
		//Reporter.log(res_body.asString(),true);
		Headers head_content = res_body.headers();
		for(Header head:head_content)
		{
			Reporter.log(head.getName()+" " +head.getValue(),true);
			
			/*if(head.getName().equals("Content-Type"))
			{
			Reporter.log(head.getName()+" "+head.getValue(),true);
			}
			else
			{
				continue;
			}*/
		}
	}
}
