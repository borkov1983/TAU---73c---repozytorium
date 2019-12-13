package pages;

import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static settings.Screenshot.screenshots;

public class MainPage extends InitialPage {

    public MainPage() {

        super();
    }

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement clickSignIn;

    @Step
    public SignIn SignInPage(){
        clickSignIn.click();
        screenshots();
        return new SignIn();
    }
}
