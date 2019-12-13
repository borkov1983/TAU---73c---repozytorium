package tests;

import org.junit.Test;
import pages.ClickRegister;
import pages.Register;
import settings.SettingsTest;

public class TestsForBrowserSpot extends SettingsTest {

    @Test
    public void testClickPages(){

        new ClickRegister().testForGetCurrentPage();
    }

    @Test
    public void testRegisterField(){

        new Register().withCorrectData();
    }

    @Test
    public void testMessageText(){

        new Register().withIncorrectLogin();
    }

    @Test
    public void testEmailText(){

        new Register().withIncorrectEmail();
    }

}
