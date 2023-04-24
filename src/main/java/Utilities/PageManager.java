package Utilities;

import Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

public class PageManager extends Base{
    public static void InitiatePages(){
        loginPage= PageFactory.initElements(driver,Pages.LoginPage.class);
        mainPage= PageFactory.initElements(driver,Pages.MainPage.class);
        accountPage=PageFactory.initElements(driver,Pages.AccountPage.class);
        setupPage=PageFactory.initElements(driver,Pages.SetupPage.class);
        casesPage=PageFactory.initElements(driver,Pages.CasesPage.class);
        inviteComponent=PageFactory.initElements(driver,Pages.InviteComponent.class);
         leadPage=PageFactory.initElements(driver,Pages.LeadPage.class);
         serviceAppointmentPage=PageFactory.initElements(driver,Pages.ServiceAppointmentPage.class);
         workOrderPage=PageFactory.initElements(driver,Pages.WorkOrderPage.class);

    }
}
