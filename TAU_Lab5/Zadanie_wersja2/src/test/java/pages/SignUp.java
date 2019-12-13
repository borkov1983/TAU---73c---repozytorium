package pages;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static settings.Screenshot.screenshots;

public class SignUp extends InitialPage {

    public SignUp() {
        super();
    }

    @FindBy(id = "id_gender1")
    private WebElement radioButtonMale;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement birthday;

    @FindBy(id = "months")
    private WebElement birthmonth;

    @FindBy(id = "years")
    private WebElement birthyear;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "phone_mobile")
    private WebElement phone;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(css = "#center_column > .alert li")
    private List<WebElement> wrongMessage;

    private void fillAllInRegistrationForm(boolean isCorrect){
        radioButtonMale.click();
        if (isCorrect) {firstName.sendKeys("Mich");}
        lastName.sendKeys("Bor");
        password.sendKeys("haslo12!");
        new Select(birthday).selectByValue("15");
        new Select(birthmonth).selectByValue("1");
        new Select(birthyear).selectByValue("1983");
        address.sendKeys("Cwiartki");
        city.sendKeys("Gdansk");
        new Select(state).selectByValue("6");
        postCode.sendKeys("12345");
        phone.sendKeys("111222333");

    }

    @Step
    public Account withCorrectData(){
        fillAllInRegistrationForm(true);
        screenshots();
        registerButton.click();
        return new Account();
    }

    @Step
    public SignUp withIncorrectData(){
        fillAllInRegistrationForm(false);
        screenshots();
        registerButton.click();
        return this;
    }

    @Step
    public void viewAlert(){
        String EXPECTED = "firstname is required.";
        Assert.assertThat(allWrongMessage(), IsCollectionContaining.hasItem(EXPECTED));
    }

    private List<String> allWrongMessage() {
        List<String> alertMessages = new ArrayList<String>();

        for(WebElement message : wrongMessage) {
            alertMessages.add(message.getText());
        }
        System.out.println(alertMessages);
        return alertMessages;
    }
}
