package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadPage {
    @FindBy(xpath="//button[@name='salutation']")
    public WebElement salutation;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath="//input[@name='Company']")
    public WebElement company;

//    @FindBy(xpath="//button[@name='Company']")
//    public WebElement leadStatus;
}
