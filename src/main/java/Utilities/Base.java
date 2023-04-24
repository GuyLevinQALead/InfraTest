package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Base {
    public static WebDriver driver;
    public static WebDriverManager driverManager;
    public  static boolean iframe= false;
//    public static String url= "https://keeptesting2-dev-ed.my.salesforce.com/index.jsp?ec=20037&eco=1";
    public static Pages.LoginPage loginPage;
    public static Pages.MainPage mainPage;
    public static Pages.AccountPage accountPage;
    public static Pages.SetupPage setupPage;
    public static Pages.CasesPage casesPage;
    public static Pages.InviteComponent inviteComponent;
    public static Pages.LeadPage leadPage;
    public static Pages.ServiceAppointmentPage serviceAppointmentPage;
    public static Pages.WorkOrderPage workOrderPage;
    public static Actions actions;
    protected static WebDriverWait wait;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter htmlReporter;
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
    public static  LocalDate localDate = LocalDate.now();




}
