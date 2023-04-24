package Extensions;

import Utilities.Operations;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RestVerifications extends Operations {
    public static void VerifyIfTwoStringsAreEqualFromQry (String string, String Qry){


        try {
            Assert.assertEquals(string, Qry);
            currentTest.pass(string + " and " + Qry + " are identical!");
        }
        catch(AssertionError e)
        {
            System.out.println("Assertion error. ");
            Assert.fail(string + " and " + Qry + " are Not identical!");
        }

    }
    public static void VerifyIfTwoBooleansAreEqualFromQry (Boolean bol, Boolean Qry){


        try {
            Assert.assertEquals(bol, Qry);
            currentTest.pass(bol + " and " + Qry + " are identical!");
        }
        catch(AssertionError e)
        {
            System.out.println("Assertion error. ");
            Assert.fail(bol + " and " + Qry + " are Not identical!");
        }

    }

//    public static void VerifyIfTwoJSONSAreEqualFromQry (JSONObject jsn, JSONObject Qry){
//      ObjectMapper mapper = new ObjectMapper(){};
//
//
//        try {
//            Assert.assertEquals(mapper.readTree(jsn), Qry);
//            currentTest.pass(jsn + " and " + Qry + " are identical!");
//        }
//        catch(AssertionError e)
//        {
//            System.out.println("Assertion error. ");
//            Assert.fail(jsn + " and " + Qry + " are Not identical!");
//        }
//
//    }


    public static void VerifySuccessResponse(){
        try{
            Assert.assertTrue(statusCode==200||statusCode==201||statusCode==204);
            currentTest.pass("Request Success");
        }
        catch (Exception e){
            Assert.fail();
            currentTest.fail("Request Failed");
        }
    }



}

