package Utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;


import io.restassured.mapper.ObjectMapper;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Operations extends  Base{
    public static boolean inIframe =false;
    public static boolean switchTab = false;
    public  static  String mainWindow;
// 1 is QA env, all the rest are prod
    public static int environmentParameter;
    public  static DataReader dr = new DataReader();
    public static ExtentTest currentTest=extent.createTest("test");

//    api Variables
    public static boolean isAPI;
    public static String  REST_USERNAME,REST_PASSWORD,REST_URL,GRANTSERVICE,CLIENTID,CLIENTSECRET,REST_ENDPOINT,API_VERSION;
    public static String baseUri;
    public static String baseLoginUrl;
    public static Header oauthHeader;
    public static HttpPost httpPost;
    public static HttpClient httpClient;
    public static HttpResponse httpResponse;
    public static HttpGet httpGet;
    public static HttpDelete httpDelete;
    public  static Header prettyPrintHeader=new BasicHeader("X-PrettyPrint", "1");
    public  static String createdRecordID;
    public static  int statusCode;
    public static String response_string;


    public static WebDriver initiateChromeDriver(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
    public void InitiateBrowser(){
        driver=initiateChromeDriver();
        driver.manage().window().maximize();
        if (environmentParameter ==1) {
            driver.get(dr.GetData("url"));
        }
          else {
            driver.get(dr.GetData("urlProd"));
        }

        PageManager.InitiatePages();
         actions =new Actions(driver);
         wait = new WebDriverWait(driver, 10);
         htmlReporter=new ExtentSparkReporter("ExtentReports/extentReport" +dtf.format(localDate)+ ".html");
         extent.attachReporter(htmlReporter);
    }
    @BeforeClass
    public void ExecuteBeforeEveryClass() {
        environmentParameter = 2;
        isAPI = false;
        if (isAPI == true) {
            System.out.println( "This is an api Test");
            InitiateAPIConnection();
        } else {
            InitiateBrowser();
        }
    }
    @AfterClass
    public void ExecuteAfterClass(){
        extent.flush();
    }

    public void InitiateVariables(){
        REST_URL=dr.GetData("RestURL");
        GRANTSERVICE=dr.GetData("GrantService");
        REST_ENDPOINT=dr.GetData("Rest_EndPoint");
        API_VERSION=dr.GetData("API_Version");


        REST_USERNAME=dr.GetData("RestUserName");
        REST_PASSWORD=dr.GetData("RestPassword");
        CLIENTID =dr.GetData("ClientID");
        CLIENTSECRET=dr.GetData("ClientSecret");
        htmlReporter = new ExtentSparkReporter("ExtentReports/extentReport" + dtf.format(localDate) +"Integration.html");
        htmlReporter.config().setDocumentTitle("Text-Automation");
        htmlReporter.config().setReportName("Regression");
        htmlReporter.config().setTheme(Theme.DARK);
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment","TEST");
        extent.setReportUsesManualConfiguration(true);
        extent.attachReporter(htmlReporter);
    }
    public void InitiateAPIConnection(){
        //Before Class method runs one time before every execution (not before every test)
        InitiateVariables(); //Method in commonOps to initiate all variables of the target environment
        httpClient = HttpClientBuilder.create().build();
        String loginURL = REST_URL +
                GRANTSERVICE +
                "&client_id=" + CLIENTID +
                "&client_secret=" + CLIENTSECRET +
                "&username=" + REST_USERNAME +
                "&password=" + REST_PASSWORD;
        System.out.println("login url :" + loginURL);

        // Login requests must be POSTs
        httpPost = new HttpPost(loginURL);
        HttpResponse response = null;

        // Execute the login POST request
        try {
            response = httpClient.execute(httpPost);
            System.out.println("response : " + response);
        } catch (IOException cpException) {
            cpException.printStackTrace();
        }

        // verify response is HTTP OK - must be 200 otherwise will fail to connect.
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: "+statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return;
        }

        //store the response received in a getResult string
        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //define JSON Object and the access token that will be used to fetch the retrieved information.
        JSONObject jsonObject;
        String loginAccessToken = null;
        String loginInstanceUrl = null;

        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        baseLoginUrl = loginInstanceUrl;
        baseUri = loginInstanceUrl + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken) ;
        System.out.println("oauthHeader1: " + oauthHeader);
        System.out.println("\n" + response.getStatusLine());
        System.out.println("Successful login");
        System.out.println("instance URL: "+loginInstanceUrl);
        System.out.println("access token/session ID: "+loginAccessToken);
        System.out.println("baseUri: "+ baseUri);


    }

}
