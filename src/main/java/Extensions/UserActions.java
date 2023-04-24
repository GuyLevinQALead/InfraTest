package Extensions;

import Utilities.Operations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class UserActions extends Operations {
    public static void Click (WebElement element)  {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        currentTest.info("Clicked on element ");
    }

//    public static  void ClickOnSessionType (WebElement element)  {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        List <WebElement> SessionType;
//        SessionType = driver.findElements(By.xpath("//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain' and @role='option']" ));
//        SessionType.
//        currentTest.info("Clicked on element ");
//    }

        public static void SendKeys (WebElement element, String txt_string){
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(txt_string);
            currentTest.info("Entered "+txt_string+ " inside");

        }

        public static void ScrollAndClickElementIsInViewXpath(WebElement element) throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOf(element));
            UserActions.Click(element);
        }
}
