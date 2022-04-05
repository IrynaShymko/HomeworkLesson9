package InteractionsTest;

import Common.TestBase;
import Interactions.Selectable;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SelectableTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("SelectableTest.class");

    @Tag("Interactions")
    @Tag("Selectable")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Interactions/Selectable.csv", delimiter = ';', numLinesToSkip = 1)
    public void shouldShowMessageAfterSelectRows(String url, String expectedMessage){
        driver.get(url);
        Selectable selectablePage = new Selectable(driver);
        selectablePage.clickRows();
        assertThat("Message is incorrect", selectablePage.getMessage(), equalTo(expectedMessage));
    }
}
