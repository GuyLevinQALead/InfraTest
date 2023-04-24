package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(xpath = "//input[@name='Name']")
    public WebElement accountName;


}
