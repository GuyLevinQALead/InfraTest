package Demo;

import Extensions.UserActions;
import Extensions.Verification;
import Pages.CasesPage;
import Utilities.Operations;
import Workflows.WebFlows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

    @Listeners(Utilities.Listeners.class)
public class FirstSuite extends Operations {

        @BeforeClass
    public void Login() throws InterruptedException {
            System.out.println(environmentParameter);
            if (environmentParameter ==1) {
                UserActions.SendKeys(loginPage.txt_username, dr.GetData("username"));
                UserActions.SendKeys(loginPage.txt_password, dr.GetData("password"));
            }
            else {
                UserActions.SendKeys(loginPage.txt_username, dr.GetData("usernameprod"));
                UserActions.SendKeys(loginPage.txt_password, dr.GetData("passwordprod"));

            }
        UserActions.Click(loginPage.txt_loginButton);
        Verification.VerifyElementIsPresent(mainPage.appLauncherBtn);
        mainWindow=driver.getWindowHandle();
    }

    @Test
    public void VerifyTags() throws InterruptedException {
            Thread.sleep(2000);
        System.out.println(mainPage.appLauncherBtn.getTagName());
        Verification.VerifyIfTwoStringsAreEqualByAtribute(mainPage.appLauncherBtn,"tagName","DIV");
    }



    @Test (description  = "test")
    public void ProfileSetupList() throws InterruptedException {
        UserActions.Click(setupPage.setupSearch);
        UserActions.SendKeys(setupPage.setupSearch,"profile");
        UserActions.Click(setupPage.profileList);
        WebElement FrameProfile = setupPage.profileIframe;
        driver.switchTo().frame(FrameProfile);
        iframe=true;
        WebElement ProfilePage = setupPage.profileListHeader;
        Verification.VerifyElementIsPresent(ProfilePage);
        driver.switchTo().defaultContent();
        iframe=false;
        System.out.println(iframe);
    }
    @Test
      public void MainSearchTst() throws InterruptedException {
            Thread.sleep(2000);
        UserActions.SendKeys(setupPage.setupMainSearchBtn,"Guy");
        actions.sendKeys(Keys.ENTER).build().perform();
        Verification.VerifyElementIsPresent(setupPage.searchedResults);
        setupPage.UsersList.click();
        List<WebElement> myList=driver.findElements(By.className("setupLink"));
        System.out.println(myList.size());
        List<String> all_elements_text=new ArrayList<>();

        for(int i=0; i<myList.size(); i++){

            //loading text of each element in to array all_elements_text
            all_elements_text.add(myList.get(i).getText());

            //to print directly
            System.out.println(myList.get(i).getText());

        }

    }

    @Test
    public void VerifyFlowUserIsBlank() throws InterruptedException {
    UserActions.Click(mainPage.profileButton);
        UserActions.Click(mainPage.userNameBtn);
        UserActions.Click(mainPage.userDetailBtn);

       WebFlows.InsideIframes(setupPage.UserDetailsIframe);
       Thread.sleep(3000);
        List<WebElement> checkBoxList=driver.findElements(By.xpath("//td[@class='labelCol' and text()='Flow User']//following::img[@class='checkImg']"));
       String checkboxValue = (checkBoxList.get(0).getAttribute("title"));
        System.out.println(checkboxValue);
        Verification.VerifyIfTwoStringsAreEqualByAtribute (checkBoxList.get(0),"title","Checked");

    }
        @Test
        public void SearchForCaseObject() throws InterruptedException {
            WebFlows.SearchInAppLauncher("Cases");
            try {
                Verification.VerifyElementIsPresent(mainPage.casesPage);
                System.out.println(mainPage.casesPage.getText());
            }
            catch (Exception e){
                WebFlows.OpenAllListView();
                Thread.sleep(2000);
                WebFlows.OpenSetup();
                System.out.println(e);
            }
    }

    @Test
    public void SendSession() throws InterruptedException {
            WebFlows.SelectSessionType(inviteComponent.InviteByEmail, inviteComponent.SessionTypePicklistEmail, "Photo");
    }

    @Test
        public void CreateNewAccount () {
        WebFlows.CreateNewAccount("Test");
        Verification.VerifyElementIsPresent(mainPage.successToastMessage);
    }
        @Test
        public void CreateNewCase () {
            WebFlows.CreateNewCase("Email");
            Verification.VerifyElementIsPresent(mainPage.successToastMessage);
        }
        @Test
        public void CreateNewLead () {
            WebFlows.CreateNewLead("Prof.","Levin","Automation");
            Verification.VerifyElementIsPresent(mainPage.successToastMessage);
        }
        @Test
        public void CreateNewWorkOrder () throws InterruptedException {
            WebFlows.CreateNewWorkOrder();
            Verification.VerifyElementIsPresent(mainPage.successToastMessage);
        }
        @Test
        public void CreateNewServiceAppointment () throws InterruptedException {
            WebFlows.CreateServiceAppointment("Guy1");
            Verification.VerifyElementIsPresent(mainPage.successToastMessage);
        }
}
