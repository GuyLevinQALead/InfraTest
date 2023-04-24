package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InviteComponent {
    @FindBy (xpath = "//button[@name='email']")
    public WebElement InviteByEmail;

    @FindBy (xpath = "//button[@name='sms']//parent::h3//parent::div")
    public WebElement InviteBySms;
    //button[@name='sms']//parent::h3
    //h3[@class='slds-section__title']//following::button[@name='sms']/lightning-primitive-icon

    @FindBy (xpath = "//button[@name='sms']//following::button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value' and contains (@aria-label,'Session type')]")
    public WebElement SessionTypePicklistSms;

    @FindBy (xpath = "//button[@name='email']//following::button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value' and contains (@aria-label,'Session type')][1]")
    public WebElement SessionTypePicklistEmail;

    @FindBy (xpath = "//a[@class='slds-tabs_default__link' and @data-label='Invite Guest']")
    public WebElement InviteGuest;

    @FindBy (xpath = "//div[@class='slds-form-element__control slds-grow']//following::input[@class='slds-input'][1]")
    public WebElement EmailAddress;

    @FindBy (xpath = "//a[@class='slds-tabs_default__link' and @data-label='Invite Guest']")
    public WebElement EmailLanguage;

    @FindBy (xpath = "//a[@class='slds-tabs_default__link' and @data-label='Invite Guest']")
    public WebElement MobileCountryCode;

    @FindBy (xpath = "//a[@class='slds-tabs_default__link' and @data-label='Invite Guest']")
    public WebElement MobilePhone;

    @FindBy (xpath = "//a[@class='slds-tabs_default__link' and @data-label='Invite Guest']")
    public WebElement MobileLanguage;

    @FindBy (xpath = "//a[@class='slds-tabs_default__link' and @data-label='Invite Guest']")
    public WebElement MobileAudio;

    @FindBy (xpath = "//button[@type='button' and @name='SendSMS']")
    public WebElement SendInviteButton;

    @FindBy (xpath = "//img[@class='ts-menu-icon']//parent::div")
    public WebElement EndSessionWindow;




}
