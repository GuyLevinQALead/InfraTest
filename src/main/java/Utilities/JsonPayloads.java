package Utilities;

import com.mongodb.util.JSON;
import org.json.JSONObject;

public class JsonPayloads extends Operations{
    public static String path_Case = "/sobjects/Case";
    public static String path_RestCase = "/services/apexrest/Case";

    public static JSONObject CreateCaseJson(){
        JSONObject createCase = new JSONObject();
        createCase.put("Origin","Phone");
        return  createCase;
    }
    public static JSONObject UpdateCaseJson(){
        JSONObject updateCase = new JSONObject();
        updateCase.put("Origin","Email");
        return  updateCase;
    }

    public static JSONObject CreateAccountJson(){
        JSONObject createCase = new JSONObject();
        createCase.put("Origin","Phone");
        return  createCase;
    }





}
