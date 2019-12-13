package settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Create class to open firefox in current time add we don't have to create object WebDriver

public class WebDriverInstance {
    private static WebDriver driver;
    private WebDriverInstance(){};

    public static WebDriver getInstance(){
        if(null == driver){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void quit(){
        if(null != driver){
            driver.quit();
        }
        driver = null;
    }
}
