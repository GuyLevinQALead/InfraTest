package Extensions;

import Utilities.Listeners;
import Utilities.Operations;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Verification extends Operations {
    public static void VerifyElementIsPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
        currentTest.pass(element.getText() +" is Displayed");
    }

    public static void VerifyIfTwoStringsAreEqualByAtribute (WebElement actual,String atribute, String expected) {

     try {
         wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getAttribute(atribute), expected);
         currentTest.pass(actual.getAttribute(atribute) + " and " + expected + " are identical!");
     }
     catch(AssertionError e)
     {
         System.out.println("Assertion error. ");
         Assert.fail(actual.getAttribute(atribute) + " and " + expected + " are Not identical!");
//         currentTest.fail(actual.getAttribute(atribute) + " and " + expected + " are Not identical!");

     }

    }

    public static void VerifyIfElementIsFalse(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertFalse(element.isDisplayed());

    }
    public static void VerifyIfAttributeIsFalse(WebElement element, String atr,String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getAttribute(atr) == value);
        currentTest.pass("Both Strings are identical!");

    }

}
