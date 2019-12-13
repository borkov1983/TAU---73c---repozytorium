package tests;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import settings.SettingsTest;

public class TestsForAutomationPractise extends SettingsTest {
    private WebDriver driver;
    @Test
    public void RegisterSuccessfully(){

        new MainPage()
                .SignInPage()
                .clickButtonCreateAnAccount()
                .withCorrectData()
                .registeredWithSuccess();
    }

    @Test
    public void RegisterFailed(){
         //driver.manage().window().setSize(new Dimension(400, 600));
        new MainPage()
                .SignInPage()
                .clickButtonCreateAnAccount()
                .withIncorrectData()
                .viewAlert();
    }
}
