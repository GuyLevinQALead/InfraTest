//package Demo;
//
//import Utilities.Base;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.FixMethodOrder;
//import org.junit.runners.MethodSorters;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//public class SecondSuite extends Base {
//
//
//    @Test
//    public  void test1() throws InterruptedException {
//        ChromeOptions p = new ChromeOptions();
//        p.addArguments("--disable-notifications");
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//        driver.get(url);
//        driver.manage().window().maximize();
//        driver.findElement(By.id("username")).sendKeys("guy.techseelevin@techsee.me");
//        driver.findElement(By.id("password")).sendKeys("zzZAQXSW321!!!!!!!");
//        driver.findElement(By.id("Login")).click();
//        WebElement Applauncher = driver.findElement(By.className("slds-icon-waffle"));
//        System.out.println(Applauncher.getTagName());
//        Assert.assertTrue(Applauncher.isDisplayed());
//    }
//
//    @Test(dependsOnMethods ="test1")
//    public void test2() throws InterruptedException {
//        driver.findElement(By.xpath("//input[@type='search' and @placeholder='Quick Find']")).click();
//        driver.findElement(By.xpath("//input[@type='search' and @placeholder='Quick Find']")).sendKeys("profile");
//        Thread.sleep(5000);
////        driver.findElement(By.className("highlight")).click();
//        driver.findElement(By.xpath("//mark[@class='highlight']")).click();
//        Thread.sleep(5000);
//        WebElement FrameProfile = driver.findElement(By.xpath("//iframe[@title='Profiles ~ Salesforce - Developer Edition']"));
//        driver.switchTo().frame(FrameProfile);
//        iframe=true;
//        WebElement ProfilePage = driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType' and text()='Profiles']"));
//        Assert.assertTrue(ProfilePage.isDisplayed());
//        driver.switchTo().defaultContent();
//        iframe=false;
//        System.out.println(iframe);
//    }
//}
