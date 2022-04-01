package InteractionsTest;

import Common.TestBase;
import Interactions.Resizable;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResizableTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("ResizableTest.class");

    @Tag("Basic")
    @Tag("Form")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Interactions/ResizableData.csv", delimiter = ';', numLinesToSkip = 1)
    public void resizeWindow(String url, int x1, int y1, int x2, int y2, int x3, int y3) {
        driver.get(url);
        Resizable resizablePage = new Resizable(driver);
        resizablePage.resizeWindow(x1, y1);
        resizablePage.resizeWindow(x2, y2);
        resizablePage.resizeWindow(x3, y3);
    }
}
