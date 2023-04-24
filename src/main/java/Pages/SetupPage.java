package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetupPage {
    @FindBy (xpath ="//input[@type='search' and @placeholder='Quick Find']")
            public WebElement setupSearch;
    @FindBy (xpath ="//mark[text()='Profile']")
    public WebElement profileList;

    @FindBy (xpath ="//iframe[@title='Profiles ~ Salesforce - Developer Edition']")
    public WebElement profileIframe;

    @FindBy (xpath ="//h1[@class='noSecondHeader pageType' and text()='Profiles']")
    public WebElement profileListHeader;

    @FindBy (xpath ="//input[@title='Search Setup']")
    public WebElement setupMainSearchBtn;

    @FindBy (xpath ="//h1[text()='Search Results']")
    public WebElement searchedResults;

    @FindBy (xpath ="//span[@class='slds-col scopesItem_name slds-truncate' and text()='Users']")
    public WebElement UsersList;

    @FindBy (xpath ="//iframe[@title='User: Guy Levin ~ Salesforce - Developer Edition']")
    public WebElement UserDetailsIframe;

    @FindBy (xpath ="//iframe[@title='User: Guy Levin ~ Salesforce - Developer Edition']")
    public WebElement FlowUserCheckbox;


}
