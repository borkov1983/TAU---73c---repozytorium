package settings;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static settings.Screenshot.screenshots;
import static settings.WebDriverInstance.getInstance;
import static settings.WebDriverInstance.quit;

public class SettingsTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        String url = "http://automationpractice.com";
        driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @After
    public void tearDown(){
        screenshots();
        driver.manage().deleteAllCookies();
        quit();
    }

    static final int WAIT_TIMEOUT = 10;
    private static WebDriverWait wait = new WebDriverWait(getInstance(), WAIT_TIMEOUT);

    public static void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
