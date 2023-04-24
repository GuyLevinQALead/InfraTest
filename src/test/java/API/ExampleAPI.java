package API;

import Utilities.Operations;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleAPI extends Operations {
    @Test
    public void CreateSimpleUser(){
        RestAssured.baseURI = dr.GetData("urlAPI");
        RequestSpecification request =RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name","Guy");
        requestParams.put("job","Automation Tester");

        request.body(requestParams.toString());
        Response response = request.post ("/api/users");

        Assert.assertEquals(response.getStatusCode(),201);
        System.out.println(response.getBody().asString());
        System.out.println("User Created");



    }
}
