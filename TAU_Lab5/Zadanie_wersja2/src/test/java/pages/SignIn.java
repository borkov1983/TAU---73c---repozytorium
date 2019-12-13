package pages;

import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static settings.Screenshot.screenshots;

public class SignIn extends InitialPage {
    public SignIn() {
        super();
    }

    @FindBy(css = "[name =\"email_create\"]")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreate;

    private void inputEmailAddress(String email){
        emailInput.sendKeys(email);
    }

    @Step
    public SignUp clickButtonCreateAnAccount(){
        inputEmailAddress("s15805@wp20.pl");
        screenshots();
        submitCreate.click();
        return new SignUp();
    }
}
