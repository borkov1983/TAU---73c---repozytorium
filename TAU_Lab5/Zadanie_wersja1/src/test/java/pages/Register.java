package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static settings.Screenshot.screenshots;

public class Register extends InitialPage {
    public Register()  {
        super();
    }
    private WebDriver driver;

    @FindBy(css = ".form-wrapper > form:nth-child(2) > div:nth-child(3) > button:nth-child(1)")
    private WebElement signIn;

    @FindBy(css = "div.input-wrapper:nth-child(1) > input:nth-child(2)")
    private WebElement emailLogin;

    @FindBy(css = "div.input-wrapper:nth-child(2) > input:nth-child(2)")
    private WebElement passwordLogin;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement registerButton;

    @FindBy(css = "input[name=\"firstname\"]")
    private WebElement firstname;

    @FindBy(css = "input[name=\"lastname\"]")
    private WebElement lastname;

    @FindBy(css = "input[name=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@name=\"password_confirmation\"]")
    private WebElement confirmPassword;

    @FindBy(css = ".fake-input")
    private WebElement language;

    @FindBy(xpath = "/html/body/div/section/div/div[2]/div[2]/form/div[6]/div/div[2]/div/span[2]")
    private WebElement polish;

    @FindBy(css = ".checkbox > span:nth-child(2)")
    private WebElement checkbox;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUp;

    @FindBy(css = ".app-alert")
    private WebElement message;

    @FindBy(css = "div.input-wrapper:nth-child(3) > span:nth-child(3)")
    private WebElement messageEmail;

    public void fillAllInRegistrationForm(boolean isCorrect){
        registerButton.click();
        firstname.sendKeys("Michal");
        lastname.sendKeys("Bor");
        email.sendKeys("bor@wp1.pl");
        password.sendKeys("haslo12!");
        confirmPassword.sendKeys("haslo12!");
        checkbox.click();
        language.click();
        polish.click();
    }

    @Step
    public void withCorrectData(){
        fillAllInRegistrationForm(true);
        screenshots();
    }

    public void incorrectLoginTest() {
        emailLogin.sendKeys("test");
        passwordLogin.sendKeys("test");
        signIn.click();
        Assert.assertTrue(message.isDisplayed());
    }
    @Step
    public void withIncorrectLogin(){
        incorrectLoginTest();
        screenshots();
    }

    public void incorrectEmailTest() {
        registerButton.click();
        email.sendKeys("@.pl");
        Assert.assertTrue(messageEmail.isDisplayed());
    }

    @Step
    public void withIncorrectEmail(){
        incorrectEmailTest();
        screenshots();
    }
}
