package Workflows;

import Extensions.UserActions;
import Pages.CasesPage;
import Utilities.Operations;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class WebFlows extends Operations {
    public static void SearchInAppLauncher(String value) {
        UserActions.Click(mainPage.appLauncherBtn);
        UserActions.SendKeys(mainPage.appLauncherSearch, value);
        UserActions.Click(driver.findElement(By.xpath("//a[@data-label='" + value + "']/div/lightning-formatted-rich-text/span/p/b")));
    }




    public static void OpenSetup() throws InterruptedException {
            if (driver.findElements(By.xpath("//span[@title='Service Console' and text()='Service Console']")).size()>0) {
                UserActions.Click(mainPage.gearButton);
                UserActions.Click(mainPage.setupButton);
                OpenedNewTab();
                System.out.println("all setup");

            }
            else {
            UserActions.Click(mainPage.gearButton);
            UserActions.Click(mainPage.setupButton1);
            OpenedNewTab();
            System.out.println("related setup");

        }
    }

    public static void OpenAllListView() {
        UserActions.Click(mainPage.relatedListArrow);
        UserActions.Click(mainPage.allRelatedList);

    }
    public static void InsideIframes(WebElement element){
        driver.switchTo().frame(element);
        currentTest.info("Switched to Iframe");
        inIframe = true;
    }

    public static void OpenedNewTab() {
        for (String openTabs : driver.getWindowHandles()) {
            driver.switchTo().window(openTabs);
            switchTab = true;
        }
    }

    public static void SelectSessionType (WebElement sessionOrigin,WebElement sessionPicklist, String sessionTypeName) throws InterruptedException {
        WebFlows.SearchInAppLauncher("Cases");
        WebFlows.OpenAllListView();
        Thread.sleep(2000);
        UserActions.Click(casesPage.anyCase);
        UserActions.Click(inviteComponent.InviteGuest);
//        UserActions.ScrollAndClickElementIsInViewXpath(sessionOrigin);
        actions.moveToElement(sessionOrigin).perform();
        actions.doubleClick().perform();
        UserActions.Click(sessionPicklist);
        UserActions.Click(driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + sessionTypeName + "']")));
        UserActions.SendKeys(inviteComponent.EmailAddress, "levinguy21@gmail.com");
        Thread.sleep(10000);
        actions.moveToElement(inviteComponent.SendInviteButton).perform();
        actions.clickAndHold().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
////        driver.switchTo().newWindow(WindowType.TAB);
//        WebFlows.SearchInAppLauncher("Visual Remote Assistant Reports Images");
//        WebFlows.OpenAllListView();
        Thread.sleep(10000);
        OpenedNewTab();
        driver.manage().window().maximize();


        }

        //accountName can be any text
    public static void CreateNewAccount(String accountName) {
        UserActions.Click(mainPage.appLauncherBtn);
        UserActions.SendKeys(mainPage.appLauncherSearch, "Accounts");
        UserActions.Click(driver.findElement(By.xpath("//a[@data-label='Accounts']/div/lightning-formatted-rich-text/span/p/b")));
        UserActions.Click(mainPage.newRecordButton);
        UserActions.SendKeys(accountPage.accountName,accountName);
        UserActions.Click(mainPage.saveRecordButton);

    }
//Case Origin can be either "Email", "Phone" or "Web"
    public static void CreateNewCase(String caseOrigin) {
        UserActions.Click(mainPage.appLauncherBtn);
        UserActions.SendKeys(mainPage.appLauncherSearch, "Cases");
        UserActions.Click(driver.findElement(By.xpath("//a[@data-label='Cases']/div/lightning-formatted-rich-text/span/p/b")));
        UserActions.Click(mainPage.newRecordButton);
        UserActions.Click(casesPage.caseOriginPicklist);
        UserActions.Click(driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + caseOrigin + "']")));
        UserActions.Click(mainPage.saveRecordButton);

    }
// Salutation can be any value from the list ("Mr.","Ms.","Mrs.","Dr.","Prof."), lastName and company can be any value
    public static void CreateNewLead(String Salutation, String lastName, String company) {
        UserActions.Click(mainPage.appLauncherBtn);
        UserActions.SendKeys(mainPage.appLauncherSearch, "Leads");
        UserActions.Click(driver.findElement(By.xpath("//a[@data-label='Leads']/div/lightning-formatted-rich-text/span/p/b")));
        UserActions.Click(mainPage.newRecordButton);
        UserActions.Click(leadPage.salutation);
        UserActions.Click(driver.findElement(By.xpath("//span[text()='"+ Salutation+"']")));
        UserActions.SendKeys(leadPage.lastName,lastName);
        UserActions.SendKeys(leadPage.company,company);
        UserActions.Click(mainPage.saveRecordButton);

    }

    // WorkOrder doesn't have any required fields OOTB
    public static void CreateNewWorkOrder() throws InterruptedException {
        UserActions.Click(mainPage.appLauncherBtn);
        UserActions.SendKeys(mainPage.appLauncherSearch, "Work Orders");
        UserActions.Click(driver.findElement(By.xpath("//a[@data-label='Work Orders']/div/lightning-formatted-rich-text/span/p/b")));
        UserActions.Click(mainPage.newRecordButton);
        Thread.sleep(2000);
        actions.moveToElement(workOrderPage.woSaveButton).perform();
        actions.doubleClick().perform();

    }
    public static void CreateServiceAppointment(String accountName) {
        UserActions.Click(mainPage.appLauncherBtn);
        UserActions.SendKeys(mainPage.appLauncherSearch, "Service Appointments");
        UserActions.Click(driver.findElement(By.xpath("//a[@data-label='Service Appointments']/div/lightning-formatted-rich-text/span/p/b")));
        UserActions.Click(mainPage.newRecordButton);
        UserActions.Click(serviceAppointmentPage.searchAccountField);
        for (String openTabs : driver.getWindowHandles()) {
            driver.switchTo().window(openTabs);
        }
        UserActions.Click(serviceAppointmentPage.createAccountFields);
        UserActions.SendKeys(serviceAppointmentPage.newAccountName,accountName);
        actions.moveToElement(workOrderPage.woSaveButton).perform();
        actions.doubleClick().perform();
        driver.switchTo().defaultContent();
    }




    }







