package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class Account extends InitialPage{
    public Account() {
        super();
    }
    @FindBy(css = "#center_column > h1")
    private WebElement infoInPage;

    @Step
    public void registeredWithSuccess() {
        String textInfoInPage = infoInPage.getText();
        String expectedText = "MY ACCOUNT";

        Assert.assertThat(textInfoInPage, IsEqual.equalTo(expectedText));
    }
}
