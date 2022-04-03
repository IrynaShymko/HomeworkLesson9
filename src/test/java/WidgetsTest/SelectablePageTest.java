package WidgetsTest;

import Common.TestBase;
import Widgets.SelectablePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SelectablePageTest extends TestBase {

    @Tag("Widgets")
    @Tag("SelectablePage")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/WidgetsData/SelectablePageData.csv", delimiter = ';', numLinesToSkip = 1)
    public void selectData(String url, String value, int index) {
        driver.get(url);
        SelectablePage selectablePage = new SelectablePage(driver);
        selectablePage.selectSpeed()
                .selectFile(value)
                .selectNumber(index)
                .selectTitle();
    }
}
