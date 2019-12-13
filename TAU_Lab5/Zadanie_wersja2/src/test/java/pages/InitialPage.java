package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static settings.SettingsTest.waitForVisibilityOfElement;
import static settings.WebDriverInstance.getInstance;


public class InitialPage {

    public InitialPage() {

        PageFactory.initElements(getInstance(), this);
        waitForVisibilityOfElement(mainView);
    }

    @FindBy(id = "columns")
    private WebElement mainView;
}
