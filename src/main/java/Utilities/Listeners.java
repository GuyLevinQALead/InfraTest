package Utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Listeners extends Operations implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        currentTest = extent.createTest("Test Name :"+iTestResult.getName());
        System.out.println("-------------------Starting test:"+iTestResult.getName()+"---------------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("-------------------Test succeeded:"+iTestResult.getName()+"---------------------");
        if (inIframe){
            driver.switchTo().defaultContent();
            currentTest.info("Exited Iframe");
            inIframe=false;
        }
        if (switchTab){
            driver.close();
            driver.switchTo().window(mainWindow);
            currentTest.info("Closed tab");
            System.out.println(switchTab);
            switchTab=false;

        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("-------------------Test failed:" + iTestResult.getName() + "---------------------");
        try {
            if (iTestResult.getStatus()==ITestResult.FAILURE) {

              takescreen(iTestResult);
              currentTest.fail("test failed");
            }
            System.out.println("test failed, taking image");

            if (inIframe){
                driver.switchTo().defaultContent();
                currentTest.info("Exited Iframe");
                inIframe=false;
            }
            if (switchTab){
                driver.close();
                driver.switchTo().window(mainWindow);
                currentTest.info("Closed tab");
                switchTab=false;


            }
            }
        catch (IOException e) {
              e.printStackTrace();
        }

      }



    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public String takescreen(ITestResult result) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File localScreenshots = new File(new File("target"), "screenshots");

        if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
            localScreenshots.mkdirs();
        }

        File screenshot = new File(localScreenshots, result.getName()+timeStamp+ ".png");
        FileUtils.moveFile(imageFile, screenshot);

        System.out.println(screenshot.getAbsolutePath());

        String extentScrnshot =screenshot.getAbsolutePath();

        return extentScrnshot;
    }

}
