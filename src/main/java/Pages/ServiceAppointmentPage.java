package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceAppointmentPage {
    @FindBy (xpath = "//input[@title='Search Accounts']")
    public WebElement searchAccountField;

    @FindBy (xpath = "//span[@title='New Account']")
    public WebElement createAccountFields;

    @FindBy (xpath = "//span[text()='Account Name']//following::input[1]")
    public WebElement newAccountName;
}
