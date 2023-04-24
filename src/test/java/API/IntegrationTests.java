package API;

import Extensions.RestActions;
import Extensions.RestVerifications;
import Utilities.JsonPayloads;
import Utilities.Operations;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class IntegrationTests extends Operations {
    @AfterMethod
    public  void AfterEveryTest(){
        statusCode=0;
    }

    @Test
    public void createAndUpdateObject(){
RestActions.CreateRecordFromJson(JsonPayloads.CreateCaseJson(),JsonPayloads.path_Case);
RestActions.UpdateRecordFromJson(JsonPayloads.UpdateCaseJson(),JsonPayloads.path_Case,createdRecordID);
RestVerifications.VerifyIfTwoStringsAreEqualFromQry(RestActions.GetValueFromSpecificRecordJSONCell("Case","id",createdRecordID,"Origin")
        ,"Email");
RestActions.DeleteSingleRecordFromObject("Case", createdRecordID);
    }


}
