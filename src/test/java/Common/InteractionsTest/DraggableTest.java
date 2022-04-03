package Common.InteractionsTest;

import Common.TestBase;
import Interactions.Draggable;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DraggableTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("DraggableTest.class");

    @Tag("Interactions")
    @Tag("Draggable")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Interactions/DraggableData.csv", delimiter = ';', numLinesToSkip = 1)
    public void shouldMoveSquare(String url, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        driver.get(url);
        Draggable draggable = new Draggable(driver);
        draggable.move(x1, y1);
        draggable.takeScreenshot();

        draggable.move(x2, y2);
        draggable.takeScreenshot();

        draggable.move(x3, y3);
        draggable.takeScreenshot();

        draggable.move(x4, y4);
        draggable.takeScreenshot();
    }
}