package settings;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static settings.Screenshot.screenshots;
import static settings.WebDriverInstance.quit;
import static settings.WebDriverInstance.getInstance;
import java.util.concurrent.TimeUnit;

public class SettingsTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        String url = "https://app.browserspot.com/login";
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


}
