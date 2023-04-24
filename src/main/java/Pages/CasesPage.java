package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasesPage {
    //Find any case on the case list view
    @FindBy (xpath = "//a[contains(@data-recordid, '500')]")
    public  WebElement anyCase;

    @FindBy (xpath = "//button[@aria-label='Case Origin, --None--']")
    public  WebElement caseOriginPicklist;


}
