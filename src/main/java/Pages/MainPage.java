package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy (xpath="//a[@class='menuTriggerLink slds-button slds-button_icon slds-button_icon slds-button_icon-container slds-button_icon-small slds-global-actions__setup slds-global-actions__item-action']")
    public WebElement gearButton;

    @FindBy (id="all_setup_home")
    public WebElement setupButton;

    @FindBy (id="related_setup_app_home")
    public WebElement setupButton1;

    @FindBy (xpath="//span[@class='userProfileCardTriggerRoot oneUserProfileCardTrigger' and @data-aura-class='oneUserProfileCardTrigger']")
    public WebElement profileButton;

    @FindBy (xpath="//div[@title='User Detail' and text()='User Detail']")
    public WebElement userDetailBtn;

    @FindBy (xpath="//a[@class='profile-link-label' and text()='Guy Levin']")
    public WebElement userNameBtn;

    @FindBy (className = "slds-icon-waffle")
    public WebElement appLauncherBtn;

    @FindBy (xpath = "//input[@placeholder='Search apps and items...']")
    public WebElement appLauncherSearch;


    @FindBy (xpath = "//span[@class='slds-var-p-right_x-small' and text()='Cases']")
    public WebElement casesPage;

    @FindBy (xpath = "//span[@title='Service Console' and text()='Service Console']")
    public WebElement serviceConsoleAppName;

    @FindBy (xpath = "//lightning-icon[@class='slds-icon-utility-down slds-button__icon slds-icon_container forceIcon']")
    public WebElement relatedListArrow;

    @FindBy (xpath = "//span[text()[contains(.,'All ')]]")
    public WebElement allRelatedList;

    @FindBy (xpath = "//div[@title='New']")
    public WebElement newRecordButton;

    @FindBy (xpath = "//div[@role='alertdialog' and @data-key='success']")
    public WebElement successToastMessage;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement saveRecordButton;
}
