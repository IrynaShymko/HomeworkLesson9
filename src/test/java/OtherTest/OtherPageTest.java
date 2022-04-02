package OtherTest;

import Common.TestBase;
import Other.OtherPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("OtherPageTest.class");

    @Tag("Other")
    @Tag("OtherPage")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/high-site.php"})
    public void scrollToButton(String url) {
        driver.get(url);
        OtherPage otherPage = new OtherPage(driver);
        otherPage.scrollToElement()
                .takeScreenshot();
    }
}
