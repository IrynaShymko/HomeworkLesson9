package WidgetsTest;

import Common.TestBase;
import Widgets.ModalDialogPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ModalDialogPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("ModalDialogPageTest.class");

    @ParameterizedTest
    @MethodSource("Common.DataProviders#setNewUser")
    public void createNewUser(String url, String name, String email, String password) {
        driver.get(url);
        ModalDialogPage modalDialogPage = new ModalDialogPage(driver);
        modalDialogPage.clickCreateNewUserButton();
        String modalWindow = driver.getWindowHandle();
        driver.switchTo().window(modalWindow);
        modalDialogPage.fillName(name);
        modalDialogPage.fillEmail(email);
        modalDialogPage.fillPassword(password);
        modalDialogPage.clickCreateAccountButton();
        assertThat("Name is incorrect", modalDialogPage.getAddedName(), equalTo(name));
        assertThat("Email is incorrect", modalDialogPage.getAddedEmail(), equalTo(email));
        assertThat("password is incorrect", modalDialogPage.getAddedPassword(), equalTo(password));
    }
}
