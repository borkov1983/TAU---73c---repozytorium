package settings;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import static settings.WebDriverInstance.getInstance;
public class Screenshot {

    @Attachment(value="Screenshot", type="image/png")
    public static byte[] screenshots() {
        return ((TakesScreenshot) getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
