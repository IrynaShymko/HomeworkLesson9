package WidgetsTest;

import Common.TestBase;
import Widgets.AutocompletePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutocompletePageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("AutocompletePageTest.class");

    @Tag("Basic")
    @Tag("Autocomplete")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/WidgetsData/AutocompleteData.csv", delimiter = ';', numLinesToSkip = 1)
    public void completeSearchField(String url, String value) {
        driver.get(url);
        AutocompletePage autocompletePage = new AutocompletePage(driver);
        autocompletePage.fillSearchField(value);
        String choice = autocompletePage.selectValueFromList();
        String text = autocompletePage.getTextFromSearchField();
        logger.info("Choice is: "+ choice);
        logger.info("Text in search field is: "+ text);
        assertThat("Text in search field does not match with choice value", text, equalTo(choice));
    }
}
