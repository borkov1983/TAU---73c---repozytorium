package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import settings.SettingsTest;

import static settings.Screenshot.screenshots;

public class ClickRegister extends SettingsTest {

    private WebDriver driver = new FirefoxDriver();

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement currentURL;

    public void currentPage(){
        driver.get("https://app.browserspot.com/login");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        //String currentUrl1 = driver.getWindowHandle();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://app.browserspot.com/registration",
                currentUrl);
    }

    @Step
    public void testForGetCurrentPage(){
        currentPage();
        screenshots();
    }
}
