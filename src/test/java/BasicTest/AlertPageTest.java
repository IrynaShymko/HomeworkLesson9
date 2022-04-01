package BasicTest;

import Basic.AlertPage;
import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlertPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("AlertPageTest.class");

    @Tag("Basic")
    @Tag("Alert")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/AlertPageData/SimpleAlertData.csv", delimiter = ';')
    public void shouldShowMessageAfterAcceptSimpleAlert(String url, String expectedMessage) {
        driver.get(url);
        AlertPage alertPage = new AlertPage(driver);
        alertPage.acceptSimpleAlertButton();
        assertThat("Incorrect text after is shown confirmation Simple Alert", alertPage.getSimpleAlertConfirmationMessage(), equalTo(expectedMessage));
    }

    @Tag("Basic")
    @Tag("Alert")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/AlertPageData/PromptAlertBoxData.csv", delimiter = ';')
    public void shouldShowMessageAfterAcceptPrompt(String url, String dataForPrompt, String expectedMessage) {
        driver.get(url);
        AlertPage alertPage = new AlertPage(driver);
        alertPage.acceptPromptAlertBox(dataForPrompt);
        assertThat("Incorrect text after is shown confirmation Prompt Alert", alertPage.getPromptConfirmationMessage(), equalTo(expectedMessage));
    }

    @Tag("Basic")
    @Tag("Alert")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/AlertPageData/ConfirmAlertBoxData.csv", delimiter = ';')
    public void shouldShowMessageAfterAcceptConfirmAlertBox(String url, String expectedMessage1, String expectedMessage2) {
        driver.get(url);
        AlertPage alertPage = new AlertPage(driver);
        alertPage.acceptConfirmAlertBox();
        assertThat("Incorrect text of accepted Confirmation Alert Box", alertPage.getConfirmAlertBoxConfirmationMessage(), equalTo(expectedMessage1));
        alertPage.dismissConfirmAlertBox();
        assertThat("Incorrect text of cancelled Confirmation Alert Box", alertPage.getConfirmAlertBoxConfirmationMessage(), equalTo(expectedMessage2));
    }

    @Tag("Basic")
    @Tag("Alert")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/AlertPageData/DelayedAlertData.csv", delimiter = ';')
    public void shouldShowMessageAfterAcceptDelayedAlert(String url, String expectedMessage) {
        driver.get(url);
        AlertPage alertPage = new AlertPage(driver);
        alertPage.acceptDelayedAlert();
        assertThat("Incorrect text of Delayed Alert", alertPage.getDelayedAlertConfirmationMessage(), equalTo(expectedMessage));
    }
}
