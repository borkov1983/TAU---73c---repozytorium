package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static settings.WebDriverInstance.getInstance;


public class InitialPage {

    public InitialPage() {

        PageFactory.initElements(getInstance(), this);
    }

    @FindBy(css = "class=\"login-template welcome-template\"")
    private WebElement mainView;
}
