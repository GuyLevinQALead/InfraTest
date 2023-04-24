package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkOrderPage {
    @FindBy (xpath ="//button[@title='Save']")
    public WebElement woSaveButton;
}
