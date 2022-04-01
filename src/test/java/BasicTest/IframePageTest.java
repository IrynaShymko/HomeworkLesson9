package BasicTest;

import Basic.IframePage;
import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IframePageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("IframePageTest.class");

    @Tag("Basic")
    @Tag("Iframe")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/IframePageData/IframePageData.csv", delimiter = ';', numLinesToSkip = 1)
    public void shouldFillIframesAndClickBasicDropdown(String url, String firstName, String surname, String login, String password) {
        driver.get(url);
        IframePage iframePage = new IframePage(driver);
        iframePage.fillIframe1(firstName, surname)
                .fillIframe2(login, password)
                .clickBasicMenuDropdown()
                .takeScreenshot();
    }
}
