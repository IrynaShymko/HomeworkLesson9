package WidgetsTest;

import Common.TestBase;
import Widgets.SelectablePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectablePageTest extends TestBase {

    @Tag("Widgets")
    @Tag("SelectablePage")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/WidgetsData/SelectablePageData.csv", delimiter = ';', numLinesToSkip = 1)
    public void selectData(String url, String value, int index) throws InterruptedException {
        driver.get(url);
        SelectablePage selectablePage = new SelectablePage(driver);
        selectablePage.selectSpeed()
                .selectFile(value)
                .selectNumber(index)
                .selectTitle();
    }
}
